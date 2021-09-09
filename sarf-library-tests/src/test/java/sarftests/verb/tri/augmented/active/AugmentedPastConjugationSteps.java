package sarftests.verb.tri.augmented.active;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import sarftests.PronounIndex;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

public class AugmentedPastConjugationSteps {

    private final Common common;
    private final SarfDictionary sarfDictionary;
    private final AugmentedActivePastConjugator augmentedActivePastConjugator;
    private final AugmentedTrilateralModifier augmentedTrilateralModifier;

    @Inject
    public AugmentedPastConjugationSteps(Common common
            , SarfDictionary sarfDictionary
            , AugmentedActivePastConjugator augmentedActivePastConjugator
            , AugmentedTrilateralModifier augmentedTrilateralModifier){
        this.common = common;
        this.sarfDictionary = sarfDictionary;
        this.augmentedActivePastConjugator = augmentedActivePastConjugator;
        this.augmentedTrilateralModifier = augmentedTrilateralModifier;
    }

    @Given("an augmented verb")
    public void anAugmentedVerb() {
    }

    @Then("the first person singular conjugation of the verb {string} and formula of {string} is {string}")
    public void theFirstPersonSingularConjugationOfTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertVerbConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.FirstPersonSingular);
    }

    @And("the first person plural conjugation of the verb {string} and formula of {string} is {string}")
    public void theFirstPersonPluralConjugationOfTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertVerbConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.FirstPersonPlural);
    }

    @And("the masculine singular second person conjugation of the verb {string} and formula of {string} is {string}")
    public void theMasculineSingularSecondPersonConjugationOfTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertVerbConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonMasculineSingular);
    }

    @And("the feminine singular second person conjugation of the verb {string} and formula of {string} is {string}")
    public void theFeminineSingularSecondPersonConjugationOfTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertVerbConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonFeminineSingular);
    }

    @And("the masculine dual second person conjugation of the verb {string} and formula of {string} is {string}")
    public void theMasculineDualSecondPersonConjugationOfTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertVerbConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonDual);
    }

    @And("the masculine plural second person conjugation of the verb {string} and formula of {string} is {string}")
    public void theMasculinePluralSecondPersonConjugationOfTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertVerbConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonMasculinePlural);
    }

    @And("the feminine plural second person conjugation of the verb {string} and formula of {string} is {string}")
    public void theFemininePluralSecondPersonConjugationOfTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertVerbConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonFemininePlural);
    }

    @And("the masculine singular third person conjugation of the verb {string} and formula of {string} is {string}")
    public void theMasculineSingularThirdPersonConjugationOfTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertVerbConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculineSingular);
    }

    @And("the feminine singular third person conjugation of the verb {string} and formula of {string} is {string}")
    public void theFeminineSingularThirdPersonConjugationOfTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertVerbConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFeminineSingular);
    }

    @And("the masculine dual third person conjugation of the verb {string} and formula of {string} is {string}")
    public void theMasculineDualThirdPersonConjugationOfTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertVerbConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculineDual);
    }

    @And("the feminine dual third person conjugation of the verb {string} and formula of {string} is {string}")
    public void theFeminineDualThirdPersonConjugationOfTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertVerbConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFeminineDual);
    }

    @And("the masculine plural third person conjugation of the verb {string} and formula of {string} is {string}")
    public void theMasculinePluralThirdPersonConjugationOfTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertVerbConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculinePlural);
    }

    @And("the feminine plural third person conjugation of the verb {string} and formula of {string} is {string}")
    public void theFemininePluralThirdPersonConjugationOfTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertVerbConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFemininePlural);
    }

    private void assertVerbConjugation(String verb, int formula, String expected, PronounIndex pronounIndex){
        var verbs = getVerbs(verb, formula);
        assertThat(verbs.size()).isEqualTo(13);
        assertThat(verbs.get(pronounIndex.getValue())).isEqualTo(expected);
    }

    private List<String> getVerbs(String rootLetters, int formula){
        var result = new ArrayList<String>();
        try {
            var root = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var augmentationFormula = root.getAugmentationList().stream().filter(af -> af.getFormulaNo() == formula).findFirst().orElseThrow();
            var rawVerbs = augmentedActivePastConjugator.createVerbList(root, augmentationFormula.getFormulaNo());
            var conjugationResult = augmentedTrilateralModifier.build(root, common.getKindOfVerb(rootLetters), augmentationFormula.getFormulaNo(), rawVerbs, SystemConstants.PAST_TENSE
                    , true, true, () -> true ).getFinalResult();
            for(var v : conjugationResult){
                result.add(v.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        return result;
    }
}
