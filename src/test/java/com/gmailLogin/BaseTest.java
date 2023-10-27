package com.gmailLogin;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.pages.BasePage;
import com.pages.Page;
import com.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	
	ReadConfig readconfig = new ReadConfig();


	
	public static WebDriver driver;
	public Page page;
	
	String baseGmail = readconfig.getBaseGmail();
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(@Optional("chrome") String br) throws InterruptedException
	{
//		logger = Logger.getLogger("hiristJobseeker");
//		PropertyConfigurator.configure("Log4j.properties");
		
		
		if(br.equals("chrome"))
		{		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("use-fake-ui-for-media-stream");
			ChromeOptions options2 = new ChromeOptions();
			options2.addArguments("--disable-notifications");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			
//			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranjali\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//		     driver = new ChromeDriver();
			
//			driver = webdriver.Chrome();
				
	    driver.manage().window().maximize();
	    Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		
		}
		
//		if(br.equals("firefox"))
//		{		
//		FirefoxOptions options = new FirefoxOptions();
//		options.addPreference("media.navigator.permission.disabled", true);
//		WebDriverManager.firefoxdriver().setup();
//	
//		driver = new FirefoxDriver(options);
//	    driver.manage().window().maximize();
//	    Thread.sleep(5000);
//		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
//		}
		
//		startTime = System.currentTimeMillis();

//		driver.get(stagingURL);
		driver.get(baseGmail);
		page = new BasePage(driver);
		

	}

	@AfterClass
	public void tearDown()
	{
//		System.out.println("Total time taken : "+totalTime);
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	public String randomestring()
	{
		String generatedstring =  RandomStringUtils.randomAlphabetic(10);
		return generatedstring;
	}
	
	public String randomeNum()
	{
		String generatednum =  RandomStringUtils.randomNumeric(10);
		return generatednum;
	}
	
	public void verifyDetail(String actual, String expected ,String pageName) throws IOException{
		
		if(actual.contains(expected)) 
		{	
			Assert.assertTrue(true);
			logger.info(pageName+" Verified");

		}else 
		{
			captureScreen(driver, pageName+"Test");
			logger.info(pageName+" Failed");
			
			Assert.assertTrue(false);

		}
	}
	
	public void verifyDetail(Boolean actual, Boolean expected ,String pageName) throws IOException{
		
		if(actual==(expected)) 
		{	
			Assert.assertTrue(true);
			logger.info(pageName+" Verified");

		}else 
		{
			captureScreen(driver, pageName+"Test");
			logger.info(pageName+" Failed");
			
			Assert.assertTrue(false);

		}
	}
	
	public void verifyDetail(int actual, int expected ,String pageName) throws IOException{
		
		if(actual==expected) 
		{	
			logger.info(pageName+" Verified");
			Assert.assertTrue(true);

		}else 
		{
			captureScreen(driver, pageName+"Test");
			logger.info(pageName+" Failed");
			
			Assert.assertTrue(false);

		}
	}

}
