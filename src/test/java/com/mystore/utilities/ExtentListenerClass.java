package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mystore.testcases.BaseClass;

public class ExtentListenerClass extends BaseClass implements ITestListener{
	
	public ExtentSparkReporter  htmlReporter;
	public ExtentReports reports;
	public ExtentTest test; 
	
	public void setExtentReport() {
		
		ReadConfig readConfig = new ReadConfig();
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date()); // this is done to just add time in html report
		String reportName = "MyStoreTestReport-" + timestamp + ".html";                    // this is done to just add time in html report
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReport/"+reportName);// this is done to set the path of Extent Report
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machine:", "testpc1");
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("browser:", readConfig.getBrowser());
		reports.setSystemInfo("user name:", "Prachi");
		
		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	
	

	public void onStart(ITestContext context) {
		setExtentReport();
		System.out.println("On Start method invoked....");
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("On Finished method invoked....");  	
		reports.flush();//it is mandatory to call flush method to ensure information is written to the started reporter.
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method failed:" + result.getName() );  		
		test = reports.createTest(result.getName());//create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + result.getName() ,ExtentColor.RED));
		
		CaptureScreenShot(driver, result.getName());
		
		//String screenShotPath=System.getProperty("user.dir") + "/Screenshot/"+ ".png";
		String screenShotPath = System.getProperty("user.dir") + "\\Screenshot\\"+time+"-" + result.getName() + ".png";
		
		File screenShotFile = new File(screenShotPath);
		
		if(screenShotFile.exists()) {
			
			test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of test method skipped:" + result.getName() );  		

		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + result.getName() ,ExtentColor.YELLOW));
	}
	
	public void onTestStart(ITestResult result)					
	{		
	   System.out.println("Name of test method started:" + result.getName() );  		
    }
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test method sucessfully executed:" + result.getName() );  		

		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + result.getName() ,ExtentColor.GREEN));
	}

	

	

	
	

	

	
	
}
