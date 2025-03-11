package hooks;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.Base;

public class Hook extends Base{
	private static Base base;
	
	@Before
	public void initSetup() {
		System.out.println("Web Browser opening: Chrome");
		base.driver= new ChromeDriver();
	}
	
	@After
	public void teardown() {
		System.out.println("Application closing...");
		base.driver.quit();
	}
}
