package sarftests.noun.tri.unaugmented.gerund;
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
import com.google.inject.Inject;
import sarf.gerund.modifier.trilateral.unaugmented.standard.UnaugmentedTrilateralStandardGerundModifier;
import sarf.gerund.trilateral.unaugmented.TrilateralUnaugmentedGerundConjugator;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class GerundNounProvider implements INounProvider {

    private final Common common;
    private final TrilateralUnaugmentedGerundConjugator conjugator;
    private final UnaugmentedTrilateralStandardGerundModifier modifier;

    @Inject
    public GerundNounProvider(Common common, TrilateralUnaugmentedGerundConjugator conjugator
            , UnaugmentedTrilateralStandardGerundModifier modifier) {
        this.common = common;
        this.conjugator = conjugator;
        this.modifier = modifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugation) {
        var root = common.createRoot(rootLetters, conjugation);
        var kov = common.getKindOfVerb(rootLetters);
        var rawNouns = conjugator.createGerundList(root, formula);
        var conjugationResult = modifier.build(root, kov, rawNouns, formula).getFinalResult();
        var result = new ArrayList<String>();
        for (var g : conjugationResult) {
            if (g == null) {
                result.add("");
                continue;
            }
            result.add(g.toString());
        }
        return result;
    }
}
