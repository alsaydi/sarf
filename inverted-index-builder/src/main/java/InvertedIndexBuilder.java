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
import com.fasterxml.jackson.databind.ObjectMapper;
import models.AugmentedRoot;
import models.RootDisplay;
import models.RootResult;
import models.VerbResult;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class InvertedIndexBuilder {
    private final ProgramOptions programOptions;
    private final HttpClient httpClient;
    private int count = 0;

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

        System.out.printf("Number of roots, %d, found %d\n", roots.size(), count);
    }

    private void processRoot(String root) throws URISyntaxException, IOException, InterruptedException {
        var httpRequest = HttpRequest.newBuilder()
                .uri(new URI(programOptions.getSarfUri() + "/sarf/" + root)).build();
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)).body();
        System.out.println(response);

        var objectMapper = new ObjectMapper();
        var node = objectMapper.readTree(response);
        var result = objectMapper.convertValue(node, new TypeReference<Collection<RootResult>>() {});
        processVerbs(root, result);
        //getNouns
        //getGerunds
        count++;
    }

    private void processVerbs(String root, Collection<RootResult> rootResults) throws URISyntaxException, IOException, InterruptedException {
        for (var rootResult: rootResults) {
          processVerbsFromUnaugmented(root, "active", rootResult.getUnaugmentedRoots());
          processVerbsFromAugmented(root, "active", rootResult.getAugmentedRoots());

            processVerbsFromUnaugmented(root, "passive", rootResult.getUnaugmentedRoots());
            processVerbsFromAugmented(root, "passive", rootResult.getAugmentedRoots());
        }
    }

    private void processVerbsFromUnaugmented(String root, String type, List<RootDisplay> unaugmentedRoots) throws URISyntaxException, IOException, InterruptedException {
        for (var unaugmentedRoot : unaugmentedRoots) {
            if(unaugmentedRoot == null || unaugmentedRoot.getRoot() == null) {
                continue;
            }
            getVerbs(root, type, unaugmentedRoot.getRoot().getConjugation(), false, 0);
        }
    }

    private void processVerbsFromAugmented(String root, String type, List<AugmentedRoot> augmentedRoots) throws URISyntaxException, IOException, InterruptedException {
        for (var augmentedRoot : augmentedRoots) {
            getVerbs(root, type, "", true, augmentedRoot.getConjugationResult().getFormulaNo());
        }
    }

    private void getVerbs(String root, String type, String conjugation, boolean augmented, int formula) throws URISyntaxException, IOException, InterruptedException {
        var cclass = augmented || root.length() > 3 ? 0 : convertConjugationToClass(conjugation);
        var httpRequest = HttpRequest.newBuilder()
                .uri(new URI( programOptions.getSarfUri() + "/sarf" + String.format("/%s/%s?augmented=%s&cclass=%d&formula=%d", type, root, augmented, cclass, formula)))
                .build();
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        if(response.statusCode() != 200) {
            throw new IOException(String.format("Request for root %s, cclass %d, augmented %s, formula %d failed with status code %d."
                    , root, cclass, augmented, formula, response.statusCode()));
        }
        System.out.println(response.body());
        var objectMapper = new ObjectMapper();
        var node = objectMapper.readTree(response.body());
        var verbResults = objectMapper.convertValue(node, new TypeReference<List<VerbResult>>() {});
        System.out.println(verbResults.size());
    }

    private int convertConjugationToClass(String conjugation) {
        conjugation = conjugation.toLowerCase(Locale.ROOT);
        switch (conjugation){
            case "first":
                return 1;
            case "second":
                return 2;
            case "third":
                return 3;
            case "forth":
                return 4;
            case "fifth":
                return 5;
            case "sixth":
                return 6;
            default:
                break;
        }
        throw new IllegalStateException(String.format("Invalid conjugation class: %s", conjugation));
    }

    private List<String> readRoots(String rootsFilename) throws IOException {
        var lines = Files.readAllLines(Path.of(rootsFilename), StandardCharsets.UTF_8);
        return lines.stream().map(line -> line.split("\\p{javaWhitespace}")[0].trim()).toList();
    }
}
