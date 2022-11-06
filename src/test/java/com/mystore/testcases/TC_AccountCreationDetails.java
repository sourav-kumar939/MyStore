package com.mystore.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.mystrore.pageobject.AccountCreationDetails;

public class TC_AccountCreationDetails extends BaseClass{

	@Test
	public void accountDetails() {
		
		
		AccountCreationDetails details=new AccountCreationDetails(driver);
		
		details.title();
		
		details.enterCustomerFirstName("Ankit");
		details.enterCustomerLastName("Kumar");
		details.enterCustomerPassword("Ankit123");
		details.customerBirthDate("10");
		details.customerBirthMonth("August");
		details.customerBirthYear("1994");
		details.checkBox();
		details.enterAddFirstName("Ankit");
		details.enterAddLastName("Kumar");
		details.company("Soft Deal Technologies");
		details.enterFirstAddress("Flat no-404,Dhanbad");
		details.enterSecondAddress("Flat no-405,Delhi");
		details.enterCity("Dhanbad");
		details.enterState("Indiana");
		details.zipCode("826001");
		details.selectCountry("United States");
		details.additionalInformation("Im a Software Engineer");
		details.enterHomePhone("8250043981");
		details.enterMobilePhone("7903598708");
		details.enterFutureReference("Sourav Kumar");
		details.submitButton();
		
	}
	
	
}
