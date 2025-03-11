package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
    features = {
                "src/test/resources/featureFiles/rediffCreateAcct.feature"
    }, 
    glue = { "stepDefinitions", "hooks" }, 
    plugin = { 
        "pretty", 
        "html:Reports/cucumber-reports.html",
        "json:Reports/cucumber-reports.json"
    }
)
public class RediffRunnerTestCase extends AbstractTestNGCucumberTests {

}