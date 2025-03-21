package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features= {"src\\test\\resources\\FeaturePkg\\AccountCreation.feature"},
glue={"stepsDef","hooks"}, 
plugin={"pretty", "html:Reports/cucumber-reports.html",
			"json:Reports/json-reports.json",
"junit:Reports/junit-reports.xml"})
public class RunnerFileTestCase extends AbstractTestNGCucumberTests{

}

