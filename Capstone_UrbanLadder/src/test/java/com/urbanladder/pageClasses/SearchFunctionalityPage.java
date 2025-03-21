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

public class SearchFunctionalityPage {

	private WebDriver driver;

	private WebDriverWait wait;

	ExtentTest test;

	Properties properties;

	public SearchFunctionalityPage(WebDriver driver, ExtentTest test) {

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

	public boolean SearchDisp() {
		boolean actResult;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.searchBox));
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

	public boolean SearchProduct(String product) {
		boolean actResult;
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.searchBox)).sendKeys(product);

		driver.findElement(Locators.Searchbt).click();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.pd)).click();;
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.Searchbt));
		if (element.isDisplayed()) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "Searchbutton displayed");
		} else {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Searchbutton not displayed");
		}

		return actResult;

	}

	public boolean SearchPdOnNewArrivals() {
		boolean actResult;
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.sort)).click();

		driver.findElement(Locators.NewArrivals).click();
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.NewArrivals));
		if (element.isDisplayed()) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "New Arrivals filter is displayed");
		} else {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "New Arrivals not displayed");
		}

		return actResult;

	}

	public boolean SearchPdOnHightoLow() {
		boolean actResult;
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.lowtoHigh)).click();

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.Hightolow));
		if (element.isDisplayed()) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "High to lowfilter is displayed ");
		} else {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "High to low not displayed");
		}

		return actResult;

	}

	public boolean SearchPdOnLowtoHigh() {
		boolean actResult;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.NewArrivals)).click();

		driver.findElement(Locators.lowtoHigh).click();
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.Hightolow));
		if (element.isDisplayed()) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "Low to high is displayed ");
		} else {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, " low to high  not displayed");
		}

		return actResult;
	}

}