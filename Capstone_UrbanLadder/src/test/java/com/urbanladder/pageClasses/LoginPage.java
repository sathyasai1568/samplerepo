package com.urbanladder.pageClasses;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.urbanladder.objectLocators.Locators;
import com.urbanladder.utility.Reports;

public class LoginPage {

	static WebDriver driver;

	Locators locators;

	static ExtentTest test;

	public LoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		this.locators = new Locators();

	}

	// Method to enter the email

	public void enterEmail(String email) {

		WebElement emailField = driver.findElement(locators.emailFieldatLoginfield);
		emailField.sendKeys(email);
	}

	// Method to enter the password

	public void enterPassword(String password) {

		WebElement passwordField = driver.findElement(locators.passwordFieldatloginfield);

		passwordField.clear();

		passwordField.sendKeys(password);

	}

	// Method to click on the login button

	public void clickLoginButton() {

		WebElement loginButton = driver.findElement(locators.logIn);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(loginButton));

		loginButton.click();

	}

	public static boolean isLoginSuccessful() {
		try {
			// return driver.findElements(Locators.Login_Failure_Message).isEmpty();
			boolean isSuccess = driver.findElements(Locators.Login_Failure_Message).isEmpty();
			if (isSuccess) {
				Reports.generateReport(driver, test, Status.PASS, "Login was successful");
			} else {
				Reports.generateReport(driver, test, Status.FAIL, "Login failed");
			}
			return isSuccess;
		} catch (TimeoutException e) {
			Reports.generateReport(driver, test, Status.FAIL, "Error checking login status");
			return false;
		}
	}

	// Method to click the homepage element

	public void clickHomePageElement() {

		WebElement homePageElement = driver.findElement(locators.homePageElement);

		homePageElement.click();

	}

	// Method to check if the special discount message is displayed

	public boolean isSpecialDiscountMessageDisplayed() {

		WebElement discountMessage = driver.findElement(locators.discount);

		return discountMessage.isDisplayed();

	}

}