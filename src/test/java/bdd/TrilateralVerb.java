package bdd;
import cucumber.api.Scenario;
import io.cucumber.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class
TrilateralVerb implements En {
    public TrilateralVerb(){
        When("^conjugation is requested$", () -> {

        });

        Then("^trilateral unaugmented verbs are \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$", (String verb1, String verb2, String verb3, String verb4, String verb5, String verb6) -> {
            assertThat(verb1).isEqualTo("");
        });
        Given("^trilateral root \"([^\"]*)\" to conjugate$", (String root) -> {
        });
    }
}
