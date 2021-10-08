package sarftests.noun.quad.unaugmented;
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
import sarf.kov.KovRulesManager;
import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.noun.quadriliteral.unaugmented.UnaugmentedQuadrilateralPassiveParticipleConjugator;
import sarftests.noun.INounProvider;

import java.util.ArrayList;
import java.util.List;

public class QuadrilateralUnaugmentedTimeAndPlaceNounProvider implements INounProvider {

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final UnaugmentedQuadrilateralPassiveParticipleConjugator conjugator;
    private final PassiveParticipleModifier modifier;

    @Inject
    public QuadrilateralUnaugmentedTimeAndPlaceNounProvider(SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager
            , UnaugmentedQuadrilateralPassiveParticipleConjugator conjugator
            , PassiveParticipleModifier modifier){
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.conjugator = conjugator;
        this.modifier = modifier;
    }

    @Override
    public List<String> getNouns(String rootLetters, String formula, int conjugation) {
        return null;
    }

    @Override
    public List<String> getNouns(String rootLetters, int conjugations) {
        try {
            var root = sarfDictionary.getUnaugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            List nouns; //TODO: fix the typing in the modifier build function so we don't have to do this trick.
            nouns = conjugator.createTimeAndPlaceNounList(root, new GenericNounSuffixContainer());

            var conjugationResult =  modifier.build(root, 0, kovRule.getKov(), nouns).getFinalResult();
            var result = new ArrayList<String>();
            for(var n : conjugationResult){
                result.add(n.toString());
            }
            return result;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
