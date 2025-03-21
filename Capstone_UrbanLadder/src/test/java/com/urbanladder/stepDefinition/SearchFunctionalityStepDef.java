package com.urbanladder.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.objectLocators.Locators;
import com.urbanladder.pageClasses.SearchFunctionalityPage;
import com.urbanladder.utility.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SearchFunctionalityStepDef {

	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	SearchFunctionalityPage sfp = new SearchFunctionalityPage(driver, test);

//	@Given("the user is on the home page")
//
//	public void the_user_is_on_the_home_page() {
//		boolean actResult = sfp.validUrl();
//		Assert.assertTrue("Search Functionality URL validation failed", actResult);
//	}

	@Then("the user should see the searchbar")
	public void the_user_should_see_the_searchbar() {
		boolean actResult = sfp.SearchDisp();
		Assert.assertTrue(actResult);
	}

	@And("the enters the {string} name in searchbar")
	public void the_enters_the_name_in_searchbar(String product) {
		boolean actResult = sfp.SearchProduct(product);
		Assert.assertTrue(actResult);
	}

	@And("the user can filter the product based on new arrivals")
	public void the_user_can_filter_the_product_based_on_new_arrivals() {
		boolean actResult = sfp.SearchPdOnNewArrivals();
		Assert.assertTrue(actResult);
	}

	@And("the user can filter product on Low to high")
	public void the_user_can_filter_product_on_low_to_high() {
		boolean actResult = sfp.SearchPdOnLowtoHigh();
		Assert.assertTrue(actResult);
	}

	@And("the user can filter product on high to low")
	public void the_user_can_filter_product_on_high_to_low() {
		boolean actResult = sfp.SearchPdOnHightoLow();
		Assert.assertTrue(actResult);
		driver.findElement(Locators.ubHb).click();
		
	}
}
