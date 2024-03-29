package sarftests.verb.tri.unaugmented.passive;
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
import sarf.ConjugationResult;
import sarf.SystemConstants;
import sarf.Word;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.passive.PassivePresentConjugator;
import sarftests.PronounIndex;
import sarftests.TestContext;
import sarftests.VerbState;
import sarftests.verb.tri.Common;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class PresentConjugationSteps {
    private final TestContext testContext;
    private final Common common;
    private final PassivePresentConjugator conjugator;
    private final UnaugmentedTrilateralModifier modifier;

    @Inject
    public PresentConjugationSteps(TestContext testContext
            , Common common
            , PassivePresentConjugator conjugator
            , UnaugmentedTrilateralModifier modifier){
        this.testContext = testContext;
        this.common = common;
        this.conjugator = conjugator;
        this.modifier = modifier;
    }

    @When("the passive verb is conjugated in {string} state")
    public void thePassiveVerbIsConjugatedInState(String state) {
        this.testContext.VerbState = VerbState.valueOf(state);
    }

    @Then("first person singular present conjugation the passive verb {string} and conjugation of {string} is {string}")
    public void firstPersonSingularPresentConjugationThePassiveVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.FirstPersonSingular);
    }

    @And("first person plural present conjugation the passive verb {string} and conjugation of {string} is {string}")
    public void firstPersonPluralPresentConjugationThePassiveVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.FirstPersonPlural);
    }

    @And("masculine singular second person present conjugation the passive verb {string} and conjugation of {string} is {string}")
    public void masculineSingularSecondPersonPresentConjugationThePassiveVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.SecondPersonMasculineSingular);
    }

    @And("feminine singular second person present conjugation the passive verb {string} and conjugation of {string} is {string}")
    public void feminineSingularSecondPersonPresentConjugationThePassiveVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.SecondPersonFeminineSingular);
    }

    @And("masculine dual second person present conjugation the passive verb {string} and conjugation of {string} is {string}")
    public void masculineDualSecondPersonPresentConjugationThePassiveVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.SecondPersonDual);
    }

    @And("masculine plural second person present conjugation the passive verb {string} and conjugation of {string} is {string}")
    public void masculinePluralSecondPersonPresentConjugationThePassiveVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.SecondPersonMasculinePlural);
    }

    @And("feminine plural second person present conjugation the passive verb {string} and conjugation of {string} is {string}")
    public void femininePluralSecondPersonPresentConjugationThePassiveVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.SecondPersonFemininePlural);
    }

    @And("masculine singular third person present conjugation the passive verb {string} and conjugation of {string} is {string}")
    public void masculineSingularThirdPersonPresentConjugationThePassiveVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.ThirdPersonMasculineSingular);
    }

    @And("feminine singular third person present conjugation the passive verb {string} and conjugation of {string} is {string}")
    public void feminineSingularThirdPersonPresentConjugationThePassiveVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.ThirdPersonFeminineSingular);
    }

    @And("masculine dual third person present conjugation the passive verb {string} and conjugation of {string} is {string}")
    public void masculineDualThirdPersonPresentConjugationThePassiveVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.ThirdPersonMasculineDual);
    }

    @And("feminine dual third person present conjugation the passive verb {string} and conjugation of {string} is {string}")
    public void feminineDualThirdPersonPresentConjugationThePassiveVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.ThirdPersonFeminineDual);
    }

    @And("masculine plural third person present conjugation the passive verb {string} and conjugation of {string} is {string}")
    public void masculinePluralThirdPersonPresentConjugationThePassiveVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.ThirdPersonMasculinePlural);
    }

    @And("feminine plural third person present conjugation the passive verb {string} and conjugation of {string} is {string}")
    public void femininePluralThirdPersonPresentConjugationThePassiveVerbAndConjugationOfIs(String verb, String conjugation, String expected) {
        assertConjugation(verb, conjugation, expected, PronounIndex.ThirdPersonFemininePlural);
    }

    private void assertConjugation(String verb, String conjugation, String expected, PronounIndex pronounIndex) {
        var verbs = getPresentPassiveVerbConjugations(verb, Integer.parseInt(conjugation));
        assertThat(verbs.get(pronounIndex.getValue())).isEqualTo(expected);
    }
    private List<String> getPresentPassiveVerbConjugations(String rootLetters, int conjugation){
        var kov = common.getKindOfVerb(rootLetters);
        var root = common.createRoot(rootLetters, conjugation);
        var verbs = getVerbs(root, this.testContext.VerbState);
        ConjugationResult conjResult = modifier
                .build(root, kov, verbs, SystemConstants.PRESENT_TENSE, false);
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

    private List<? extends Word> getVerbs(UnaugmentedTrilateralRoot root, VerbState verbState){
        switch (verbState){
            case PassiveNominative:
                return conjugator.createNominativeVerbList(root);
            case PassiveAccusative:
                return conjugator.createAccusativeVerbList(root);
            case PassiveJussive:
                return conjugator.createJussiveVerbList(root);
            case PassiveEmphasized:
                return conjugator.createEmphasizedVerbList(root);
            case None:
            default:
                fail("invalid present passive verb state " + verbState);
        }
        return null;
    }
}
