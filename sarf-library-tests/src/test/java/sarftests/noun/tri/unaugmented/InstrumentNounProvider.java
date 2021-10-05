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
import sarf.noun.trilateral.unaugmented.instrumental.StandardInstrumentalConjugator;
import sarf.noun.trilateral.unaugmented.instrumental.NonStandardInstrumentalConjugator;
import sarf.noun.trilateral.unaugmented.modifier.instrumental.InstrumentalModifier;
import sarftests.noun.INounProvider;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

public class InstrumentNounProvider implements INounProvider {

    private final Common common;
    private final StandardInstrumentalConjugator conjugator;
    private final NonStandardInstrumentalConjugator nonStandardConjugator;
    private final InstrumentalModifier modifier;

    @Inject
    public InstrumentNounProvider(Common common
        , StandardInstrumentalConjugator conjugator
        , NonStandardInstrumentalConjugator nonStandardConjugator
        , InstrumentalModifier modifier){
        this.common = common;
        this.conjugator = conjugator;
        this.nonStandardConjugator = nonStandardConjugator;
        this.modifier = modifier;
    }

    private static final List<String> standardFormulas = new ArrayList<>();
    static {
        standardFormulas.add("مِفْعَل");
        standardFormulas.add("مِفْعَلَة");
        standardFormulas.add("مِفْعَال");
        standardFormulas.add("فَعَّالَة");
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugation) {
        var root = common.createRoot(rootLetters, conjugation);
        var kov = common.getKindOfVerb(rootLetters);
        List<NounFormula> rawNouns;
        if(standardFormulas.contains(formula)){
            rawNouns = conjugator.createNounList(root, formula);
        }
        else{
            rawNouns = nonStandardConjugator.createNounList(root, formula);
        }
        if(rawNouns == null){
            return new ArrayList<>();
        }

        var finalResult = modifier.build(root, kov, rawNouns, formula).getFinalResult();
        var result = new ArrayList<String>();
        for(Object n : finalResult){
            if(n == null){
                result.add("");
                continue;
            }
            result.add(n.toString());
        }
        return result;
    }
}
