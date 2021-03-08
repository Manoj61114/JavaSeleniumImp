package Selenium_Program_Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicClass {

	static String driverPath = "C:\\Users\\Name\\eclipse-workspace\\Selenium_Class\\target\\chromedriver.exe";
	static String dri = "webdriver.chrome.driver";
	static WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		System.setProperty(dri, driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.rogers.com/home");
		}
	
	@Test(priority=4)
	public void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test(priority=2)
	public void currentURL() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	
	@Test(priority=3)
	public void getText() throws InterruptedException {
		Thread.sleep(30000);
	WebElement element = 	driver.findElement(By.xpath("//span[text()='Personal']"));
	String text =  element.getText();
	System.out.println(text);
	}
	
	@Test(priority=1)
	public void click() throws InterruptedException {
		Thread.sleep(30000);
		WebElement att = driver.findElement(By.xpath("//span[text()='Sign in' and @class='m-navLink__caption']"));
		Thread.sleep(3000);
		att.click();
		WebElement username = driver.findElement(By.xpath("//input[@type='email']"));
		username.sendKeys("ILOVEYOU");
		String login = username.getAttribute("value");
		System.out.println(login);
		
	}

	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	
	
}
