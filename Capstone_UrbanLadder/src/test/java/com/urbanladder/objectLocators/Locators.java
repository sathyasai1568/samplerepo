package com.urbanladder.objectLocators;

import org.openqa.selenium.By;

public class Locators {
// locator on main page 
	public static By profile = By.id("header-icon-profile");
	public static By success = By.xpath("//div[contains(text(),'Account updated')]");
	public static By message = By.xpath("//div[@id='existing-customer']//div//div[1]");

	// Locator for signup page
	public static By profileIcon = By.xpath(
			"//header[@id='header']//div//div//section[3]//ul//li[2]//span[@class='header-icon-link user-profile-icon']");
	public static By signUp = By.id("header-icon-signup");
	public static By userName = By.id("spree_user_email");
	public static By password = By.xpath("//div[@class='password-wraps']//input[2]");
	public static By signupButton = By.xpath("//input[@value='Sign Up']");
	public static By successMessage = By.xpath("//div[contains(text(),'Account updated')]");

	// Locator for login page
	public By emailFieldatLoginfield = By
			.xpath("(//div[@id='password-credentials']//input[@placeholder='Email Address'])[1]");
	public By passwordFieldatloginfield = By.xpath("(//form[@id='login_form']//input[@id='spree_user_password'])[1]");
	public static By loginProfile = By.id("header-icon-login");
	public static By logIn = By.id("ul_site_login");
	public static By Login_Failure_Message = By
			.xpath("//div[text()='The email or password you entered is incorrect. Please try again.']");

	// Locator for changing password
	public static By inputName = By.id("user_name");
	public static By inputMobile = By.id("user_mobile");
	public static By Edit = By.id("edit");
	public static By changePass = By.id("change_password");
	public static By NewPass = By.id("user_password");
	public static By Cnfpass = By.id("user_password_confirmation");
	public static By updateButton = By.xpath("//div[@class='text-center']//input[@class='button primary']");

	// WebElements in the HomePage
	public static By homePageElement = By.cssSelector("figure.header__topBar_logo");
	public static By discount = By.xpath("//div[contains(text(), 'Enjoy up to ')]");
	public static By bestSeller = By.xpath("//h2[text()=\"Our Bestsellers, Handpicked Just for You\"]");

	// Webelements for search functionality
	public static By searchBox = By.id("search");
	public static By Searchbt = By.id("search_button");
	public static By pd = By.className("product-title-block");

	// webElemnets for filtering
	public static By sort = By.xpath("//div[@class='gname']//span[text()='Recommended']");
	public static By NewArrivals = By.xpath("//ul//li[text()='New Arrivals']");
	public static By Hightolow = By.xpath("//li[@class='option' and @data-key='new_arrival']");
	public static By lowtoHigh = By.xpath("//ul//li[text()='Price: Low to High']");
	public static By ubHb = By.xpath("//figure[@class='header__topBar_logo']");

	// webelements for productdetails
	public static By Product = By.xpath("//a[@data-id=\"239929\"]//span[@class=\"name\"]");
	public static By producttitle = By.xpath("//h1[@class=\"page-heading product-title no-margin\"]");
	public static By Productdt = By.xpath("//span[@class=\"product-property-title with-stroke\"]");
	public static By MRP = By.xpath("//div[@class=\"column middle\"]//div[@class=\"mrp\"]");
	public static By wishlist = By.xpath("//span[@data-vid=\"239929\"]");
	public static By wislistValidation = By.xpath("//span[text()='1']");
	public static By AddtoCart = By.xpath("//button[@class='button full']");
	public static By CartValidate = By.xpath("//div[@class='large-4 columns btn_wrap']//button[@id='checkout-link']");
	public static By removePd = By.xpath("//div[@class=\"cart-item-delete\"]//div[@class=\"icofont-cross_thin\"]");

	// WebElemetns for buyingProduct
	public static By ClickingonQTY = By.xpath("//select[@id='select_0_quantity']");
	// public static By ChangeQty=By.xpath("//input[@value='3']");
	public static By CheckoutBtn = By.xpath("//div[@class='large-4 columns btn_wrap']//button[@id='checkout-link']");
	// details in address page
	public static By pincode = By
			.xpath("//li[@id='szipcode']//div[@class='col-md-8']//input[@class='required validpincode valid']");
	public static By Address = By.xpath("//textarea[@id='order_ship_address_attributes_address1']");
	public static By firstName = By.xpath("//input[@id='order_ship_address_attributes_firstname']");
	public static By LastName = By.xpath("//input[@id=\"order_ship_address_attributes_lastname\"]");
	public static By mobileNo = By.xpath("//input[@id=\"order_ship_address_attributes_phone\"]");
	public static By saveContiBt = By.xpath("//input[@value=\"Save and Continue\"]");
	public static By PlaceOrder = By.xpath("//input[@value='Place Order']");
	public static By validatePayment = By.xpath("//body[@class=\"one-col ul_desktop body_checkout\"]");
}
