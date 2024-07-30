package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class webdriver {
	
	static String browserType  = "webdriver.chrome.driver";
	static String browserDriver = "D:\\Selenium\\Training\\mavenproject\\src\\test\\java\\configfiles\\chromedriver.exe";
	static String URL = "https://www.amazon.in/";
	
	public static WebDriver setUp() {
		
		
		System.setProperty(browserType, browserDriver);
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		
		return driver;
		
	}
	
	

}
