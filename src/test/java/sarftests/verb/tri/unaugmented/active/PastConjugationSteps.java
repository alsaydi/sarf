package sarftests.verb.tri.unaugmented.active;

import com.google.inject.Inject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sarf.KindOfVerb;
import sarf.SystemConstants;
import sarf.verb.trilateral.unaugmented.active.ActivePastConjugator;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static sarftests.PronounIndex.*;

public class PastConjugationSteps {
    private final ActivePastConjugator activePastConjugator;
    private final UnaugmentedTrilateralModifier modifier;
    private final Common common;

    @Inject
    public PastConjugationSteps(ActivePastConjugator activePastConjugator
            , UnaugmentedTrilateralModifier modifier
            , Common common){
        this.activePastConjugator = activePastConjugator;
        this.modifier = modifier;
        this.common = common;
    }

    @Given("an unaugmented verb")
    public void anUnaugmentedVerb() {
    }

    @Given("an unaugmented verb {string} of the conjugation {string}")
    public void anUnaugmentedVerbOfTheConjugation(String verb, String conjugation) {
    }

    @When("the verb is conjugated")
    public void theVerbIsConjugated() {
    }

    @Then("the first person singular conjugation of the verb {string} and conjugation of {string} is {string}")
    public void theFirstPersonSingularConjugationsOfTheVerbIs(String verb, String conjugation, String arg1) {
        var verbs = getPastVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(FirstPersonSingular.getValue())).isEqualTo(arg1);
    }

    @And("the first person plural conjugation of the verb {string} and conjugation of {string} is {string}")
    public void theFirstPersonPluralConjugationsOfTheVerbIs(String verb, String conjugation, String arg1) {
        var verbs = getPastVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(FirstPersonPlural.getValue())).isEqualTo(arg1);
    }

    @And("the masculine singular second person conjugation of the verb {string} and conjugation of {string} is {string}")
    public void theMasculineSingularSecondPersonConjugationsOfTheVerbIs(String verb, String conjugation, String arg1) {
        var verbs = getPastVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(SecondPersonMasculineSingular.getValue())).isEqualTo(arg1);
    }

    @And("the feminine singular second person conjugation of the verb {string} and conjugation of {string} is {string}")
    public void theFeminineSingularSecondPersonConjugationsOfTheVerbIs(String verb, String conjugation, String arg1) {
        var verbs = getPastVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(SecondPersonFeminineSingular.getValue())).isEqualTo(arg1);
    }

    @And("the masculine dual second person conjugation of the verb {string} and conjugation of {string} is {string}")
    public void theMasculineDualSecondPersonConjugationsOfTheVerbIs(String verb, String conjugation, String arg1) {
        var verbs = getPastVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(SecondPersonDual.getValue())).isEqualTo(arg1);
    }

    @And("the masculine plural second person conjugation of the verb {string} and conjugation of {string} is {string}")
    public void theMasculinePluralSecondPersonConjugationsOfTheVerbIs(String verb, String conjugation, String arg1) {
        var verbs = getPastVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(SecondPersonMasculinePlural.getValue())).isEqualTo(arg1);
    }

    @And("the feminine plural second person conjugation of the verb {string} and conjugation of {string} is {string}")
    public void theFemininePluralSecondPersonConjugationsOfTheVerbIs(String verb, String conjugation, String arg1) {
        var verbs = getPastVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(SecondPersonFemininePlural.getValue())).isEqualTo(arg1);
    }

    @And("the masculine singular third person conjugation of the verb {string} and conjugation of {string} is {string}")
    public void theMasculineSingularThirdPersonConjugationsOfTheVerbIs(String verb, String conjugation, String arg1) {
        var verbs = getPastVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(ThirdPersonMasculineSingular.getValue())).isEqualTo(arg1);
    }

    @And("the feminine singular third person conjugation of the verb {string} and conjugation of {string} is {string}")
    public void theFeminineSingularThirdPersonConjugationsOfTheVerbIs(String verb, String conjugation, String arg1) {
        var verbs = getPastVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(ThirdPersonFeminineSingular.getValue())).isEqualTo(arg1);
    }

    @And("the masculine dual third person conjugation of the verb {string} and conjugation of {string} is {string}")
    public void theMasculineDualThirdPersonConjugationsOfTheVerbIs(String verb, String conjugation, String arg1) {
        var verbs = getPastVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(ThirdPersonMasculineDual.getValue())).isEqualTo(arg1);
    }

    @And("the feminine dual third person conjugation of the verb {string} and conjugation of {string} is {string}")
    public void theFeminineDualThirdPersonConjugationsOfTheVerbIs(String verb, String conjugation, String arg1) {
        var verbs = getPastVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(ThirdPersonFeminineDual.getValue())).isEqualTo(arg1);
    }

    @And("the masculine plural third person conjugation of the verb {string} and conjugation of {string} is {string}")
    public void theMasculinePluralThirdPersonConjugationsOfTheVerbIs(String verb, String conjugation, String arg1) {
        var verbs = getPastVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(ThirdPersonMasculinePlural.getValue())).isEqualTo(arg1);
    }

    @And("the feminine plural third person conjugation of the verb {string} and conjugation of {string} is {string}")
    public void theFemininePluralThirdPersonConjugationsOfTheVerbIs(String verb, String conjugation, String arg1) {
        var verbs = getPastVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(ThirdPersonFemininePlural.getValue())).isEqualTo(arg1);
    }

    private List<String> getPastVerbConjugations(String rootLetters, int conjugation) {
        KindOfVerb kov = common.getKindOfVerb(rootLetters);

        var root = common.createRoot(rootLetters, conjugation);
        var verbs = activePastConjugator.createVerbList(root);
        var conjResult = modifier.build(root, kov, verbs, SystemConstants.PAST_TENSE, true);
        var result = new ArrayList<String>();
        for (var v : conjResult.getFinalResult()) {
            result.add(v.toString());
        }
        return result;
    }
}
