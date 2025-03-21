package com.urbanladder.pageClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.urbanladder.objectLocators.Locators;
import com.urbanladder.utility.Reports;

public class SignUpPage {

	WebDriver driver;

	WebDriverWait wait;
	ExtentTest test;
	Locators locators;

	public SignUpPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		this.locators = new Locators();

	}

	public void navigateToSignup() {
		// boolean actResult;
		wait.until(ExpectedConditions.elementToBeClickable(locators.profileIcon)).click();
		wait.until(ExpectedConditions.elementToBeClickable(locators.signUp)).click();
//		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.signUp));
//		if (element.isDisplayed()) {
//			actResult = true;
//			Reports.generateReport(driver, test, Status.PASS, "Signupbutton displayed");
//		} else {
//			actResult = false;
//			Reports.generateReport(driver, test, Status.FAIL, "SignupButton not displayed ");
//		}
//
//		return actResult;

	}

	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locators.userName)).sendKeys(email);
	}

	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locators.password)).sendKeys(password); // Updated
																											// locator
	}

	public boolean clickSignUp() {
		boolean actResult;
		WebElement k=wait.until(ExpectedConditions.elementToBeClickable(locators.signupButton));
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((Locators.signupButton)));
			WebElement element = driver.findElement(Locators.signupButton);
			element.click();

			Reports.generateReport(driver, test, Status.PASS, "Sign up successful");

			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Sign up unsuccessful");

			actResult = false;

		}
		return actResult;
	}

	public void verifySuccessfulLogin() {
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(locators.profileIcon)).isDisplayed(),
				"User is not logged in successfully."); // Updated locator

	}
}