package com.urbanladder.pageClasses;


import java.time.Duration;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.urbanladder.objectLocators.Locators;
import com.urbanladder.utility.PropertyReader;

import com.urbanladder.utility.Reports;



public class HomePage {

	private WebDriver driver;

	private WebDriverWait wait;

	ExtentTest test;
	Properties properties;
	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
		this.properties = PropertyReader.readProperty();
	}

	public boolean validUrl() {
		String currURl = driver.getCurrentUrl();

		String actualURL = properties.getProperty("URL");

		boolean actResult;
		if (currURl.equals(actualURL)) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "Urbanladder is launched Successful");
		} else {

			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Urbanladder is launched failure");
		}
		return actResult;
	}
	public boolean verifyTopOffers() {

		boolean actResult;

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.discount));
		if (element.isDisplayed()) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "Urbanladder is launched Successful");
			System.out.println("element displayeed");
		} else {

			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Urbanladder is failed to Launch");
			System.out.println("Element not displayed");
		}
		return actResult;
	}

	public boolean verifyBestSeller() {

		boolean actResult;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.bestSeller));
		if (element.isDisplayed()) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "Best Seller Element is present on the Home Page");
			System.out.println("element displayeed for the best seller");

		} else {

			actResult = false;

			Reports.generateReport(driver, test, Status.FAIL, "Best Seller Element is not present on the Home Page");

			System.out.println("Element not displayed");

		}
		return actResult;
	}



	public boolean verifySeachBox() {
		boolean actResult;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.searchBox));
		if (element.isDisplayed()) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "element is present in the page");
		} else {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "element is not in the page");
		}
		return actResult;
	}
}
