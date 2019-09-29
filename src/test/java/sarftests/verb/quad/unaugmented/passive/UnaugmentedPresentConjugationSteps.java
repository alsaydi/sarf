package sarftests.verb.quad.unaugmented.passive;

import com.google.inject.Inject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.kov.KovRulesManager;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;
import sarf.verb.quadriliteral.unaugmented.passive.PassivePresentVerb;
import sarf.verb.quadriliteral.unaugmented.passive.QuadPassivePresentConjugator;
import sarftests.PronounIndex;
import sarftests.TestContext;
import sarftests.VerbState;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class UnaugmentedPresentConjugationSteps {

    private final TestContext testContext;
    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final QuadPassivePresentConjugator conjugator;
    private final QuadrilateralModifier modifier;

    @Inject
    public UnaugmentedPresentConjugationSteps(TestContext testContext
            , SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager
            , QuadPassivePresentConjugator conjugator
            , QuadrilateralModifier modifier) {
        this.testContext = testContext;
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.conjugator = conjugator;
        this.modifier = modifier;
    }

    @When("the quadrilateral verb is passively conjugated in {string} state")
    public void theQuadrilateralVerbIsConjugatedInState(String state) {
        this.testContext.VerbState = VerbState.valueOf(state);
    }

    @Then("first person singular passive present conjugation the verb {string} is {string}")
    public void firstPersonSingularPresentConjugationTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.FirstPersonSingular);
    }

    @And("first person plural passive present conjugation the verb {string} is {string}")
    public void firstPersonPluralPresentConjugationTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.FirstPersonPlural);
    }

    @And("masculine singular second person passive present conjugation the verb {string} is {string}")
    public void masculineSingularSecondPersonPresentConjugationTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.SecondPersonMasculineSingular);
    }

    @And("feminine singular second person passive present conjugation the verb {string} is {string}")
    public void feminineSingularSecondPersonPresentConjugationTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.SecondPersonFeminineSingular);
    }

    @And("masculine dual second person passive present conjugation the verb {string} is {string}")
    public void masculineDualSecondPersonPresentConjugationTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.SecondPersonDual);
    }

    @And("masculine plural second person passive present conjugation the verb {string} is {string}")
    public void masculinePluralSecondPersonPresentConjugationTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.SecondPersonMasculinePlural);
    }

    @And("feminine plural second person passive present conjugation the verb {string} is {string}")
    public void femininePluralSecondPersonPresentConjugationTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.SecondPersonFemininePlural);
    }

    @And("masculine singular third person passive present conjugation the verb {string} is {string}")
    public void masculineSingularThirdPersonPresentConjugationTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.ThirdPersonMasculineSingular);
    }

    @And("feminine singular third person passive present conjugation the verb {string} is {string}")
    public void feminineSingularThirdPersonPresentConjugationTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.ThirdPersonFeminineSingular);
    }

    @And("masculine dual third person passive present conjugation the verb {string} is {string}")
    public void masculineDualThirdPersonPresentConjugationTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.ThirdPersonMasculineDual);
    }

    @And("feminine dual third person passive present conjugation the verb {string} is {string}")
    public void feminineDualThirdPersonPresentConjugationTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.ThirdPersonFeminineDual);
    }

    @And("masculine plural third person passive present conjugation the verb {string} is {string}")
    public void masculinePluralThirdPersonPresentConjugationTheVerbIs(String verb, String expected) {
        assertConjugations(verb, expected, PronounIndex.ThirdPersonMasculinePlural);
    }

    @And("feminine plural third person passive present conjugation the verb {string} is {string}")
    public void femininePluralThirdPersonPresentConjugationTheVerbIs(String verb, String expected) {
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
            List<PassivePresentVerb> verbs = new ArrayList<>();
            var tense = SystemConstants.PRESENT_TENSE;
            switch (testContext.VerbState) {
                case PassiveNominative:
                    verbs = conjugator.createNominativeVerbList(root);
                    break;
                case PassiveAccusative:
                    verbs = conjugator.createAccusativeVerbList(root);
                    break;
                case PassiveJussive:
                    verbs = conjugator.createJussiveVerbList(root);
                    break;
                case PassiveEmphasized:
                    verbs = conjugator.createEmphasizedVerbList(root);
                    break;
                default:
                    fail("Invalid verb state: " + testContext.VerbState);
            }

            var conjugationResult = modifier.build(root, 0, kovRule.getKov(), verbs
                    , tense, false, true)
                    .getFinalResult();
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
