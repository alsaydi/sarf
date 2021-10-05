package sarftests.noun.tri.augmented.gerund;
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
import sarf.SarfDictionary;
import sarf.gerund.modifier.trilateral.augmented.standard.TrilateralAugmentedStandardModifier;
import sarf.gerund.trilateral.augmented.TrilateralAugmentedGerundConjugator;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class AugmentedGerundNounProvider implements INounProvider {

    private final SarfDictionary sarfDictionary;
    private final Common common;
    private final TrilateralAugmentedGerundConjugator conjugator;
    private final TrilateralAugmentedStandardModifier modifier;

    @Inject
    public AugmentedGerundNounProvider(SarfDictionary sarfDictionary, Common common, TrilateralAugmentedGerundConjugator conjugator
    , TrilateralAugmentedStandardModifier modifier){
        this.sarfDictionary = sarfDictionary;
        this.common = common;
        this.conjugator = conjugator;
        this.modifier = modifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugation) {
        return null;
    }

    @Override
    public List<String> getNouns(String rootLetters, int formula) {
        try {
            var augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var kov = common.getKindOfVerb(rootLetters);
            var gerunds = conjugator.createGerundList(augmentedRoot, formula);
            var conjugationResult = modifier.build(augmentedRoot, kov, formula, gerunds, () -> true).getFinalResult();
            var result = new ArrayList<String>();
            for (var n : conjugationResult) {
                result.add(n.toString());
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
