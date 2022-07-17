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

import models.VerbResult;

import java.util.HashMap;
import java.util.List;

public class VerbIndexBuilder {

    private final HashMap<String, WordData> verbRootHashMap;

    public VerbIndexBuilder() {
        verbRootHashMap = new HashMap<>();
    }

    public void add(String root, VerbResult verbResult) {
        add(root, verbResult.getPast());
        add(root, verbResult.getNominativePresent());
        add(root, verbResult.getAccusativePresent());
        add(root, verbResult.getJussivePresent());
        add(root, verbResult.getEmphasizedPresent());
        add(root, verbResult.getImperative());
        add(root, verbResult.getEmphasizedImperative());
    }

    private void add(String root, List<String> verbs) {
        for (var combinedVerb : verbs) {
            if (combinedVerb == null || combinedVerb.length() == 0 || combinedVerb.trim().equals("-")) {
                continue;
            }

            var splitVerbs = combinedVerb.split("/");
            for(var splitVerb: splitVerbs) {
                var unvoweledVerb = removeTashkeel(splitVerb);
                var wordData = verbRootHashMap.getOrDefault(unvoweledVerb, new WordData());
                wordData.getRoots().add(root);
                wordData.getVoweledForms().add(splitVerb);
                verbRootHashMap.put(unvoweledVerb, wordData);
            }
        }
    }

    public HashMap<String, WordData> getVerbRootHashMap() {
        return verbRootHashMap;
    }

    private String removeTashkeel(String verb) {
        return ArabicUtils.removeTashkeel(verb);
    }
}
