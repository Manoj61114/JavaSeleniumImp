package Selenium_Program_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ATU_TestRecorder {

	ATUTestRecorder recorder;
	WebDriver  driver;
	static String driverpath = "C:\\Users\\Name\\git\\seleniumbasic\\SeleniumBasicProgram\\target\\chromedriver.exe";
	static String url = "https://www.wipro.com/contact-wipro/";
	
	@BeforeMethod
	public void setUp() throws ATUTestRecorderException {
		System.setProperty("webdriver.chrome.driver", driverpath);
		
		recorder = new ATUTestRecorder("C:\\Users\\Name\\eclipse-workspace\\Selenium_Class\\target","Video_2021", false);
		recorder.start();
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
				
	}
	
	
	
	@Test
	public void recorder() throws ATUTestRecorderException {
	
	driver.get(url);
	System.out.println("*********Program Run Sucessfully************");
		
	
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException, ATUTestRecorderException {
		Thread.sleep(3000);
		recorder.stop();
		driver.close();
		
	}
	
	
}
