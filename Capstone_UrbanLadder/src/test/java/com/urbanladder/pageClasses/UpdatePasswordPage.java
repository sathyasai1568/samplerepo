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

public class UpdatePasswordPage {

	WebDriver driver;
	ExtentTest test;
	Locators locators;
	private WebDriverWait wait;

	public UpdatePasswordPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;
		this.locators = new Locators();

	}

	public void navigateToProfile() {

		driver.findElement(locators.profileIcon).click();

		driver.findElement(locators.profile).click();

	}

	public void clickEditButton() {

		driver.findElement(locators.Edit).click();

	}

	public void enterUserDetails(String name, String number, String password) {

		driver.findElement(locators.inputName).clear();
		driver.findElement(locators.inputName).sendKeys(name);
		driver.findElement(locators.inputMobile).clear();
		driver.findElement(locators.inputMobile).sendKeys(number);
		driver.findElement(locators.changePass).click();
		driver.findElement(locators.NewPass).clear();
		driver.findElement(locators.NewPass).sendKeys(password);
		driver.findElement(locators.Cnfpass).clear();
		driver.findElement(locators.Cnfpass).sendKeys(password);
	}

	public void clickUpdateButton() {
		// boolean actResult;
		driver.findElement(locators.updateButton).click();
//		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.updateButton));
//		if (element.isDisplayed()) {
//			actResult = true;
//			Reports.generateReport(driver, test, Status.PASS, "Updatebutton is displayed and clicked..");
//			System.out.println("element displayeed");
//		} else {
//			actResult = false;
//			Reports.generateReport(driver, test, Status.FAIL, "Updatebutton not displayed!!");
//			System.out.println("Element not displayed");
//		}
//
//		return actResult;

	}

	public String getSuccessMessage() {

		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.successMessage));
			Reports.generateReport(driver, test, Status.PASS, "Profile update success message displayed");
			return successMsg.getText();
		} catch (TimeoutException e) {
			Reports.generateReport(driver, test, Status.FAIL, "Profile update success message not displayed");
			return null;
		}

	}
}