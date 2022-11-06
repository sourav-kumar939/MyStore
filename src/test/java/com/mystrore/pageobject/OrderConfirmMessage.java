package com.mystrore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmMessage {
	
	WebDriver ldriver;
	
	public OrderConfirmMessage(WebDriver rdriver){
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//p[text()='Your order on My Store is complete.']")
	WebElement confirmMessage;
	
	public String ConfirmMessage() {
		return(confirmMessage.getText());
	}
	
	
}
