package sarftests.verb.tri.unaugmented.active;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sarf.SystemConstants;
import sarf.Word;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.UnaugmentedImperativeConjugator;
import sarftests.VerbState;
import sarftests.PronounIndex;
import sarftests.TestContext;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class PresentConjugationSteps {
    private final TestContext testContext;
    private final Common common;
    private final ActivePresentConjugator conjugator;
    private final UnaugmentedImperativeConjugator imperativeConjugator;
    private final UnaugmentedTrilateralModifier modifier;

    @Inject
    public PresentConjugationSteps(TestContext testContext, Common common, ActivePresentConjugator conjugator, UnaugmentedImperativeConjugator imperativeConjugator, UnaugmentedTrilateralModifier modifier){
        this.testContext = testContext;
        this.common = common;
        this.conjugator = conjugator;
        this.imperativeConjugator = imperativeConjugator;
        this.modifier = modifier;
    }
    @When("the verb is conjugated in {string} state")
    public void theVerbIsConjugatedInState(String state) {
       this.testContext.VerbState = VerbState.valueOf(state);
    }
    @Then("first person singular present conjugation the verb {string} and conjugation of {string} is {string}")
    public void firstPersonSingularPresentConjugationTheVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.FirstPersonSingular);
    }

    @And("first person plural present conjugation the verb {string} and conjugation of {string} is {string}")
    public void firstPersonPluralPresentConjugationTheVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.FirstPersonPlural);
    }

    @And("masculine singular second person present conjugation the verb {string} and conjugation of {string} is {string}")
    public void masculineSingularSecondPersonPresentConjugationTheVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.SecondPersonMasculineSingular);
    }

    @And("feminine singular second person present conjugation the verb {string} and conjugation of {string} is {string}")
    public void feminineSingularSecondPersonPresentConjugationTheVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.SecondPersonFeminineSingular);
    }

    @And("masculine dual second person present conjugation the verb {string} and conjugation of {string} is {string}")
    public void masculineDualSecondPersonPresentConjugationTheVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.SecondPersonDual);
    }

    @And("masculine plural second person present conjugation the verb {string} and conjugation of {string} is {string}")
    public void masculinePluralSecondPersonPresentConjugationTheVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.SecondPersonMasculinePlural);
    }

    @And("feminine plural second person present conjugation the verb {string} and conjugation of {string} is {string}")
    public void femininePluralSecondPersonPresentConjugationTheVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.SecondPersonFemininePlural);
    }

    @And("masculine singular third person present conjugation the verb {string} and conjugation of {string} is {string}")
    public void masculineSingularThirdPersonPresentConjugationTheVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.ThirdPersonMasculineSingular);
    }

    @And("feminine singular third person present conjugation the verb {string} and conjugation of {string} is {string}")
    public void feminineSingularThirdPersonPresentConjugationTheVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.ThirdPersonFeminineSingular);
    }

    @And("masculine dual third person present conjugation the verb {string} and conjugation of {string} is {string}")
    public void masculineDualThirdPersonPresentConjugationTheVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.ThirdPersonMasculineDual);
    }

    @And("feminine dual third person present conjugation the verb {string} and conjugation of {string} is {string}")
    public void feminineDualThirdPersonPresentConjugationTheVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.ThirdPersonFeminineDual);
    }

    @And("masculine plural third person present conjugation the verb {string} and conjugation of {string} is {string}")
    public void masculinePluralThirdPersonPresentConjugationTheVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.ThirdPersonMasculinePlural);
    }

    @And("feminine plural third person present conjugation the verb {string} and conjugation of {string} is {string}")
    public void femininePluralThirdPersonPresentConjugationTheVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.ThirdPersonFemininePlural);
    }

    private void assertConjugation(String verb, String conjugation, String expected, PronounIndex pronounIndex) {
        var verbs = getPresentVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(pronounIndex.getValue())).isEqualTo(expected);
    }

    private List<String> getPresentVerbConjugations(String rootLetters, int conjugation) {
        var verbStateString = SystemConstants.PRESENT_TENSE;
        if(this.testContext.VerbState == VerbState.Imperative){
            verbStateString = SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE;
        }else if(this.testContext.VerbState == VerbState.ImperativeEmphasized){
            verbStateString = SystemConstants.EMPHASIZED_IMPERATIVE_TENSE;
        }

        var kov = common.getKindOfVerb(rootLetters);

        var root = common.createRoot(rootLetters, conjugation);
        var verbs = getVerbs(root, testContext.VerbState);
        var conjResult = modifier
                .build(root, kov, verbs, verbStateString, true);
        var result = new ArrayList<String>();
        for (var v : conjResult.getFinalResult()) {
            if(v == null){
                result.add("");
                continue;
            }
            result.add(v.toString());
        }
        return result;
    }

    private List<? extends Word> getVerbs(UnaugmentedTrilateralRoot root, VerbState verbState) {
        switch (verbState){
            case Nominative:
                return conjugator.createNominativeVerbList(root);
            case Accusative:
                return conjugator.createAccusativeVerbList(root);
            case Jussive:
                return conjugator.createJussiveVerbList(root);
            case Emphasized:
                return conjugator.createEmphasizedVerbList(root);
            case Imperative:
                return imperativeConjugator.createVerbList(root);
            case ImperativeEmphasized:
                return imperativeConjugator.createEmphasizedVerbList(root);
            case None:
            default:
                fail("invalid present verb state " + verbState);
        }
        return null;
    }
}
