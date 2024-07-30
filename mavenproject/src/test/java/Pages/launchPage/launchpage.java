package Pages.launchPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class launchpage {
	
	
	// id, name, class, xpath, tagname, css selector
	String name  = "John";
	//Locators
	static String accountList_link_id = "nav-link-accountList";
	static String signin_button_id = "nav-flyout-ya-signin";
	
	
	
	public static void hoverAccountList(WebDriver driver) {
		
		WebElement element = driver.findElement(By.id(accountList_link_id));
		element.sendKeys(Keys.RETURN);
		
	}
	
	public static void clickSignin(WebDriver driver) {
		
		WebElement element = driver.findElement(By.id(signin_button_id));
		element.sendKeys(Keys.RETURN);
		
	}
	
	
}
