package com.mystrore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirm {
	
	WebDriver ldriver;
	
	public OrderConfirm(WebDriver rdriver){
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement iConfirmOrder;
	
	public void IConfirmMyOrder() {
		iConfirmOrder.click();
	}

}
