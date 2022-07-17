import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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

    private static final int BATCH_SIZE = 10000;
    private final HttpClient client;
    private URI couchDbURI;
    private String username = "admin";
    private String password = "123";
    private String databaseName;

    public CouchDbWriter() {
        client = HttpClient.newHttpClient();
    }

    private static String normalizeKey(String word) {
        return word.trim();
    }

    @Override
    public void init(String couchDBUrl) throws DatabaseWriterException {
        this.couchDbURI = URI.create(couchDBUrl);
        var userInfo = this.couchDbURI.getUserInfo();
        if (userInfo != null) {
            var userInfoParts = userInfo.split(":");
            this.username = userInfoParts[0];
            this.password = userInfoParts[1];
        }
        databaseName = this.couchDbURI.getPath().substring(1);
        createDatabase(couchDBUrl);
    }

    private void createDatabase(String couchDBUrl) throws DatabaseWriterException {
        var authHeader = getAuthHeaderValue();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(couchDBUrl))
                .header("Content-Type", "application/json").PUT(HttpRequest.BodyPublishers.ofString(""))
                .header("Authorization", authHeader).build();

        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 201) {
                throw new DatabaseWriterException("Failed to create database: " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            throw new DatabaseWriterException(e);
        }
    }

    private String getAuthHeaderValue() {
        return "Basic "
                + java.util.Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    }

    @Override
    public void write(HashMap<String, WordData> verbSet, HashMap<String, WordData> nounSet)
            throws DatabaseWriterException {
        writeVerbs(verbSet, nounSet);
        writeNouns(verbSet, nounSet);
    }

    private void writeVerbs(HashMap<String, WordData> verbSet, HashMap<String, WordData> nounSet)
            throws DatabaseWriterException {
        var batch = new ArrayList<HashMap<String, Object>>();
        var currentBatch = 0;
        for (var entry : verbSet.entrySet()) {
            var word = entry.getKey();
            var wordData = entry.getValue();
            var nounRoots = new HashSet<String>();
            if (nounSet.containsKey(word)) {
                nounRoots = nounSet.get(word).getRoots();
            }
            var jsonMap = new HashMap<String, Object>();
            jsonMap.put("word", word);
            var allRoots = new HashSet<>(wordData.getRoots());
            allRoots.addAll(nounRoots);
            jsonMap.put("roots", allRoots);
            jsonMap.put("_id", normalizeKey(word));
            if (currentBatch < BATCH_SIZE) {
                batch.add(jsonMap);
                currentBatch++;
                continue;
            }
            currentBatch = 0;
            writeBatch(batch);
            batch.clear();
        }
        if (batch.size() > 0) {
            writeBatch(batch);
            batch.clear();
        }
    }

    private void writeBatch(ArrayList<HashMap<String, Object>> batch) throws DatabaseWriterException {
        var authHeader = getAuthHeaderValue();
        var postURI = couchDbURI.resolve("/" + databaseName + "/_bulk_docs");
        System.out.println(postURI);
        var objectMapper = new ObjectMapper();
        var jsonString = "";
        try {
            var map = new HashMap<String, Object>();
            map.put("docs", batch);
            jsonString = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            throw new DatabaseWriterException(e);
        }
        var putRequest = HttpRequest.newBuilder().uri(postURI).header("Content-Type", "application/json")
                .header("Authorization", authHeader).POST(HttpRequest.BodyPublishers.ofString(jsonString)).build();
        try {
            var response = client.send(putRequest, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 201) {
                throw new DatabaseWriterException("Failed to write to database: " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            throw new DatabaseWriterException(e);
        }
    }

    private void writeNouns(HashMap<String, WordData> verbSet, HashMap<String, WordData> nounSet)
            throws DatabaseWriterException {
        var batch = new ArrayList<HashMap<String, Object>>();
        var currentBatch = 0;
        for (var entry : nounSet.entrySet()) {
            var word = entry.getKey();
            if (verbSet.containsKey(word)) {
                continue;
            }
            var wordData = entry.getValue();
            var jsonMap = new HashMap<String, Object>();
            jsonMap.put("word", word);
            jsonMap.put("roots", wordData.getRoots());
            jsonMap.put("_id", normalizeKey(word));
            if (currentBatch < BATCH_SIZE) {
                batch.add(jsonMap);
                currentBatch++;
                continue;
            }
            currentBatch = 0;
            writeBatch(batch);
            batch.clear();
        }
        if (batch.size() > 0) {
            writeBatch(batch);
            batch.clear();
        }
    }

    @Override
    public void close() throws DatabaseWriterException {
    }
}
