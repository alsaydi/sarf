package bdd;

import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSteps {
    
    @Given("an initial state")
    public void anInitialState() {
        System.out.println("given");
    }

    @And("I have {int} as a number")
    public void iHaveAsANumber(int arg0) {
        System.out.println("And " + arg0);
    }

    @And("I pass a parameter like {string} to given")
    public void iPassAParameterLikeToGiven(String arg0) {
        System.out.println("given " + arg0);
    }

    @When("something happens")
    public void somethingHappens() {
        System.out.println("when");
    }

    @Then("assertion takes place")
    public void assertionTakesPlace() {
        assertThat(true).isTrue();
    }

}
