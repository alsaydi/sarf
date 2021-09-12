package sarftests.verb.tri.augmented.active;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sarf.AugmentationFormula;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.verb.trilateral.augmented.AugmentedPresentVerb;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.active.present.AugmentedActivePresentConjugator;
import sarf.verb.trilateral.augmented.imperative.AugmentedImperativeConjugatorFactory;
import sarf.verb.trilateral.augmented.imperative.AugmentedImperativeVerb;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import sarftests.PronounIndex;
import sarftests.TestContext;
import sarftests.VerbState;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.fail;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class AugmentedPresentConjugationSteps {

    private final TestContext testContext;
    private final AugmentedActivePresentConjugator conjugator;
    private final AugmentedImperativeConjugatorFactory imperativeConjugatorFactory;
    private final AugmentedTrilateralModifier modifier;
    private final Common common;
    private final SarfDictionary sarfDictionary;

    @Inject
    public AugmentedPresentConjugationSteps(TestContext testContext
            , AugmentedActivePresentConjugator conjugator
            , AugmentedImperativeConjugatorFactory imperativeConjugatorFactory
            , AugmentedTrilateralModifier modifier
            , Common common
            , SarfDictionary sarfDictionary){
        this.testContext = testContext;
        this.conjugator = conjugator;
        this.imperativeConjugatorFactory = imperativeConjugatorFactory;
        this.modifier = modifier;
        this.common = common;
        this.sarfDictionary = sarfDictionary;
    }

    @When("the augmented trilateral verb is conjugated in {string} state")
    public void theAugmentedTrilateralVerbIsConjugatedInState(String state) {
        testContext.VerbState = VerbState.valueOf(state);
    }

    @Then("first person singular present conjugation the verb {string} and formula of {string} is {string}")
    public void firstPersonSingularPresentConjugationTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.FirstPersonSingular);
    }

    @And("first person plural present conjugation the verb {string} and formula of {string} is {string}")
    public void firstPersonPluralPresentConjugationTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.FirstPersonPlural);
    }

    @And("masculine singular second person present conjugation the verb {string} and formula of {string} is {string}")
    public void masculineSingularSecondPersonPresentConjugationTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonMasculineSingular);
    }

    @And("feminine singular second person present conjugation the verb {string} and formula of {string} is {string}")
    public void feminineSingularSecondPersonPresentConjugationTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonFeminineSingular);
    }

    @And("masculine dual second person present conjugation the verb {string} and formula of {string} is {string}")
    public void masculineDualSecondPersonPresentConjugationTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonDual);
    }

    @And("masculine plural second person present conjugation the verb {string} and formula of {string} is {string}")
    public void masculinePluralSecondPersonPresentConjugationTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonMasculinePlural);
    }

    @And("feminine plural second person present conjugation the verb {string} and formula of {string} is {string}")
    public void femininePluralSecondPersonPresentConjugationTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.SecondPersonFemininePlural);
    }

    @And("masculine singular third person present conjugation the verb {string} and formula of {string} is {string}")
    public void masculineSingularThirdPersonPresentConjugationTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculineSingular);
    }

    @And("feminine singular third person present conjugation the verb {string} and formula of {string} is {string}")
    public void feminineSingularThirdPersonPresentConjugationTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFeminineSingular);
    }

    @And("masculine dual third person present conjugation the verb {string} and formula of {string} is {string}")
    public void masculineDualThirdPersonPresentConjugationTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculineDual);
    }

    @And("feminine dual third person present conjugation the verb {string} and formula of {string} is {string}")
    public void feminineDualThirdPersonPresentConjugationTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFeminineDual);
    }

    @And("masculine plural third person present conjugation the verb {string} and formula of {string} is {string}")
    public void masculinePluralThirdPersonPresentConjugationTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonMasculinePlural);
    }

    @And("feminine plural third person present conjugation the verb {string} and formula of {string} is {string}")
    public void femininePluralThirdPersonPresentConjugationTheVerbAndFormulaOfIs(String verb, String formula, String expected) {
        assertConjugation(verb, Integer.parseInt(formula), expected, PronounIndex.ThirdPersonFemininePlural);
    }

    private void assertConjugation(String verb, int formula, String expected, PronounIndex pronounIndex) {
        var verbs = getVerbs(verb, formula);
        assertThat(verbs).isNotNull();
        assertThat(verbs.size()).isEqualTo(13);
        assertThat(verbs.get(pronounIndex.getValue())).isEqualTo(expected);
    }

    private List<String> getVerbs(String rootLetters, int formula) {
        try {
            var root = sarfDictionary.getAugmentedTrilateralRoot(rootLetters);
            var augmentationFormula = root.getAugmentationList().stream().filter(af -> af.getFormulaNo() == formula).findFirst().orElseThrow();
            List<AugmentedPresentVerb> rawVerbs;
            switch (testContext.VerbState){
                case Nominative:
                    rawVerbs = conjugator.getNominativeConjugator().createVerbList(root, augmentationFormula.getFormulaNo());
                    break;
                case Accusative:
                    rawVerbs = conjugator.getAccusativeConjugator().createVerbList(root, augmentationFormula.getFormulaNo());
                    break;
                case Jussive:
                    rawVerbs = conjugator.getJussiveConjugator().createVerbList(root, augmentationFormula.getFormulaNo());
                    break;
                case Emphasized:
                    rawVerbs = conjugator.getEmphasizedConjugator().createVerbList(root, augmentationFormula.getFormulaNo());
                    break;
                case Imperative:
                case ImperativeEmphasized:
                    return getImperativeVerbs(rootLetters, root, augmentationFormula);
                default:
                    throw new Exception(String.format("%s is invalid", testContext.VerbState));
            }
            var list = modifier.build(root, common.getKindOfVerb(rootLetters), augmentationFormula.getFormulaNo(), rawVerbs
            , SystemConstants.PRESENT_TENSE, true, () -> true).getFinalResult();

            var finalResult = new ArrayList<String>();
            for(var i : list){
                finalResult.add(i.toString());
            }
            return finalResult;
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        return null;
    }

    private List<String> getImperativeVerbs(String rootLetters, AugmentedTrilateralRoot root, AugmentationFormula augmentationFormula) throws Exception {
        var verbType = SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE;
        List<AugmentedImperativeVerb> rawVerbs;

        switch (testContext.VerbState) {
            case Imperative:
                rawVerbs = imperativeConjugatorFactory.getNotEmphasizedConjugator().createVerbList(root, augmentationFormula.getFormulaNo());
                break;
            case ImperativeEmphasized:
                verbType = SystemConstants.EMPHASIZED_IMPERATIVE_TENSE;
                rawVerbs = imperativeConjugatorFactory.getEmphasizedConjugator().createVerbList(root, augmentationFormula.getFormulaNo());
                break;
            default:
                throw new Exception(String.format("%s is invalid", testContext.VerbState));
        }
        var list = modifier.build(root, common.getKindOfVerb(rootLetters), augmentationFormula.getFormulaNo(), rawVerbs
                , verbType, true, () -> true).getFinalResult();

        var finalResult = new ArrayList<String>();
        for(var i : list){
            if(i == null){
                finalResult.add("");
                continue;
            };
            finalResult.add(i.toString());
        }
        return finalResult;
    }
}
