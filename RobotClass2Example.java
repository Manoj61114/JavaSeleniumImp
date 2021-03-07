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

public class RobotClass2Example {
	static WebDriver driver;
	static String dri = "webdriver.chrome.driver";
	static String driverpath = "C:\\Users\\Name\\eclipse-workspace\\Selenium_Class\\target\\chromedriver.exe";
	
	@BeforeMethod
	public void setup() {
		System.setProperty(dri, driverpath);
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/howto/howto_html_file_upload_button.asp");
		
	}
	

	public static void fileUpload() throws AWTException, InterruptedException {
		WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("<input type=\\\"file\\\" id=\\\"myFile\\\">")));
		Actions action = new Actions(driver);
		action.moveToElement(file).click().build().perform();
		
	
	}
	@Test(priority =1)
	public void robotc() throws AWTException, InterruptedException {
		fileUpload();

		StringSelection selection = new StringSelection("D:\\Gopal Kumawat Rewasa.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(30000);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		//Thread.sleep(30000);
		driver.close();
	}
	
	
}
