package Selenium_Program_Class;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RobotClass {

	
	WebDriver  driver;
	String dri = "webdriver.chrome.driver";
	static String driverpath = "C:\\Users\\Name\\git\\seleniumbasic\\SeleniumBasicProgram\\target\\chromedriver.exe";
	@BeforeMethod
	public void setUp() {
		System.setProperty(dri, driverpath);
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://files.fm/");
		
	}
	
	@Test
	public void robot() throws InterruptedException, AWTException {
		//Thread.sleep(30000);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		Actions action =  new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//input[@type='file' and @id='file_upload']"));
		action.moveToElement(ele).click().build().perform();
		
		String path = "D:\\Ganesh.pdf";
		StringSelection selection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(30000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	
}
