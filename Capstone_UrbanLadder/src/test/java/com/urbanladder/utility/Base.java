package com.urbanladder.utility;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver = null;

	public static void getBrowser() {
		Properties prop = PropertyReader.readProperty();

		switch (prop.getProperty("Browser")) {

		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "safari":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Unknown browser found");

		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));

	}
	public static WebDriver getDriver() {

	    if (driver == null) {

	      getBrowser();

	    }

	    return driver;

	  }


}
