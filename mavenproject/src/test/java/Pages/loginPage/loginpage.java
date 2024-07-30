package Pages.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//***** PAGES IMPORTS ************************
import Pages.Signin.signin;



public class loginpage {
	
	//Locators
	static String signin_textbox_id = "ap_email_login";
	static String continue_button_id = "continue";
	static String email_textbox_xpath = "//*[@type='email' and @aria-required='true']";
	static String signin_text_xpath = "//*[@class='a-spacing-small' and contains(text(),'Sign in')]";
	static String password_text_xpath = "//*[starts-with(@autocomplete,'new-password')]//parent::div";
	static String allcategory_dropdown_xpath = "//*[@id='searchDropdownBox']";
	static String accountsList_dropdown_xpath = "//a[contains(@id,'nav-link-accountList')]";
	static String producT_link_xpath = "//span[@class='a-declarative']//span[@class='a-size-base-plus a-color-base a-text-normal']";
	static String sigin_link_xpath = "//*[@id='nav-flyout-ya-signin']//*[@class='nav-action-inner' and text()='Sign in']";
	static String starthere_link_xpath = "//*[@id='nav-flyout-ya-signin']//*[text()='Start here.']";

//	"//*[@class='a-row a-spacing-base']//following-sibling::input[contains(@id,'password')]"
	
	// //*[text()='Sign in']
	// contains, starts-with, ancestors, parent, following-sibling
	
//	//*[@class='a-row a-spacing-base']//*[@type='email' and @aria-required='true']
	//*[@class='a-row a-spacing-base']/*[@type='email' and @aria-required='true']
	
	
	
//	//*[@type='email']//parent::*//*[@id='auth-email-missing-alert']
	
//	implicit wait, explicit wait and thread.sleep
	
	public static void implicitwait(WebDriver driver, int Seconds) {
		
		driver.manage().timeouts().implicitlyWait(Seconds, TimeUnit.SECONDS);
		
	}
	
	public static void ExplicitWait(WebDriver driver, int Seconds, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(Seconds, driver); 
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void enterEmail(WebDriver driver, String emailorMobileNumber) {
		
		WebElement element = driver.findElement(By.xpath(email_textbox_xpath));
		element.sendKeys(emailorMobileNumber);
	}
	
	public static void enterEmail(WebDriver driver) {
		
		WebElement element = driver.findElement(By.id(continue_button_id));
		element.sendKeys(Keys.RETURN);
	}
	
	public static void xselect(WebDriver driver) {
		
		WebElement SelectElement = driver.findElement(By.xpath(allcategory_dropdown_xpath));
		
			
		Select options = new Select(SelectElement);
		options.selectByValue("search-alias=nowstore");
	}
	
	public static void hoverAccountList(WebDriver driver) {
		
		Actions act = new Actions(driver);
		
		WebElement accountListElement  = driver.findElement(By.xpath(accountsList_dropdown_xpath));
		
		act.moveToElement(accountListElement).perform();
		
	}
	
	public static void clickStartHere(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(starthere_link_xpath));
		element.sendKeys(Keys.RETURN);
		
	}
	
	public static void clickonProduct(WebDriver driver) {
	
	
		WebElement element = driver.findElement(By.xpath(producT_link_xpath));
		
		String value = element.getText();
		
		if(value.equals("Hanes Men's T-Shirt, Beefy-T Heavyweight Cotton Crewneck Tee, 1 or 2 Pack, Available in Tall Sizes")) {
			
			element.sendKeys(Keys.RETURN);
		}
	
	
	}
	
	
	
	//********************* VERIFICATION METHODS ********************************************
	public static void verifyAccountListOption(WebDriver driver) {
		
		WebElement element = driver.findElement(By.xpath(accountsList_dropdown_xpath));
		ExplicitWait(driver, 20, element);
		if(element.isDisplayed()) {
			System.out.println("Account List option is shown");
		}
		
	}
	
	public static void verfiySigninOption(WebDriver driver) {
		
		hoverAccountList(driver);
		WebElement element = driver.findElement(By.xpath(sigin_link_xpath));
		if(element.isDisplayed()) {
			System.out.println("Sign In option is shown");
		}
	}
	
	public static void verfiySigninPage(WebDriver driver) {
		
		hoverAccountList(driver);
		clickStartHere(driver);
		Thread.sleep(25);
		implicitwait(driver, 20);
		signin.validateSigninTitle(driver);
	}
	
	
	
	
	//************************ TEST CASE METHODS ******************************
	public static void forTC01Combination(WebDriver driver) {
		
		verifyAccountListOption(driver);
		
		verfiySigninOption(driver);
		verfiySigninPage(driver);
	}
	
	public static void handlealert(WebDriver driver) {
		
		
		
		String text = driver.switchTo().alert().getText();
		if(text.equals("I am an alert box!")) {
			driver.switchTo().alert().accept();
		}
	}
	
}
