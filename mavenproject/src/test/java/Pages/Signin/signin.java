package Pages.Signin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.support.ui.Select;

public class signin {

	
	static String signin_title_xpath = "//*[@class='a-size-medium-plus a-spacing-small' and contains(text(),'Sign in')]";
	
	
	
	
	
	
	public static void validateSigninTitle(WebDriver driver) {
		
		WebElement element = driver.findElement(By.xpath(signin_title_xpath));
		String value = element.getText();
		if(value.equals("Sign in or create account")) {
			System.out.println("Sign in Title is  verified");
		}
		
	}
	
	
}
