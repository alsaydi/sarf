package sarftests.noun.quad.augmented;
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
import sarftests.RootType;
import sarftests.TestContext;
import sarftests.noun.NounIndex;
import sarftests.noun.NounProviderFactory;
import sarftests.noun.NounType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NounConjugationSteps {

    private final NounProviderFactory nounProviderFactory;
    private final TestContext testContext;

    @Inject
    public NounConjugationSteps(NounProviderFactory nounProviderFactory, TestContext testContext){
        this.nounProviderFactory = nounProviderFactory;
        this.testContext = testContext;
    }

    @When("the derived noun is from an augmented quad verb is {string}")
    public void theDerivedNounIsFromAnAugmentedVerbIs(String nounType) {
        testContext.RootType = RootType.QuadrilateralAugmented;
        testContext.NounType = NounType.valueOf(nounType);
    }

    @Then("singular masculine nouns of the quad verb {string} of formula {string} are nominative {string} and accusative {string} and genitive {string}")
    public void singularMasculineNounsOfTheVerbOfFormulaAreNominativeAndAccusativeAndGenitive(String verb, String formula, String nominative, String accusative, String genitive) {
        assertNoun(verb, Integer.parseInt(formula), nominative, NounIndex.NominativeSingleMasculine);
        assertNoun(verb, Integer.parseInt(formula), accusative, NounIndex.AccusativeSingleMasculine);
        assertNoun(verb, Integer.parseInt(formula), genitive, NounIndex.GenitiveSingleMasculine);
    }

    @And("singular feminine nouns of the quad verb {string} of formula {string} are nominative {string} and accusative {string} and genitive {string}")
    public void singularFeminineNounsOfTheVerbOfFormulaAreNominativeAndAccusativeAndGenitive(String verb, String formula, String nominative, String accusative, String genitive) {
        assertNoun(verb, Integer.parseInt(formula), nominative, NounIndex.NominativeSingleFeminine);
        assertNoun(verb, Integer.parseInt(formula), accusative, NounIndex.AccusativeSingleFeminine);
        assertNoun(verb, Integer.parseInt(formula), genitive, NounIndex.GenitiveSingleFeminine);
    }

    @And("dual masculine nouns of the quad verb {string} of formula {string} are nominative {string} and accusative {string} and genitive {string}")
    public void dualMasculineNounsOfTheVerbOfFormulaAreNominativeAndAccusativeAndGenitive(String verb, String formula, String nominative, String accusative, String genitive) {
        assertNoun(verb, Integer.parseInt(formula), nominative, NounIndex.NominativeDualMasculine);
        assertNoun(verb, Integer.parseInt(formula), accusative, NounIndex.AccusativeDualMasculine);
        assertNoun(verb, Integer.parseInt(formula), genitive, NounIndex.GenitiveDualMasculine);
    }

    @And("dual feminine nouns of the quad verb {string} of formula {string} are nominative {string} and accusative {string} and genitive {string}")
    public void dualFeminineNounsOfTheVerbOfFormulaAreNominativeAndAccusativeAndGenitive(String verb, String formula, String nominative, String accusative, String genitive) {
        assertNoun(verb, Integer.parseInt(formula), nominative, NounIndex.NominativeDualFeminine);
        assertNoun(verb, Integer.parseInt(formula), accusative, NounIndex.AccusativeDualFeminine);
        assertNoun(verb, Integer.parseInt(formula), genitive, NounIndex.GenitiveDualFeminine);
    }

    @And("plural masculine nouns of the quad verb {string} of formula {string} are nominative {string} and accusative {string} and genitive {string}")
    public void pluralMasculineNounsOfTheVerbOfFormulaAreNominativeAndAccusativeAndGenitive(String verb, String formula, String nominative, String accusative, String genitive) {
        assertNoun(verb, Integer.parseInt(formula), nominative, NounIndex.NominativePluralMasculine);
        assertNoun(verb, Integer.parseInt(formula), accusative, NounIndex.AccusativePluralMasculine);
        assertNoun(verb, Integer.parseInt(formula), genitive, NounIndex.GenitivePluralMasculine);
    }

    @And("plural feminine nouns of the quad verb {string} of formula {string} are nominative {string} and accusative {string} and genitive {string}")
    public void pluralFeminineNounsOfTheVerbOfFormulaAreNominativeAndAccusativeAndGenitive(String verb, String formula, String nominative, String accusative, String genitive) {
        assertNoun(verb, Integer.parseInt(formula), nominative, NounIndex.NominativePluralFeminine);
        assertNoun(verb, Integer.parseInt(formula), accusative, NounIndex.AccusativePluralFeminine);
        assertNoun(verb, Integer.parseInt(formula), genitive, NounIndex.GenitivePluralFeminine);
    }

    private void assertNoun(String verb, int conjugation, String expected, NounIndex nounIndex){
        var nouns = getNouns(verb, conjugation);
        assertThat(nouns.get(nounIndex.getValue())).isEqualTo(expected);
    }

    private List<String> getNouns(String rootLetters, int formula){
        var nounProvider = this.nounProviderFactory.create(testContext.RootType, testContext.NounType);
        return nounProvider.getNouns(rootLetters, formula);
    }
}
