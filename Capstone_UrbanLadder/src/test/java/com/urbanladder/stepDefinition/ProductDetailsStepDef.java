package com.urbanladder.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.pageClasses.ProductDetailsPage;
import com.urbanladder.pageClasses.SearchFunctionalityPage;
import com.urbanladder.utility.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import junit.framework.Assert;

public class ProductDetailsStepDef {
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	ProductDetailsPage pdp = new ProductDetailsPage(driver, test);

	@Given("the user is on the search page")
	public void the_user_is_on_the_search_page() {
	}

	@And("click on product and validate the title,description and price")
	public void click_on_product_and_validate_the_title_description_and_price() {
		pdp.clicking();
		boolean k = pdp.verifyTitle();
		Assert.assertTrue(k);
		boolean l = pdp.verifyProductDetails();
		Assert.assertTrue(l);
		boolean o = pdp.verifyProuductPrice();
		Assert.assertTrue(o);

	}

	@And("the user should add the product to wishlist")
	public void the_user_should_add_the_product_to_wishlist() {

		pdp.addToWishlist();
		boolean k = pdp.addToWishlistValid();
		Assert.assertTrue(k);
	}

	@And("the user add the product  from wishlist to cart")
	public void the_user_add_the_product_from_wishlist_to_cart() {
		pdp.AddedToCart();
		boolean k = pdp.CartValidate();
		Assert.assertTrue(k);
	}

	@And("removing product from cart")
	public void removing_Product() {
		boolean k = pdp.Removeproduct();
		Assert.assertTrue(k);
		driver.navigate().back();
		driver.navigate().back();
	}
}