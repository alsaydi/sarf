package sarftests.verb.quad.unaugmented.passive;
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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.kov.KovRulesManager;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;
import sarf.verb.quadriliteral.unaugmented.passive.QuadriUnaugmentedPassivePastConjugator;
import sarftests.PronounIndex;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class UnaugmentedPastConjugationSteps {

    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final QuadriUnaugmentedPassivePastConjugator conjugator;
    private final QuadrilateralModifier modifier;

    @Inject
    public UnaugmentedPastConjugationSteps(SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager
            , QuadriUnaugmentedPassivePastConjugator conjugator, QuadrilateralModifier modifier) {
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.conjugator = conjugator;
        this.modifier = modifier;
    }

    @Then("the first person singular passive conjugation of the verb {string}is {string}")
    public void theFirstPersonSingularConjugationOfTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.FirstPersonSingular);
    }

    @And("the first person plural passive conjugation of the verb {string}is {string}")
    public void theFirstPersonPluralConjugationOfTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.FirstPersonPlural);
    }

    @And("the masculine singular second person passive conjugation of the verb {string}is {string}")
    public void theMasculineSingularSecondPersonConjugationOfTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.SecondPersonMasculineSingular);
    }

    @And("the feminine singular second person passive conjugation of the verb {string}is {string}")
    public void theFeminineSingularSecondPersonConjugationOfTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.SecondPersonFeminineSingular);
    }

    @And("the masculine dual second person passive conjugation of the verb {string}is {string}")
    public void theMasculineDualSecondPersonConjugationOfTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.SecondPersonDual);
    }

    @And("the masculine plural second person passive conjugation of the verb {string}is {string}")
    public void theMasculinePluralSecondPersonConjugationOfTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.SecondPersonMasculinePlural);
    }

    @And("the feminine plural second person passive conjugation of the verb {string}is {string}")
    public void theFemininePluralSecondPersonConjugationOfTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.SecondPersonFemininePlural);
    }

    @And("the masculine singular third person passive conjugation of the verb {string}is {string}")
    public void theMasculineSingularThirdPersonConjugationOfTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.ThirdPersonMasculineSingular);
    }

    @And("the feminine singular third person passive conjugation of the verb {string}is {string}")
    public void theFeminineSingularThirdPersonConjugationOfTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.ThirdPersonFeminineSingular);
    }

    @And("the masculine dual third person passive conjugation of the verb {string}is {string}")
    public void theMasculineDualThirdPersonConjugationOfTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.ThirdPersonMasculineDual);
    }

    @And("the feminine dual third person passive conjugation of the verb {string}is {string}")
    public void theFeminineDualThirdPersonConjugationOfTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.ThirdPersonFeminineDual);
    }

    @And("the masculine plural third person passive conjugation of the verb {string}is {string}")
    public void theMasculinePluralThirdPersonConjugationOfTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.ThirdPersonMasculinePlural);
    }

    @And("the feminine plural third person passive conjugation of the verb {string}is {string}")
    public void theFemininePluralThirdPersonConjugationOfTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.ThirdPersonFemininePlural);
    }

    private void assertConjugations(String rootLetters, String expected, PronounIndex pronounIndex) {
        var verbs = getVerbs(rootLetters);
        assertThat(verbs).isNotNull();
        assertThat(verbs.size()).isEqualTo(13);
        assertThat(verbs.get(pronounIndex.getValue())).isEqualTo(expected);
    }

    private List<String> getVerbs(String rootLetters){
        try {
            var root = sarfDictionary.getUnaugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var verbs = conjugator.createVerbList(root);

            var conjugationResult = modifier.build(root, 0, kovRule.getKov()
                    , verbs
                    , SystemConstants.PAST_TENSE
                    , false
                    , true).getFinalResult();
            var result = new ArrayList<String>();
            for(var v : conjugationResult){
                if(v == null){
                    result.add("");
                    continue;
                }
                result.add(v.toString());
            }
            return result;
        }
        catch (Exception e){
            fail(e.getMessage());
        }
        return null;
    }
}
