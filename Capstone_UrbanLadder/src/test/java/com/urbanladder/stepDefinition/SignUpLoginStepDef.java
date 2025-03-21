package com.urbanladder.stepDefinition;

import static org.testng.Assert.assertTrue;

import java.util.List;

import java.util.Map;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.pageClasses.LoginPage;
import com.urbanladder.pageClasses.SearchFunctionalityPage;
import com.urbanladder.pageClasses.SignUpPage;

import com.urbanladder.pageClasses.UpdatePasswordPage;

import com.urbanladder.utility.Base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

public class SignUpLoginStepDef {

	public SignUpPage signupPage;
	public UpdatePasswordPage updatePasswordPage;
	public LoginPage loginPage;
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	SignUpPage sp = new SignUpPage(driver, test);

	public SignUpLoginStepDef() {

		this.signupPage = new SignUpPage(driver, test);

		this.updatePasswordPage = new UpdatePasswordPage(driver, test);

		this.loginPage = new LoginPage(driver, test); // Added LoginPage instance

	}

	// ====== Signup Scenario ======

	@Given("user in home page navigates to signup under profile icon")

	public void the_user_is_on_the_signup_page() {
		signupPage.navigateToSignup();

	}

	@When("the user enters a valid email {string} and password {string}")

	public void the_user_enters_a_valid_email_and_password(String email, String password) {

		signupPage.enterEmail(email);

		signupPage.enterPassword(password);

	}

	@And("clicks the Sign Up button")

	public void clicks_the_sign_up_button() {
		boolean k = signupPage.clickSignUp();
		Assert.assertTrue(k);

	}

	@And("the user should be successfully logged in")

	public void the_user_should_be_successfully_logged_in() {

		signupPage.verifySuccessfulLogin();

	}

	// ====== Password Reset Scenario ======

	@Given("user navigates to profile under profile icon")

	public void user_navigates_to_profile() {

		updatePasswordPage.navigateToProfile();

	}

	@And("click on the edit button and change password")

	public void click_on_the_edit_button_and_change_password() {

		updatePasswordPage.clickEditButton();

	}

	@When("the user enters below details and click on update")

	public void the_user_enters_below_details_and_click_on_update(DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> row : data) {

			String name = row.get("Name");

			String number = row.get("Number");

			String password = row.get("Password");

			updatePasswordPage.enterUserDetails(name, number, password);
			updatePasswordPage.clickUpdateButton();
		}

	}

	@Then("user should get {string} message as success")

	public void user_should_get_message_as_success(String expectedMessage) {

		Assert.assertEquals(expectedMessage, updatePasswordPage.getSuccessMessage(),"Profile update failed!");
	}

	// ====== Login Scenario ======

	@Given("user is on the login page after password update")
	public void user_is_on_the_login_page_after_password_update() {
	}

	@When("the user enters email and password from the map and clicks login")

	public void the_user_enters_email_and_password(DataTable credentials) {

		// Iteratating mails and passwrods as pairs from table

		for (Map<String, String> entry : credentials.asMaps(String.class, String.class)) {

			String email = entry.get("email");

			String password = entry.get("password");

			loginPage.enterEmail(email);

			loginPage.enterPassword(password);

			loginPage.clickLoginButton();

		}

	}

	@And("user click on home page element")

	public void clickon_homepage_element() {

		loginPage.clickHomePageElement();

	}

	@Then("User should see {string}")
	public void i_should_see(String string) {
		Assert.assertTrue(LoginPage.isLoginSuccessful());
		System.out.println("successfully loged in..");

	}
}
