package Selenium_Program_Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectClass {
	static WebDriver driver;
	static String driverpath = "C:\\Users\\Name\\git\\seleniumbasic\\SeleniumBasicProgram\\target\\chromedriver.exe";
	static String url = "https://www.wipro.com/contact-wipro/";
	
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",driverpath);
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	
	@BeforeMethod
	public void country()  {
		WebElement countryName = driver.findElement(By.xpath("//select[@id='Country__c']")); 
		Select select = new Select(countryName);
		select.selectByVisibleText("India");
		System.out.println("********Before Method executed sucessfully********");
		
	}
	
	@Test(priority =1)
	public void contactusfirstName() {
		WebElement firstName = driver.findElement(By.xpath("//*[@id='FirstName']"));
		firstName.clear();
		firstName.sendKeys("Priyanshu");
	}
	
	@Test(priority =2)
	public void contactuslastName() {
		WebElement lastName = driver.findElement(By.xpath("//*[@id='LastName']"));
		lastName.clear();
		lastName.sendKeys("Kumawat");
	}
	
	@Test(priority =3)
	public void contactusPhone() {
		WebElement lastName = driver.findElement(By.xpath("//*[@id='Phone']"));
		lastName.clear();
		lastName.sendKeys("9148906421");
	}
		
	
	@Test(priority =4)
	public void contactusInquiryType() throws InterruptedException {
		WebElement InquiryType = driver.findElement(By.xpath("//*[@id='Select_Inquiry_Type__c']"));
		Select select = new Select(InquiryType);
		select.selectByVisibleText("Other");
		Thread.sleep(30000);
		select.selectByIndex(1);
		Thread.sleep(30000);
		select.selectByValue("Investor Relations");

		
	}
		
	@Test(priority =5)
	public void click() {
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println(submitButton.getText());
		submitButton.submit();
		System.out.println("********Submit Method executed sucessfully********");

	}
	@AfterMethod
	public void checkMethod() {
		System.out.println("********After Method executed sucessfully********");
	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		System.out.println("Closing the browser");
		Thread.sleep(3000);
		driver.close();
		
	}
	
}
