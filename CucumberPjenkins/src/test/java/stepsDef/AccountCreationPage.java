package stepsDef;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.Base;

public class AccountCreationPage {
	
/*
	@FindBy(how=How.XPATH,using="//a[text()='Create a new account']") WebElement createNewAccount;
	@FindBy(how=How.XPATH,using="//div[@id='wrapper']/table[2]/tbody/tr[3]/td[3]/input[@type='text']") WebElement fullName;
	@FindBy(how=How.XPATH,using="//div[@id='wrapper']/table[2]/tbody/tr[7]/td[3]/input[@type='text']") WebElement mailId;
	@FindBy(how=How.XPATH,using="//td[@valign='bottom']/input[@type='text']")WebElement checkAvailability_Mail;
	@FindBy(how=How.XPATH,using="//input[@id='newpasswd']") WebElement newPasword;
	@FindBy(how=How.XPATH,using="//input[@id='newpasswd1']") WebElement retypePasword;
	@FindBy(how=How.XPATH,using="//div[@id=\"div_altemail\"]/table/tbody/tr/td[3]/input[@type='text']") WebElement noAlternateEmail;
	@FindBy(how=How.XPATH,using="//input[@id='mobno']") WebElement mobileNo;
	@FindBy(how=How.XPATH,using="//tbody/tr[22]/td[3]/select[1]/option[@value='26']") WebElement chooseDate;
	@FindBy(how=How.XPATH,using="//tbody/tr[22]/td[3]/select[2]/option[@value='04']") WebElement chooseMonth;
	@FindBy(how=How.XPATH,using="//tbody/tr[22]/td[3]/select[3]/option[@value='2001']") WebElement chooseYear;
	@FindBy(how=How.XPATH,using="//input[@value='m']") WebElement gender;
	@FindBy(how=How.XPATH,using="//td[contains(@colspan,'3')]/child::select[contains(.,'India')]") WebElement country;
	@FindBy(how=How.XPATH,using="//td[contains(@colspan,'3')]/select/option[@label='Bangalore']") WebElement city;
	@FindBy(how=How.XPATH,using="//input[contains(@class,'captcha')]") WebElement captcha;
	@FindBy(how=How.XPATH,using="//input[@id='Register']") WebElement register;
	
	public void signIn() { 
		createNewAccount.click();
	}
	
	public void details() {
		
		fullName.sendKeys("sathya sai");
		mailId.sendKeys("sai789@gmail.com");
		checkAvailability_Mail.click();
		newPasword.sendKeys("sai890");
		retypePasword.sendKeys("sai890");
		noAlternateEmail.sendKeys("saih@gmail.com");
		mobileNo.sendKeys("7681859228");
		chooseDate.click();
		chooseMonth.click();
		chooseYear.click();
		gender.click();
		country.click();
		city.click();
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter captcha:");
		captcha.sendKeys(sc.nextLine());
		sc.close();
	}
	
	public void clickRegister() {
		register.click();
	}
*/
	//======================================================================================	

		private static WebDriver driver;
		private By createNewAccount = By.xpath("//a[text()='Create Account']");
	    private By fullName = By.xpath("//div[@id='wrapper']/table[2]/tbody/tr[3]/td[3]/input[@type='text']");
	    private By mailId = By.xpath("//div[@id='wrapper']/table[2]/tbody/tr[7]/td[3]/input[@type='text']");
	    private By checkAvailability_Mail = By.xpath("//td[@valign='bottom']/input[@type='text']");
	    private By newPassword = By.xpath("//input[@id='newpasswd']");
	    private By retypePassword = By.xpath("//input[@id='newpasswd1']");
	    private By noAlternateEmail = By.xpath("//div[@id=\"div_altemail\"]/table/tbody/tr/td[3]/input[@type='text']");
	    private By mobileNo = By.xpath("//input[@id='mobno']");
	    private By chooseDate = By.xpath("//tbody/tr[22]/td[3]/select[1]/option[@value='26']");
	    private By chooseMonth = By.xpath("//tbody/tr[22]/td[3]/select[2]/option[@value='04']");
	    private By chooseYear = By.xpath("//tbody/tr[22]/td[3]/select[3]/option[@value='2001']");
	    private By gender = By.xpath("//input[@value='m']");
	    private By country = By.xpath("//td[contains(@colspan,'3')]/child::select[contains(.,'India')]");
	    private By city = By.xpath("//td[contains(@colspan,'3')]/select/option[@label='Bangalore']");
	    private By captcha = By.xpath("//input[contains(@class,'captcha')]");
	    private By register = By.xpath("//input[@id='Register']");

	    
	    public AccountCreationPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void signIn() {
	        driver.findElement(createNewAccount).click();
	    }

	    public void details() {
	        driver.findElement(fullName).sendKeys("Akshaya Kumar Dhal");
	        driver.findElement(mailId).sendKeys("akshayakumar941@gmail.com");
	        driver.findElement(checkAvailability_Mail).click();
	        driver.findElement(newPassword).sendKeys("1234Aksh");
	        driver.findElement(retypePassword).sendKeys("1234Aksh");
	        driver.findElement(noAlternateEmail).sendKeys("aksh@gmail.com");
	        driver.findElement(mobileNo).sendKeys("7681859228");
	        driver.findElement(chooseDate).click();
	        driver.findElement(chooseMonth).click();
	        driver.findElement(chooseYear).click();
	        driver.findElement(gender).click();
	        driver.findElement(country).click();
	        driver.findElement(city).click();

//	        Scanner sc = new Scanner(System.in);
//	        System.out.print("Enter captcha:");
//	        driver.findElement(captcha).sendKeys(sc.nextLine());
//	        sc.close();
	        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	        try {
	            System.in.read(); // Wait for user input
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public void clickRegister() {
	        driver.findElement(register).click();
	    }
	
}
