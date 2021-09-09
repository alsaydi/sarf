package sarftests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"html:output"})
@CucumberOptions(plugin = {"pretty"}, strict = true)
public class RunCucumberTest {
}
