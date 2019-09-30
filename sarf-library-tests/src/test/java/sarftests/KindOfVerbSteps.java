package sarftests;

import com.google.inject.Inject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sarftests.verb.tri.Common;

import static org.junit.Assert.*;

@SuppressWarnings("EmptyMethod")
public class KindOfVerbSteps {
    private final Common common;

    @Inject
    public KindOfVerbSteps(Common common){
        this.common = common;
    }
    @Given("a trilateral unaugmented verb")
    public void aTrilateralUnaugmentedVerb() {
    }

    @When("the kind of verb is request")
    public void theKindOfVerbIsRequest() {
    }

    @Then("the verb <verb> kind is <kind>")
    public void theVerbVerbKindIsKind() {
    }

    @Then("the verb {string} kind is {string}")
    public void theVerbKindIs(String verb, String kind) {
        var kov = common.getKindOfVerb(verb);
        assertEquals(kind, kov.name());
    }
}
