package stepsDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utility.Base;

public class Steps extends Base{
	private static WebDriver driver;
	private static AccountCreationPage page;

/*	public Steps() {
		this.driver=Base.driver;
		page=PageFactory.initElements(driver, AccountCreationPage.class);
	}
	@Given("I navigated to {string} website")
	public void i_navigated_to_website(String string) {
	    driver.get(string);
	}

	@And("I clicked on create new account")
	public void i_clicked_on_create_new_account() {
	    page.signIn();
	}

	@And("I enter the details")
	public void i_enter_the_details() {
	   page.details();
	}

	@Then("I clicked on Create_My_Account")
	public void i_clicked_on_create_my_account() {
	   page.clickRegister();
	}
	
*/
//======================================================================================
	//comment lines of codes are for POM frsm 
	
	public Steps() {
        this.driver = Base.driver;
        page = new AccountCreationPage(driver);
    }

    @Given("I navigated to {string} website")
    public void i_navigated_to_website(String string) {
        //driver.get(string);
    	driver.get(string);
    }

    @And("I clicked on create new account")
    public void i_clicked_on_create_new_account() {
        page.signIn();
    }

    @And("I enter the details")
    public void i_enter_the_details() {
        page.details();
    }

    @Then("I clicked on Create_My_Account")
    public void i_clicked_on_create_my_account() {
        page.clickRegister();
    }

}
