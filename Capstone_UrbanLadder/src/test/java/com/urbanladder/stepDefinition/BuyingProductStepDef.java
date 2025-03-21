package com.urbanladder.stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.pageClasses.BuyingProductPage;
import com.urbanladder.utility.Base;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import junit.framework.Assert;

public class BuyingProductStepDef {
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	BuyingProductPage bpp = new BuyingProductPage(driver, test);

	@And("changing the quantity of product")
	public void changing_the_quantity_of_product() {
		bpp.ClickingQty();
		bpp.UpdateQty();
	}

	@Given ("the user is on the home page..")
	public void kj() {
		System.out.println("now u are at purchasing phase");
	}
	@And("clicking on checkout")
	public void clicking_on_checkout() {
		bpp.ClickCheckout();
	}

	@And("enter the details pincode Address firstname lastname mobile")
	public void enter_the_details(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> row : data) {

			String pincode = row.get("pincode");

			String address = row.get("Address");

			String firstName = row.get("firstname");
			String LastName = row.get("lastname");
			String mobile = row.get("mobile");
			
			bpp.EnterDetails(pincode, address, firstName, LastName, mobile);
		}
	}

	@And("click on Save and Continue button")
	public void click_on_save_and_continue_button() {
		bpp.clickSandContBt();
	}

	@And("then click on place order")
	public void then_click_on_place_order() {
		bpp.ClickPlaceOrder();
		boolean k= bpp.verifyPayment();
		Assert.assertTrue(k);
	}
}
