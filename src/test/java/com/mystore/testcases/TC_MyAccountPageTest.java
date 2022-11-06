package com.mystore.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.testcases.BaseClass;
import com.mystrore.pageobject.AccountCreationDetails;
import com.mystrore.pageobject.IndexPage;
import com.mystrore.pageobject.MyAccount;
import com.mystrore.pageobject.RegisterUserAccount;

public class TC_MyAccountPageTest extends BaseClass{
	
	@Test
	public void verifyRegisterationLogin() {
		
		logger.info("My Account Page Test Case Execution Strated........");
		
		IndexPage pg=new IndexPage(driver);
		pg.clickOnSignIn();
		logger.info("Clicked on sign-in link");
		
		MyAccount muAccpg=new MyAccount(driver);
		muAccpg.enterCreateEmailId("saurav0071@gmail.com");
		muAccpg.clickSubmitButton();
		logger.info("Clicked on submit button");
		
        AccountCreationDetails details=new AccountCreationDetails(driver);
		
		details.title();
		
		details.enterCustomerFirstName("Ankit");
		details.enterCustomerLastName("Kumar");
		details.enterCustomerPassword("Ankit123");
		details.customerBirthDate("1  ");
		details.customerBirthMonth("January ");
		details.customerBirthYear("2022  ");
		details.checkBox();
		details.enterAddFirstName("Ankit");
		details.enterAddLastName("Kumar");
		details.company("Soft Deal Technologies");
		details.enterFirstAddress("Flat no-404,Dhanbad");
		details.enterSecondAddress("Flat no-405,Delhi");
		details.enterCity("Dhanbad");
		details.enterState("Indiana");
		details.zipCode("82600");
		details.selectCountry("United States");
		details.additionalInformation("Im a Software Engineer");
		details.enterHomePhone("8250043981");
		details.enterMobilePhone("7903598708");
		details.enterFutureReference("Sourav Kumar");
		
		logger.info("Entered user details on account creation page");
		
		details.submitButton();
		logger.info("Clicked Register button");
		
		RegisterUserAccount userAccount =new RegisterUserAccount(driver);
		
		String userName=userAccount.getUserName();
		
		Assert.assertEquals("Ankit Kumar", userName);
		logger.info("UserName verified");
	}

}
