import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 *
 * MIT License
 *
 * Copyright (c) 2021 Abdalaziz Alsaydi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class CouchDbWriter implements DatabaseWriter {

    private final HttpClient client;
    private URI couchDbURI;

    public CouchDbWriter() {
        client = HttpClient.newHttpClient();
    }

    @Override
    public void init(String couchDBUrl) throws IOException, SQLException {
        this.couchDbURI = URI.create(couchDBUrl);
        try {
            createDatabase(couchDBUrl);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new IOException(e);
        }
    }

    private void createDatabase(String couchDBUrl) throws IOException, InterruptedException {
        var authHeader = getAuthHeaderValue();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(couchDBUrl))
                .header("Content-Type", "application/json").PUT(HttpRequest.BodyPublishers.ofString(""))
                .header("Authorization", authHeader).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 201) {
            System.err.println(response.body());
            throw new IOException("Failed to create database");
        }
    }

    private String getAuthHeaderValue() {
        var DEFAULT_USER = "admin";
        var DEFAULT_PASSWORD = "123";
        var encodedAuthHeader = "Basic " + java.util.Base64.getEncoder().encodeToString((DEFAULT_USER + ":" + DEFAULT_PASSWORD).getBytes());
        var authHeader = new String(encodedAuthHeader);
        return authHeader;
    }

    @Override
    public void write(HashMap<String, WordData> wordDataHashMap) throws SQLException {
        var authHeader = getAuthHeaderValue();
        for (var entry : wordDataHashMap.entrySet()) {
            var word = entry.getKey();
            var wordData = entry.getValue();
            var jsonMap = new HashMap<String, Object>();
            jsonMap.put("word", word);
            jsonMap.put("roots", wordData.getRoots());
            jsonMap.put("voweledWords", wordData.getVoweledForms());
            var putUri = couchDbURI.resolve("/sarf/"+ normalizeKey(word));
            System.out.println(putUri);
            var objectMapper = new ObjectMapper();
            var jsonString = "";
            try {
                jsonString = objectMapper.writeValueAsString(jsonMap);
            } catch (JsonProcessingException e1) {
                throw new SQLException("failed to convert to JSON.");
            }
            var putRequest = HttpRequest.newBuilder()
                            .uri(putUri)
                            .header("Content-Type", "application/json")
                            .header("Authorization", authHeader)
                            .PUT(HttpRequest.BodyPublishers.ofString(jsonString))
                            .build();
            try {
                var response = client.send(putRequest, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() != 201) {
                    System.err.println(response.body());
                    throw new SQLException("Failed to write to database");
                }
            } catch (IOException | InterruptedException e) {
                System.err.println(e.getMessage());
                throw new SQLException("Failed to write to database");

            }
        }
    }

    private String normalizeKey(String word) {
        word = word.replaceAll(" ", "");
        word = word.replaceAll("/", "-");
        return word.trim();
    }

    @Override
    public void close() throws IOException {
    }
}
