package com.mystrore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPayment {
	
	WebDriver ldriver;
	
	public OrderPayment(WebDriver rdriver){
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement payByCheck;
	
	public void PayByCheck() {
		payByCheck.click();
	}

}
