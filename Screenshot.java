package Selenium_Program_Class;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Screenshot {

	WebDriver driver;
	String chromedriverpath = "C:\\\\Users\\\\Name\\\\git\\\\seleniumbasic\\\\SeleniumBasicProgram\\\\target\\\\chromedriver.exe";
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", chromedriverpath );
		driver= new ChromeDriver();
		driver.get("https://www.hcltech.com/");
		
	}
	
	
	@Test
	public void takeScreenShot() throws IOException {
		
		File srcFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		File desFile =  new File("C:\\Users\\Name\\eclipse-workspace\\Selenium_Class\\target\\ScreenshotError.png");
		FileUtils.copyFile(srcFile, desFile);
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
