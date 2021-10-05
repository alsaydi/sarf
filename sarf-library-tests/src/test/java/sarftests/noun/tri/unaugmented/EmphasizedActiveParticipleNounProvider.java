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
import sarf.noun.NounFormula;
import sarf.noun.trilateral.unaugmented.exaggeration.NonStandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.exaggeration.StandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.ExaggerationModifier;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmphasizedActiveParticipleNounProvider implements INounProvider {

    private final Common common;
    private final StandardExaggerationConjugator standardExaggerationConjugator;
    private final NonStandardExaggerationConjugator nonStandardExaggerationConjugator;
    private final ExaggerationModifier exaggerationModifier;

    @Inject
    public EmphasizedActiveParticipleNounProvider(Common common, StandardExaggerationConjugator standardExaggerationConjugator
    , NonStandardExaggerationConjugator nonStandardExaggerationConjugator
    , ExaggerationModifier exaggerationModifier){
        this.common = common;
        this.standardExaggerationConjugator = standardExaggerationConjugator;
        this.nonStandardExaggerationConjugator = nonStandardExaggerationConjugator;
        this.exaggerationModifier = exaggerationModifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula,  int conjugations) {
        var locale = new Locale("AR", "YE", "");
        var collator = Collator.getInstance(locale);
        collator.setStrength(Collator.NO_DECOMPOSITION);
        var root = common.createRoot(rootLetters, conjugations);
        var kov = common.getKindOfVerb(rootLetters);
        List<NounFormula> rawNouns;
        formula = null == formula ? "فَعَّال": formula;
        if(collator.compare(formula, "فَعَّال") == 0){
            rawNouns = standardExaggerationConjugator.createNounList(root, formula);
            standardExaggerationConjugator.getAppliedFormulaList(root);
        }else{
            rawNouns = nonStandardExaggerationConjugator.createNounList(root, formula);
        }
        var conjugationResult = exaggerationModifier.build(root, kov, rawNouns, formula);
        var result = new ArrayList<String>();
        for (var n : conjugationResult.getFinalResult()){
            result.add(n.toString());
        }
        return result;
    }
}
