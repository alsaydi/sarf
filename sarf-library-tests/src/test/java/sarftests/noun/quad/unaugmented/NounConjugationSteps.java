package sarftests.noun.quad.unaugmented;
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

    private final TestContext testContext;
    private final NounProviderFactory nounProviderFactory;

    @Inject
    public NounConjugationSteps(TestContext testContext, NounProviderFactory nounProviderFactory){
        this.testContext = testContext;
        this.nounProviderFactory = nounProviderFactory;
    }

    @When("the derived noun is {string} from an unaugmented quadrilateral")
    public void theDerivedNounIsFromAnUnaugmentedQuadrilateral(String state) {
        testContext.RootType = RootType.QuadrilateralUnaugmented;
        testContext.NounType = NounType.valueOf(state);
    }

    @Then("singular masculine nouns of the verb {string} nominative {string} and accusative {string} and genitive {string}")
    public void singularMasculineNounsOfTheVerbNominativeAndAccusativeAndGenitive(String verb, String nominative, String accusative, String genitive) {
        assertNoun(verb, nominative, NounIndex.NominativeSingleMasculine);
        assertNoun(verb, accusative, NounIndex.AccusativeSingleMasculine);
        assertNoun(verb, genitive, NounIndex.GenitiveSingleMasculine);
    }

    @And("singular feminine nouns of the verb {string} nominative {string} and accusative {string} and genitive {string}")
    public void singularFeminineNounsOfTheVerbNominativeAndAccusativeAndGenitive(String verb, String nominative, String accusative, String genitive) {
        assertNoun(verb, nominative, NounIndex.NominativeSingleFeminine);
        assertNoun(verb, accusative, NounIndex.AccusativeSingleFeminine);
        assertNoun(verb, genitive, NounIndex.GenitiveSingleFeminine);
    }

    @And("dual masculine nouns of the verb {string} nominative {string} and accusative {string} and genitive {string}")
    public void dualMasculineNounsOfTheVerbNominativeAndAccusativeAndGenitive(String verb, String nominative, String accusative, String genitive) {
        assertNoun(verb, nominative, NounIndex.NominativeDualMasculine);
        assertNoun(verb, accusative, NounIndex.AccusativeDualMasculine);
        assertNoun(verb, genitive, NounIndex.GenitiveDualMasculine);
    }

    @And("dual feminine nouns of the verb {string} nominative {string} and accusative {string} and genitive {string}")
    public void dualFeminineNounsOfTheVerbNominativeAndAccusativeAndGenitive(String verb, String nominative, String accusative, String genitive) {
        assertNoun(verb, nominative, NounIndex.NominativeDualFeminine);
        assertNoun(verb, accusative, NounIndex.AccusativeDualFeminine);
        assertNoun(verb, genitive, NounIndex.GenitiveDualFeminine);
    }

    @And("plural masculine nouns of the verb {string} nominative {string} and accusative {string} and genitive {string}")
    public void pluralMasculineNounsOfTheVerbNominativeAndAccusativeAndGenitive(String verb, String nominative, String accusative, String genitive) {
        assertNoun(verb, nominative, NounIndex.NominativePluralMasculine);
        assertNoun(verb, accusative, NounIndex.AccusativePluralMasculine);
        assertNoun(verb, genitive, NounIndex.GenitivePluralMasculine);
    }

    @And("plural feminine nouns of the verb {string} nominative {string} and accusative {string} and genitive {string}")
    public void pluralFeminineNounsOfTheVerbNominativeAndAccusativeAndGenitive(String verb, String nominative, String accusative, String genitive) {
        assertNoun(verb, nominative, NounIndex.NominativePluralFeminine);
        assertNoun(verb, accusative, NounIndex.AccusativePluralFeminine);
        assertNoun(verb, genitive, NounIndex.GenitivePluralFeminine);
    }


    private void assertNoun(String verb, String expected, NounIndex nounIndex){
        var nouns = getNouns(verb);
        assertThat(nouns.get(nounIndex.getValue())).isEqualTo(expected);
    }

    private List<String> getNouns(String rootLetters){
        var nounProvider = this.nounProviderFactory.create(testContext.RootType, testContext.NounType);
        return nounProvider.getNouns(rootLetters, 0);
    }
}
