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
import models.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class InvertedIndexBuilder {
    private final ProgramOptions programOptions;
    private final HttpClient httpClient;
    private int count = 0;
    private final VerbIndexBuilder verbIndexBuilder;
    private final NounIndexBuilder nounIndexBuilder;
    private final DatabaseWriter databaseWriter;

    public InvertedIndexBuilder(ProgramOptions programOptions) throws IOException {
        this.programOptions = programOptions;
        httpClient = HttpClient.newHttpClient();
        verbIndexBuilder = new VerbIndexBuilder();
        nounIndexBuilder = new NounIndexBuilder();
        databaseWriter = new CouchDbWriter(); // new FileDatabaseWriter();
    }

    public void run() throws IOException, SQLException, URISyntaxException, InterruptedException, DatabaseWriterException {
        databaseWriter.init(programOptions.getDbFilename());
        var roots = readRoots(programOptions.getRootsFilename());
        for (var root : roots) {
            processRoot(root);
        }
        System.out.printf("Number of roots, %d, found %d\n", roots.size(), count);
        databaseWriter.write(verbIndexBuilder.getVerbRootHashMap());
        databaseWriter.write(nounIndexBuilder.getNounRootHashMap());
        databaseWriter.close();
    }

    private void processRoot(String root) throws URISyntaxException, IOException, InterruptedException, SQLException {
        System.out.printf("Processing %s ...%n", root);
        var httpRequest = HttpRequest.newBuilder()
                .uri(new URI(programOptions.getSarfUri() + "/sarf/" + root)).build();
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)).body();

        var objectMapper = new ObjectMapper();
        var node = objectMapper.readTree(response);
        var result = objectMapper.convertValue(node, new TypeReference<Collection<RootResult>>() {
        });
        processVerbs(root, result);
        processNouns(root, result);
        count++;
    }

    private void processVerbs(String root, Collection<RootResult> rootResults) throws URISyntaxException, IOException, InterruptedException {
        for (var rootResult : rootResults) {
            processVerbsFromUnaugmented(root, "active", rootResult.getUnaugmentedRoots());
            processVerbsFromAugmented(root, "active", rootResult.getAugmentedRoots());

            processVerbsFromUnaugmented(root, "passive", rootResult.getUnaugmentedRoots());
            processVerbsFromAugmented(root, "passive", rootResult.getAugmentedRoots());
        }
    }

    private void processVerbsFromUnaugmented(String root, String type, List<RootDisplay> unaugmentedRoots) throws URISyntaxException, IOException, InterruptedException {
        for (var unaugmentedRoot : unaugmentedRoots) {
            if (unaugmentedRoot == null || unaugmentedRoot.getRoot() == null) {
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
                .uri(new URI(programOptions.getSarfUri() + "/sarf" + String.format("/%s/%s?augmented=%s&cclass=%d&formula=%d", type, root, augmented, cclass, formula)))
                .build();
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        if (response.statusCode() != 200) {
            throw new IOException(String.format("Verbs request for root %s, cclass %d, augmented %s, formula %d failed with status code %d."
                    , root, cclass, augmented, formula, response.statusCode()));
        }
        var objectMapper = new ObjectMapper();
        var node = objectMapper.readTree(response.body());
        var verbResults = objectMapper.convertValue(node, new TypeReference<List<VerbResult>>() {
        });

        for(var verbResult : verbResults) {
            verbIndexBuilder.add(root, verbResult);
        }
    }

    private void processNouns(String root, Collection<RootResult> rootResults) throws URISyntaxException, IOException, InterruptedException {
        for (var rootResult : rootResults) {
            processNounsFromUnaugmented(root, "nouns", rootResult.getUnaugmentedRoots());
            processNounsFromAugmented(root, "nouns", rootResult.getAugmentedRoots());

            processNounsFromUnaugmented(root, "gerunds", rootResult.getUnaugmentedRoots());
            processNounsFromAugmented(root, "gerunds", rootResult.getAugmentedRoots());
        }
    }

    private void processNounsFromUnaugmented(String root, String type, List<RootDisplay> unaugmentedRoots) throws URISyntaxException, IOException, InterruptedException {
        for (var unaugmentedRoot : unaugmentedRoots) {
            if (unaugmentedRoot == null || unaugmentedRoot.getRoot() == null) {
                continue;
            }
            getNouns(root, type, unaugmentedRoot.getRoot().getConjugation(), false, 0);
        }
    }

    private void processNounsFromAugmented(String root, String type, List<AugmentedRoot> augmentedRoots) throws URISyntaxException, IOException, InterruptedException {
        for (var augmentedRoot : augmentedRoots) {
            getNouns(root, type, "", true, augmentedRoot.getConjugationResult().getFormulaNo());
        }
    }

    private void getNouns(String root, String type, String conjugation, boolean augmented, int formula) throws URISyntaxException, IOException, InterruptedException {
        var cclass = augmented || root.length() > 3 ? 0 : convertConjugationToClass(conjugation);
        var httpRequest = HttpRequest.newBuilder()
                .uri(new URI(programOptions.getSarfUri() + "/sarf" + String.format("/%s/%s?augmented=%s&cclass=%d&formula=%d", type, root, augmented, cclass, formula)))
                .build();
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        if (response.statusCode() != 200) {
            throw new IOException(String.format("Nouns request for root %s, cclass %d, augmented %s, formula %d failed with status code %d."
                    , root, cclass, augmented, formula, response.statusCode()));
        }
        var objectMapper = new ObjectMapper();
        var node = objectMapper.readTree(response.body());
        if (type.equals("nouns")) {
            var nounResults = objectMapper.convertValue(node, new TypeReference<DerivedNounResult>() {
            });
            nounIndexBuilder.add(root, nounResults);
        } else {
            var gerundResults = objectMapper.convertValue(node, new TypeReference<GerundResult>() {
            });
            nounIndexBuilder.add(root, gerundResults);
        }
    }

    private int convertConjugationToClass(String conjugation) {
        conjugation = conjugation.toLowerCase(Locale.ROOT);
        switch (conjugation) {
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
