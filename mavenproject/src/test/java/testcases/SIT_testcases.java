package testcases;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import drivers.webdriver;
import Pages.loginPage.loginpage;

public class SIT_testcases {

	static WebDriver driver;
	
	@BeforeClass
	public static WebDriver initialize() {
		driver = webdriver.setUp();
		
		return driver;
	}
	
	@Test(priority=1)
	public static void TC01() {
		
		loginpage.forTC01Combination(driver);
	}
	
	
	
}
