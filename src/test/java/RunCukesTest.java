import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Test runner generates html report in target/html-report location
 */
@CucumberOptions(plugin = "html:target/html-report",
        features = "src/test/resources/", glue = "steps")
public class RunCukesTest extends AbstractTestNGCucumberTests {
}
