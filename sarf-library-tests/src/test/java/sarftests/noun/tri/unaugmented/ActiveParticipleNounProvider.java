package sarftests.noun.tri.unaugmented;
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
import sarf.noun.trilateral.unaugmented.UnaugmentedTrilateralActiveParticipleConjugator;
import sarf.noun.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class ActiveParticipleNounProvider implements INounProvider {

    private final Common common;
    private final UnaugmentedTrilateralActiveParticipleConjugator unaugmentedTrilateralActiveParticipleConjugator;
    private final ActiveParticipleModifier activeParticipleModifier;

    @Inject
    public ActiveParticipleNounProvider(Common common, UnaugmentedTrilateralActiveParticipleConjugator unaugmentedTrilateralActiveParticipleConjugator
    , ActiveParticipleModifier activeParticipleModifier){
        this.common = common;
        this.unaugmentedTrilateralActiveParticipleConjugator = unaugmentedTrilateralActiveParticipleConjugator;
        this.activeParticipleModifier = activeParticipleModifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugation) {
        var kov = common.getKindOfVerb(rootLetters);
        var root = common.createRoot(rootLetters, conjugation);
        var rawNouns = unaugmentedTrilateralActiveParticipleConjugator.createNounList(root, null); /* there is only one formula */
        var conjugationResult = activeParticipleModifier.build(root, kov, rawNouns, null  );
        var nouns = new ArrayList<String>();
        for(var n : conjugationResult.getFinalResult()){
            nouns.add(n.toString());
        }
        return nouns;
    }
}
