package com.mystore.testcases;

import org.testng.annotations.Test;

import com.mystore.utilities.ReadConfig;
import com.mystrore.pageobject.IndexPage;
import com.mystrore.pageobject.VerifyLogin;

import junit.framework.Assert;

public class TC_02_VerifyLogin extends BaseClass{

	@Test
	public void verifyLogin() {
		
		logger.info("Verify Login Test Case Execution Strated........");
		
		IndexPage pg=new IndexPage(driver);
		pg.clickOnSignIn();
		logger.info("Clicked on sign-in link");
		
		ReadConfig readconfig=new ReadConfig();
		
		String userName=readconfig.getUserName();
		String password=readconfig.getPassword();
		
		VerifyLogin verifylogin=new VerifyLogin(driver);
		
		verifylogin.email(userName);
		logger.info("Email Address Entered");
		
		verifylogin.password(password);
		logger.info("Password Entered");
		
		verifylogin.submitbutton();
		
		logger.info("Submit Button Clicked");
		
		String verifyUserName=verifylogin.verifyUser();
		if(verifyUserName.equals("Ankit Kumar")) {
			logger.info("Verif loging : Passed");
			Assert.assertTrue(true);
			verifylogin.sign_Out();
			logger.info("Sign-out done");
		}
		else {
			logger.info("Verif loging : Failed");
			CaptureScreenShot(driver, "verifyLogin");
			Assert.assertTrue(false);
		}
		
		logger.info("***************TestCase Verify Login ends*****************"); 
	}
	
	
}
