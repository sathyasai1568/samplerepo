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

public class ProductDetailsPage {
	private WebDriver driver;
	WebElement element;
	private WebDriverWait wait;

	ExtentTest test;

	Properties properties;

	public ProductDetailsPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
		this.properties = PropertyReader.readProperty();
	}

	public void clicking() {
		// boolean actResult;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.Product));
		element.click();

//		if (element.isDisplayed()) {
//			actResult = true;
//			Reports.generateReport(driver, test, Status.PASS, "Urbanladder is launched Successful");
//			// System.out.println("element displayeed");
//		} else {
//			actResult = false;
//			Reports.generateReport(driver, test, Status.FAIL, "Urbanladder is failed to Launch");
//			// System.out.println("Element not displayed");
//		}
//		return actResult;

	}

	public boolean verifyTitle() {
		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((Locators.producttitle)));
			WebElement element = driver.findElement(Locators.producttitle);

			Reports.generateReport(driver, test, Status.PASS, "Product Title is there");

			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Product Title is not there");

			actResult = false;

		}
		return actResult;

	}

	public boolean verifyProductDetails() {
		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((Locators.Productdt)));
			element = driver.findElement(Locators.Productdt);

			Reports.generateReport(driver, test, Status.PASS, "ProductDetails are  there");

			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Product Details are not there");

			actResult = false;

		}
		return actResult;

	}

	public boolean verifyProuductPrice() {
		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((Locators.MRP)));
			element = driver.findElement(Locators.MRP);

			Reports.generateReport(driver, test, Status.PASS, "ProductDetails are  there");

			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Product Details are not there");

			actResult = false;

		}
		return actResult;

	}

	public void addToWishlist() {

		wait.until(ExpectedConditions.visibilityOfElementLocated((Locators.wishlist)));
		element = driver.findElement(Locators.wishlist);
		element.click();

	}

	public boolean addToWishlistValid() {
		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((Locators.wislistValidation)));
			element = driver.findElement(Locators.wislistValidation);
			Reports.generateReport(driver, test, Status.PASS, "wishlist are  there");
			actResult = true;
		} catch (Exception te) {
			Reports.generateReport(driver, test, Status.FAIL, "Wishlist are not there");
			actResult = false;
		}
		return actResult;

	}

	public void AddedToCart() {

		wait.until(ExpectedConditions.visibilityOfElementLocated((Locators.AddtoCart)));
		element = driver.findElement(Locators.AddtoCart);
		element.click();

	}

	public boolean CartValidate() {
		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((Locators.CartValidate)));
			element = driver.findElement(Locators.CartValidate);
			Reports.generateReport(driver, test, Status.PASS, "cart validated");
			actResult = true;
		} catch (Exception te) {
			Reports.generateReport(driver, test, Status.FAIL, "not added to cart are not there");
			actResult = false;
		}
		return actResult;

	}
	public boolean Removeproduct() {
		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((Locators.removePd)));
			element = driver.findElement(Locators.removePd);
			element.click();
			Reports.generateReport(driver, test, Status.PASS, "Product removed");
			actResult = true;
		} catch (Exception te) {
			Reports.generateReport(driver, test, Status.FAIL, "Product not removed");
			actResult = false;
		}
		return actResult;

	}
}