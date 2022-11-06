package com.mystrore.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSummary {
	
	WebDriver ldriver;
	
	public OrderSummary(WebDriver rdriver){
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText ="Proceed to checkout")
	WebElement orderProceedCheckout;
	
	public void ProcedeToCheckout() {
		orderProceedCheckout.click();
	}
	
}
