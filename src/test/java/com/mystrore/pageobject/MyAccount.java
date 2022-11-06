package com.mystrore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

	//create object of webdriver
	
		WebDriver ldriver;
		
		//constructor
		public MyAccount(WebDriver rdriver) {
			ldriver=rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
		
		//identify element
		@FindBy(id="email_create")
		WebElement createEmailId;
		
		@FindBy(id="SubmitCreate")
		WebElement submitButton;
		
		//identify action on webelement
		public void enterCreateEmailId(String email) {
			createEmailId.sendKeys(email);
		}
		
		public void clickSubmitButton() {
			submitButton.click();
		}
}
