package testRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/features"},
        plugin = {"pretty", "html:target/cucumber"},
        strict = true,
        glue = {"stepDefinitions"},
        tags={"@Test"}
)

public class CucumberRunner {
}
