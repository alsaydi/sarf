package sarftests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"html:test_output"})
@CucumberOptions(plugin = {"junit:test_output"}, strict = true)
public class RunSarfCucumberTest {
}
