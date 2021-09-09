package sarftests.noun.tri.unaugmented;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sarf.WordPresenter;
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
    public NounConjugationSteps(NounProviderFactory nounProviderFactory, TestContext testContext) {
        this.nounProviderFactory = nounProviderFactory;
        this.testContext = testContext;
    }

    @When("the derived noun is {string} and the root type is {string}")
    public void theDerivedNounIsAndTheRootTypeIs(String nounType, String rootType) {
        testContext.NounType = NounType.valueOf(nounType);
        testContext.RootType = RootType.valueOf(rootType);
    }

    @Then("singular masculine nouns of the verb {string} in conjugation {string} are nominative {string} and accusative {string} and genitive {string} with formula {string}")
    public void singularMasculineNounsOfTheVerbInConjugationAreNominativeAndAccusativeAndGenitive(String verb, String conjugation, String nominative, String accusative, String genitive, String formula) {
        assertNoun(verb, Integer.parseInt(conjugation), nominative, NounIndex.NominativeSingleMasculine, formula);
        assertNoun(verb, Integer.parseInt(conjugation), accusative, NounIndex.AccusativeSingleMasculine, formula);
        assertNoun(verb, Integer.parseInt(conjugation), genitive, NounIndex.GenitiveSingleMasculine, formula);
    }

    @And("singular feminine nouns of the verb {string} in conjugation {string} are nominative {string} and accusative {string} and genitive {string} with formula {string}")
    public void singularFeminineNounsOfTheVerbInConjugationAreNominativeAndAccusativeAndGenitive(String verb, String conjugation, String nominative, String accusative, String genitive, String formula) {
        assertNoun(verb, Integer.parseInt(conjugation), nominative, NounIndex.NominativeSingleFeminine, formula);
        assertNoun(verb, Integer.parseInt(conjugation), accusative, NounIndex.AccusativeSingleFeminine, formula);
        assertNoun(verb, Integer.parseInt(conjugation), genitive, NounIndex.GenitiveSingleFeminine, formula);
    }

    @And("dual masculine nouns of the verb {string} in conjugation {string} are nominative {string} and accusative {string} and genitive {string} with formula {string}")
    public void dualMasculineNounsOfTheVerbInConjugationAreNominativeAndAccusativeAndGenitive(String verb, String conjugation, String nominative, String accusative, String genitive, String formula) {
        assertNoun(verb, Integer.parseInt(conjugation), nominative, NounIndex.NominativeDualMasculine, formula);
        assertNoun(verb, Integer.parseInt(conjugation), accusative, NounIndex.AccusativeDualMasculine, formula);
        assertNoun(verb, Integer.parseInt(conjugation), genitive, NounIndex.GenitiveDualMasculine, formula);
    }

    @And("dual feminine nouns of the verb {string} in conjugation {string} are nominative {string} and accusative {string} and genitive {string} with formula {string}")
    public void dualFeminineNounsOfTheVerbInConjugationAreNominativeAndAccusativeAndGenitive(String verb, String conjugation, String nominative, String accusative, String genitive, String formula) {
        assertNoun(verb, Integer.parseInt(conjugation), nominative, NounIndex.NominativeDualFeminine, formula);
        assertNoun(verb, Integer.parseInt(conjugation), accusative, NounIndex.AccusativeDualFeminine, formula);
        assertNoun(verb, Integer.parseInt(conjugation), genitive, NounIndex.GenitiveDualFeminine, formula);
    }

    @And("plural masculine nouns of the verb {string} in conjugation {string} are nominative {string} and accusative {string} and genitive {string} with formula {string}")
    public void pluralMasculineNounsOfTheVerbInConjugationAreNominativeAndAccusativeAndGenitive(String verb, String conjugation, String nominative, String accusative, String genitive, String formula) {
        assertNoun(verb, Integer.parseInt(conjugation), nominative, NounIndex.NominativePluralMasculine, formula);
        assertNoun(verb, Integer.parseInt(conjugation), accusative, NounIndex.AccusativePluralMasculine, formula);
        assertNoun(verb, Integer.parseInt(conjugation), genitive, NounIndex.GenitivePluralMasculine, formula);
    }

    @And("plural feminine nouns of the verb {string} in conjugation {string} are nominative {string} and accusative {string} and genitive {string} with formula {string}")
    public void pluralFeminineNounsOfTheVerbInConjugationAreNominativeAndAccusativeAndGenitive(String verb, String conjugation, String nominative, String accusative, String genitive, String formula) {
        assertNoun(verb, Integer.parseInt(conjugation), nominative, NounIndex.NominativePluralFeminine, formula);
        assertNoun(verb, Integer.parseInt(conjugation), accusative, NounIndex.AccusativePluralFeminine, formula);
        assertNoun(verb, Integer.parseInt(conjugation), genitive, NounIndex.GenitivePluralFeminine, formula);
    }

    private void assertNoun(String verb, int conjugation, String expected, NounIndex nounIndex, String formula){
        var nouns = getNouns(verb, conjugation, formula);
        assertThat(nouns.get(nounIndex.getValue())).isEqualTo(expected);
    }

    private List<String> getNouns(String rootLetters, int conjugation, String formula){
        var nounProvider = this.nounProviderFactory.create(testContext.RootType, testContext.NounType);
        return nounProvider.getNouns(rootLetters, formula, conjugation);
    }
}
