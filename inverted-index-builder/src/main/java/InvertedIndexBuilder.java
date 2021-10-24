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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import models.RootResult;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InvertedIndexBuilder {
    private final ProgramOptions programOptions;
    private final HttpClient httpClient;

    public InvertedIndexBuilder(ProgramOptions programOptions) {
        this.programOptions = programOptions;
        httpClient = HttpClient.newHttpClient();
    }

    public void run() throws IOException {
        var roots = readRoots(programOptions.getRootsFilename());
        roots.forEach(root -> {
            try {
                processRoot(root);
            } catch (URISyntaxException | IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    private void processRoot(String root) throws URISyntaxException, IOException, InterruptedException {
        var httpRequest = HttpRequest.newBuilder()
                .uri(new URI(programOptions.getSarfUri() + "/sarf/" + root)).build();
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)).body();
        System.out.println(response);

        var objectMapper = new ObjectMapper();
        var node = objectMapper.readTree(response);
        var result = objectMapper.convertValue(node, new TypeReference<Collection<RootResult>>() {
        });
        System.out.println(result);
    }

    private <U, T> RootResult toRootResult(InputStream inputStream, Class<T> targetType) {
        return null;
    }

    private List<String> readRoots(String rootsFilename) throws IOException {
        var lines = Files.readAllLines(Path.of(rootsFilename), StandardCharsets.UTF_8);
        return lines.stream().map(line -> line.split("\\p{javaWhitespace}")[0].trim()).toList();
    }
}
