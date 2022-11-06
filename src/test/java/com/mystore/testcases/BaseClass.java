package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	
	public String url=readconfig.getBaseUrl();
	public String browser=readconfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	
	public static Date date=new Date();
	public static String time=date.toString().replace(" ", "-").replace(":", "-");
	
	@BeforeClass
	public void setup() {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
//		else {
//			System.out.println("Bwowser Name is invalid");
//		}
		
		//implicit wait of 10sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		logger=LogManager.getLogger("MyStore");
		
		//open url
		driver.get(url);
		logger.info("url opened");
	}
	
	@AfterClass
	public void  tearDown() {
		driver.close();
		driver.quit();
		
	}
	
	public void CaptureScreenShot(WebDriver driver,String testName) {
		
		
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./Screenshot/"+time+"-"+testName+".png"));
			System.out.println("Screenshot saved successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
//			//step1: convert webdriver object to TakesScreenshot interface
//			TakesScreenshot screenshot = ((TakesScreenshot)driver);
//			
//			//step2: call getScreenshotAs method to create image file
//			
//			File src = screenshot.getScreenshotAs(OutputType.FILE);
//			
//			File dest = new File(System.getProperty("user.dir") + "//Screenshot//" + testName + ".png");
//			System.out.println("Screenshot saved successfully");
//			//step3: copy image file to destination
//			try {
//				FileUtils.copyFile(src, dest);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
	}
	
	
}
