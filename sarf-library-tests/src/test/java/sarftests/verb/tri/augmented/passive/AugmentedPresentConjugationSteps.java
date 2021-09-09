package sarftests.verb.tri.augmented.passive;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator;
import sarftests.PronounIndex;
import sarftests.TestContext;
import sarftests.VerbState;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class AugmentedPresentConjugationSteps {

    private final Common common;
    private final SarfDictionary sarfDictionary;
    private final AugmentedPassivePresentConjugator conjugator;
    private final AugmentedTrilateralModifier modifier;
    private final TestContext testContext;

    @Inject
    public AugmentedPresentConjugationSteps(Common common
            , SarfDictionary sarfDictionary
            , AugmentedPassivePresentConjugator conjugator
            , AugmentedTrilateralModifier modifier
            , TestContext testContext) {
        this.common = common;
        this.sarfDictionary = sarfDictionary;
        this.conjugator = conjugator;
        this.modifier = modifier;
        this.testContext = testContext;
    }

    @When("the augmented passive verb is conjugated in {string} state")
    public void theAugmentedPassiveVerbIsConjugatedInState(String state) {
        this.testContext.VerbState = VerbState.valueOf(state);
    }

    @Then("first person singular present conjugation the passive verb {string} and formula of {string} is {string}")
    public void firstPersonSingularPresentConjugationThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb, Integer.parseInt(formula), expected, PronounIndex.FirstPersonSingular);
    }

    @And("first person plural present conjugation the passive verb {string} and formula of {string} is {string}")
    public void firstPersonPluralPresentConjugationThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb, Integer.parseInt(formula), expected, PronounIndex.FirstPersonPlural);
    }

    @And("masculine singular second person present conjugation the passive verb {string} and formula of {string} is {string}")
    public void masculineSingularSecondPersonPresentConjugationThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonMasculineSingular);
    }

    @And("feminine singular second person present conjugation the passive verb {string} and formula of {string} is {string}")
    public void feminineSingularSecondPersonPresentConjugationThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonFeminineSingular);
    }

    @And("masculine dual second person present conjugation the passive verb {string} and formula of {string} is {string}")
    public void masculineDualSecondPersonPresentConjugationThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonDual);
    }

    @And("masculine plural second person present conjugation the passive verb {string} and formula of {string} is {string}")
    public void masculinePluralSecondPersonPresentConjugationThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonMasculinePlural);
    }

    @And("feminine plural second person present conjugation the passive verb {string} and formula of {string} is {string}")
    public void femininePluralSecondPersonPresentConjugationThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonFemininePlural);
    }

    @And("masculine singular third person present conjugation the passive verb {string} and formula of {string} is {string}")
    public void masculineSingularThirdPersonPresentConjugationThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculineSingular);
    }

    @And("feminine singular third person present conjugation the passive verb {string} and formula of {string} is {string}")
    public void feminineSingularThirdPersonPresentConjugationThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFeminineSingular);
    }

    @And("masculine dual third person present conjugation the passive verb {string} and formula of {string} is {string}")
    public void masculineDualThirdPersonPresentConjugationThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculineDual);
    }

    @And("feminine dual third person present conjugation the passive verb {string} and formula of {string} is {string}")
    public void feminineDualThirdPersonPresentConjugationThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFeminineDual);
    }

    @And("masculine plural third person present conjugation the passive verb {string} and formula of {string} is {string}")
    public void masculinePluralThirdPersonPresentConjugationThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculinePlural);
    }

    @And("feminine plural third person present conjugation the passive verb {string} and formula of {string} is {string}")
    public void femininePluralThirdPersonPresentConjugationThePassiveVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugations(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFemininePlural);
    }

    private void assertConjugations(String verb, int formula, String expected, PronounIndex pronounIndex) {
        var verbs = getVerbs(verb, formula);
        assertThat(verbs).isNotNull();
        assertThat(verbs.size()).isEqualTo(13);
        assertThat(verbs.get(pronounIndex.getValue())).isEqualTo(expected);
    }

    private List<String> getVerbs(String rootLetters, int formula) {
        AugmentedTrilateralRoot root = null;
        try {
            root = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var kov = common.getKindOfVerb(rootLetters);
            var augmentationFormula = root.getAugmentationList().stream().filter(f -> f.getFormulaNo() == formula).findFirst().orElseThrow();
            var verbs = getRawVerbs(root, augmentationFormula.getFormulaNo(), testContext.VerbState);
            var conjugationResult = modifier.build(root, kov, augmentationFormula.getFormulaNo(), verbs, SystemConstants.PRESENT_TENSE
                    , false, () -> true).getFinalResult();
            var result = new ArrayList<String>();
            for (var v : conjugationResult) {
                if (v == null) {
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

    private List getRawVerbs(AugmentedTrilateralRoot root, int formulaNo, VerbState verbState) {
        switch (verbState) {
            case PassiveNominative:
                return conjugator.getNominativeConjugator().createVerbList(root, formulaNo);
            case PassiveAccusative:
                return conjugator.getAccusativeConjugator().createVerbList(root, formulaNo);
            case PassiveJussive:
                return conjugator.getJussiveConjugator().createVerbList(root, formulaNo);
            case PassiveEmphasized:
                return conjugator.getEmphasizedConjugator().createVerbList(root, formulaNo);
            default:
                fail("Invalid verb state: " + verbState);
        }
        return null;
    }
}
