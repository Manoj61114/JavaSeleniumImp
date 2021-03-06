package Selenium_Program_Class;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class RobotClass {

	
	WebDriver  driver;
	String dri = "webdriver.chrome.driver";
	static String driverpath = "C:\\Users\\Name\\git\\seleniumbasic\\SeleniumBasicProgram\\target\\chromedriver.exe";
	@BeforeTest
	public void setUp() {
		System.setProperty(dri, driverpath);
		
		
		
		
	}
	
	
}
