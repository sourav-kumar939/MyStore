package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.utilities.ReadExcelFile;
import com.mystrore.pageobject.IndexPage;
import com.mystrore.pageobject.VerifyLogin;

public class TC_05_LogOut extends BaseClass{
	
	@Test(dataProvider="LoginDataProvider")
	public void LogOut(String UserName,String Password) {
		
        logger.info("\n***************TestCase Log Out started*****************");
		
		//Sign-in
		IndexPage indexPage=new IndexPage(driver);
		indexPage.clickOnSignIn();
		logger.info("Clicked on sign-in link");
		
        VerifyLogin verifylogin=new VerifyLogin(driver);
		
		//Entered email and password
		verifylogin.email(UserName);
		logger.info("Email Address Entered");
		
		verifylogin.password(Password);
		logger.info("Password Entered");
		
		//Clicked on submit button
		verifylogin.submitbutton();
		logger.info("Submit Button Clicked");
		
		//Sign-out
		verifylogin.sign_Out();
		logger.info("Sign-out done");
		
		if(indexPage.pageTitle().equals("Login - My Store")) {
			logger.info("Title matched");
			Assert.assertTrue(true);
		}
		else {
			logger.info("Title miss matched");
			Assert.assertTrue(false);
		}
		
		logger.info("***************TestCase Log Out ends*****************"); 
	}
	
	
	
	
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() {
		String fileName = "./TestData/MyStoreTestData.xlsx";
		String sheetName="LoginTestData";
		String[][] text =ReadExcelFile.excelData(fileName, sheetName);
		return text;
	}

}
