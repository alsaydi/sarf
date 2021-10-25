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

import models.DerivedNounResult;
import models.GerundResult;
import models.Noun;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NounIndexBuilder {

    private final HashMap<String, WordData> nounRootHashMap;

    public NounIndexBuilder() {
        nounRootHashMap = new HashMap<>();
    }

    public void add(String root, DerivedNounResult derivedNounResult) {
        addNouns(root, derivedNounResult.getActiveParticiples());
        addNouns(root, derivedNounResult.getPassiveParticiples());
        addNouns(root, derivedNounResult.getTimeAndPlaceNouns());
        addNouns(root, derivedNounResult.getExaggeratedActiveParticiples());
        addNouns(root, derivedNounResult.getInstrumentalNouns());
        addNouns(root, derivedNounResult.getElatives());
        addNouns(root, derivedNounResult.getAssimilates());
    }

    public void add(String root, GerundResult gerundResult) {
        addNouns(root, gerundResult.getStandards());
        addNouns(root, gerundResult.getMeems());
        addNouns(root, gerundResult.getNomens());
        addNouns(root, gerundResult.getQualityGerunds());
    }

    private void addNouns(String root, List<Noun> nouns) {
        if(nouns == null || nouns.isEmpty()) {
            return;
        }

        for(var noun : nouns) {
            var indefiniteNouns = noun.getIndefiniteNouns().stream().filter(NounIndexBuilder::isNoneEmptyNoun);
            var annexedNouns = noun.getAnnexedNouns() != null ?  noun.getAnnexedNouns().stream().filter(NounIndexBuilder::isNoneEmptyNoun) : Stream.of("");
            var definiteNouns = noun.getDefiniteNouns().stream().filter(NounIndexBuilder::isNoneEmptyNoun);
            var annexToIndefinite =  noun.getAnnexedToIndefinite() != null ?  noun.getAnnexedToIndefinite().stream().filter(NounIndexBuilder::isNoneEmptyNoun) : Stream.of("");
            var annexedToDefinite = noun.getAnnexedToDefinite() != null ? noun.getAnnexedToDefinite().stream().filter(NounIndexBuilder::isNoneEmptyNoun) : Stream.of("");;

            var allNouns = Stream.of(indefiniteNouns, annexedNouns, definiteNouns, annexToIndefinite, annexedToDefinite)
                    .flatMap(n -> n).collect(Collectors.toUnmodifiableSet());

            add(root, allNouns);
        }
    }

    private void add(String root, Collection<String> verbs) {
        for (var verb : verbs) {
            if (verb == null || verb.length() == 0 || verb.trim().equals("-")) {
                continue;
            }

            var unvoweledVerb = removeTashkeel(verb);
            var wordData = nounRootHashMap.getOrDefault(unvoweledVerb, new WordData());
            wordData.getRoots().add(root);
            wordData.getVoweledForms().add(verb);
            nounRootHashMap.put(unvoweledVerb, wordData);
        }
    }

    private String removeTashkeel(String verb) {
        return ArabicUtils.removeTashkeel(verb);
    }

    private static boolean isNoneEmptyNoun(String n) {
        return n != null && n.length() > 0 && !n.equals("-");
    }
}
