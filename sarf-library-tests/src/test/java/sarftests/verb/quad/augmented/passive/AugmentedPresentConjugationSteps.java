package sarftests.verb.quad.augmented.passive;
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
import io.cucumber.java.en.When;
import sarf.AugmentationFormula;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.kov.KovRulesManager;
import sarf.verb.quadriliteral.augmented.AugmentedPresentVerb;
import sarf.verb.quadriliteral.augmented.passive.present.AugmentedQuadPassivePresentConjugator;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;
import sarftests.PronounIndex;
import sarftests.TestContext;
import sarftests.VerbState;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class AugmentedPresentConjugationSteps {

    private final TestContext testContext;
    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final AugmentedQuadPassivePresentConjugator conjugator;
    private final QuadrilateralModifier modifier;

    @Inject
    public AugmentedPresentConjugationSteps(TestContext testContext
            , SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager, AugmentedQuadPassivePresentConjugator conjugator, QuadrilateralModifier modifier){
        this.testContext = testContext;
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.conjugator = conjugator;
        this.modifier = modifier;
    }

    @When("the augmented quadrilateral verb is passively conjugated in {string} state")
    public void theAugmentedQuadrilateralVerbIsActivelyConjugatedInState(String state) {
        this.testContext.VerbState = VerbState.valueOf(state);
    }

    @Then("the first person singular conjugation of the passive present quad verb {string} and formula of {string} is {string}")
    public void theFirstPersonSingularConjugationOfTheActivePresentQuadVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb,Integer.parseInt(formula), expected, PronounIndex.FirstPersonSingular);
    }

    @And("the first person plural conjugation of the passive present quad verb {string} and formula of {string} is {string}")
    public void theFirstPersonPluralConjugationOfTheActivePresentQuadVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb,Integer.parseInt(formula), expected, PronounIndex.FirstPersonPlural);
    }

    @And("the masculine singular second person conjugation of the passive present quad verb {string} and formula of {string} is {string}")
    public void theMasculineSingularSecondPersonConjugationOfTheActivePresentQuadVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb,Integer.parseInt(formula), expected, PronounIndex.SecondPersonMasculineSingular);
    }

    @And("the feminine singular second person conjugation of the passive present quad verb {string} and formula of {string} is {string}")
    public void theFeminineSingularSecondPersonConjugationOfTheActivePresentQuadVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb,Integer.parseInt(formula), expected, PronounIndex.SecondPersonFeminineSingular);
    }

    @And("the masculine dual second person conjugation of the passive present quad verb {string} and formula of {string} is {string}")
    public void theMasculineDualSecondPersonConjugationOfTheActivePresentQuadVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb,Integer.parseInt(formula), expected, PronounIndex.SecondPersonDual);
    }

    @And("the masculine plural second person conjugation of the passive present quad verb {string} and formula of {string} is {string}")
    public void theMasculinePluralSecondPersonConjugationOfTheActivePresentQuadVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb,Integer.parseInt(formula), expected, PronounIndex.SecondPersonMasculinePlural);
    }

    @And("the feminine plural second person conjugation of the passive present quad verb {string} and formula of {string} is {string}")
    public void theFemininePluralSecondPersonConjugationOfTheActivePresentQuadVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb,Integer.parseInt(formula), expected, PronounIndex.SecondPersonFemininePlural);
    }

    @And("the masculine singular third person conjugation of the passive present quad verb {string} and formula of {string} is {string}")
    public void theMasculineSingularThirdPersonConjugationOfTheActivePresentQuadVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb,Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculineSingular);
    }

    @And("the feminine singular third person conjugation of the passive present quad verb {string} and formula of {string} is {string}")
    public void theFeminineSingularThirdPersonConjugationOfTheActivePresentQuadVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb,Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFeminineSingular);
    }

    @And("the masculine dual third person conjugation of the passive present quad verb {string} and formula of {string} is {string}")
    public void theMasculineDualThirdPersonConjugationOfTheActivePresentQuadVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb,Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculineDual);
    }

    @And("the feminine dual third person conjugation of the passive present quad verb {string} and formula of {string} is {string}")
    public void theFeminineDualThirdPersonConjugationOfTheActivePresentQuadVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb,Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFeminineDual);
    }

    @And("the masculine plural third person conjugation of the passive present quad verb {string} and formula of {string} is {string}")
    public void theMasculinePluralThirdPersonConjugationOfTheActivePresentQuadVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb,Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculinePlural);
    }

    @And("the feminine plural third person conjugation of the passive present quad verb {string} and formula of {string} is {string}")
    public void theFemininePluralThirdPersonConjugationOfTheActivePresentQuadVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb,Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFemininePlural);
    }

    private void assertConjugations(String verb, int formula, String expected, PronounIndex pronounIndex){
        var verbs = getVerbs(verb, formula);
        assertThat(verbs).isNotNull();
        assertThat(verbs.size()).isEqualTo(13);
        assertThat(verbs.get(pronounIndex.getValue())).isEqualTo(expected);
    }

    private List<String> getVerbs(String rootLetters, int formulaNo) {
        try {
            var root = sarfDictionary.getAugmentedQuadrilateralRoot(rootLetters);
            var kovRule = kovRulesManager.getQuadrilateralKovRule(root.getC1(), root.getC2(), root.getC3(), root.getC4());
            var formula = (AugmentationFormula) root.getAugmentationList().stream().filter(f -> ((AugmentationFormula) f).getFormulaNo() == formulaNo).findFirst().orElseThrow();

            List<AugmentedPresentVerb> verbs;
            switch (testContext.VerbState) {
                case PassiveNominative:
                    verbs = conjugator.getNominativeConjugator().createVerbList(root, formula.getFormulaNo());
                    break;
                case PassiveAccusative:
                    verbs = conjugator.getAccusativeConjugator().createVerbList(root, formula.getFormulaNo());
                    break;
                case PassiveJussive:
                    verbs = conjugator.getJussiveConjugator().createVerbList(root, formula.getFormulaNo());
                    break;
                case PassiveEmphasized:
                    verbs = conjugator.getEmphasizedConjugator().createVerbList(root, formula.getFormulaNo());
                    break;
                default:
                    fail("Invalid verb state: " + testContext.VerbState);
                    return null;
            }
            var conjugationResult = modifier.build(root
                    , formula.getFormulaNo()
                    , kovRule.getKov()
                    , verbs, SystemConstants.PRESENT_TENSE
                    , false
                    , true)
                    .getFinalResult();
            var result = new ArrayList<String>();
            for (var v : conjugationResult) {
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
