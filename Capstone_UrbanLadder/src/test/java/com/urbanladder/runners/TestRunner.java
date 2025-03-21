package com.urbanladder.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/features/SSsignUpAndLogin.feature",
				"src/test/resources/features/HomePage.feature",
				"src/test/resources/features/STPSearchFunctionality.feature",
				"src/test/resources/features/STProductDetails.feature",
				"src/test/resources/features/STQBuyingproduct.feature"

				},
		glue = "com.urbanladder.stepDefinition",
		//tags="@HomePage or @Registration or @SearchFunctionality or @ProductDetails",
		plugin = {"pretty","html:src/test/resources/Reports/cucumber-reports/TestRepoOfHomePage.html"
							
		}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
