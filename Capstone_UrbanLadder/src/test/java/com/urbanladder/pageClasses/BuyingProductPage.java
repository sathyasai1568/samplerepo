package com.urbanladder.pageClasses;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.urbanladder.objectLocators.Locators;
import com.urbanladder.utility.PropertyReader;
import com.urbanladder.utility.Reports;

public class BuyingProductPage {
	private WebDriver driver;
	WebElement element;
	private WebDriverWait wait;

	ExtentTest test;

	Properties properties;

	public BuyingProductPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
		this.properties = PropertyReader.readProperty();
	}

	public void ClickingQty() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.ClickingonQTY));
		element.click();
	}

	public void UpdateQty() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Select dropdown=new Select(driver.findElement(Locators.ClickingonQTY));
		dropdown.selectByVisibleText("3");
	}

	public void ClickCheckout() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.CheckoutBtn));
		element.click();
	}

	public void EnterDetails(String pincode, String address, String firstname, String lastname, String mobile) {

		driver.findElement(Locators.pincode).clear();
		driver.findElement(Locators.pincode).sendKeys(pincode);
		driver.findElement(Locators.Address).clear();
		driver.findElement(Locators.Address).sendKeys(address);
		driver.findElement(Locators.firstName).clear();
		driver.findElement(Locators.firstName).sendKeys(firstname);
		driver.findElement(Locators.LastName).clear();
		driver.findElement(Locators.LastName).sendKeys(lastname);
		driver.findElement(Locators.mobileNo).clear();
		driver.findElement(Locators.mobileNo).sendKeys(mobile);
	}

	public void clickSandContBt() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.saveContiBt));
		element.click();
	}

	public void ClickPlaceOrder() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.PlaceOrder));
		element.click();
	}
	
	public boolean verifyPayment() {
		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((Locators.validatePayment)));
			WebElement element = driver.findElement(Locators.validatePayment);

			Reports.generateReport(driver, test, Status.PASS, "Product Purchased succesfull");

			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Product not purchased succesfully");

			actResult = false;

		}
		return actResult;

	}
}
