package sarftests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"html:output"})
@CucumberOptions(plugin = {"pretty"}, strict = true)
public class RunSarfCucumberTest {
}
