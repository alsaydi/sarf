package sarftests.verb.tri.augmented.passive;
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
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.passive.past.AugmentedPassivePastConjugator;
import sarftests.PronounIndex;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class AugmentedPastConjugationSteps {

    private final Common common;
    private final SarfDictionary sarfDictionary;
    private final AugmentedPassivePastConjugator conjugator;
    private final AugmentedTrilateralModifier modifier;

    @Inject
    public AugmentedPastConjugationSteps(Common common
            , SarfDictionary sarfDictionary
            , AugmentedPassivePastConjugator conjugator
            , AugmentedTrilateralModifier modifier){
        this.common = common;
        this.sarfDictionary = sarfDictionary;
        this.conjugator = conjugator;
        this.modifier = modifier;
    }

    @Then("the first person singular past conjugation of the passive verb {string} and formula of {string} is {string}")
    public void theFirstPersonSingularPastConjugationOfThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.FirstPersonSingular);
    }

    @And("the first person plural past conjugation of the passive verb {string} and formula of {string} is {string}")
    public void theFirstPersonPluralPastConjugationOfThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.FirstPersonPlural);
    }

    @And("the masculine singular second person past conjugation of the passive verb {string} and formula of {string} is {string}")
    public void theMasculineSingularSecondPersonPastConjugationOfThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonMasculineSingular);
    }

    @And("the feminine singular second person past conjugation of the passive verb {string} and formula of {string} is {string}")
    public void theFeminineSingularSecondPersonPastConjugationOfThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonFeminineSingular);
    }

    @And("the masculine dual second person past conjugation of the passive verb {string} and formula of {string} is {string}")
    public void theMasculineDualSecondPersonPastConjugationOfThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonDual);
    }

    @And("the masculine plural second person past conjugation of the passive verb {string} and formula of {string} is {string}")
    public void theMasculinePluralSecondPersonPastConjugationOfThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonMasculinePlural);
    }

    @And("the feminine plural second person past conjugation of the passive verb {string} and formula of {string} is {string}")
    public void theFemininePluralSecondPersonPastConjugationOfThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonFemininePlural);
    }

    @And("the masculine singular third person past conjugation of the passive verb {string} and formula of {string} is {string}")
    public void theMasculineSingularThirdPersonPastConjugationOfThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculineSingular);
    }

    @And("the feminine singular third person past conjugation of the passive verb {string} and formula of {string} is {string}")
    public void theFeminineSingularThirdPersonPastConjugationOfThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFeminineSingular);
    }

    @And("the masculine dual third person past conjugation of the passive verb {string} and formula of {string} is {string}")
    public void theMasculineDualThirdPersonPastConjugationOfThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculineDual);
    }

    @And("the feminine dual third person past conjugation of the passive verb {string} and formula of {string} is {string}")
    public void theFeminineDualThirdPersonPastConjugationOfThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFeminineDual);
    }

    @And("the masculine plural third person past conjugation of the passive verb {string} and formula of {string} is {string}")
    public void theMasculinePluralThirdPersonPastConjugationOfThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculinePlural);
    }

    @And("the feminine plural third person past conjugation of the passive verb {string} and formula of {string} is {string}")
    public void theFemininePluralThirdPersonPastConjugationOfThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFemininePlural);
    }

    private void assertConjugation(String verb, int formula, String expected, PronounIndex pronounIndex) {
        var verbs = getVerbs(verb, formula);
        assertThat(verbs).isNotNull();
        assertThat(verbs.size()).isEqualTo(13);
        assertThat(verbs.get(pronounIndex.getValue())).isEqualTo(expected);
    }

    private List<String> getVerbs(String rootLetters, int formula){
        try {
            var root = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var kov = common.getKindOfVerb(rootLetters);
            var augmentationFormula = root.getAugmentationList().stream().filter(af -> af.getFormulaNo() == formula).findFirst().orElseThrow();
            var verbs = conjugator.createVerbList(root, augmentationFormula.getFormulaNo());
            var conjugationResult = modifier.build(root, kov, augmentationFormula.getFormulaNo(), verbs
                    , SystemConstants.PAST_TENSE
                    , false
                    , true
                    , () -> true).getFinalResult();
            var result = new ArrayList<String>();
            for(var v: conjugationResult){
                if(v == null){
                    result.add("");
                    continue;
                }
                result.add(v.toString());
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        return null;
    }
}
