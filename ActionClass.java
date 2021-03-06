package Selenium_Program_Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionClass {
	static WebDriver driver;
	String chromedriverpath = "C:\\\\Users\\\\Name\\\\git\\\\seleniumbasic\\\\SeleniumBasicProgram\\\\target\\\\chromedriver.exe"; 
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", chromedriverpath);
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
				
	}
	
	@BeforeTest
	public void url() {
		driver.get("https://www.hcltech.com/");
		
	}
	
	@Test(priority=1)
	public void test() {		
		WebElement element = driver.findElement(By.xpath("//div[@class='om-link eventtracking eventcategory-HCL_"
				+ "INDUSTRY eventaction-INDUSTRY eventlabel-INDUSTRY link-INDUSTRIES']"));
		Actions action =  new Actions(driver);
		action.moveToElement(element).build().perform();
		

	}
	@Test(priority=2)
	public void getText() {
		String element_text = driver.findElement(By.linkText("Life Sciences")).getText();
		driver.findElement(By.linkText("Life Sciences")).click();
		System.out.println(element_text);
		String s = "Life Sciences";
		Assert.assertEquals(element_text, s, "Test cases is PASS");
		}
		
	@AfterTest
	public void teardown() {
			driver.close();
	}
	
	
	
}
