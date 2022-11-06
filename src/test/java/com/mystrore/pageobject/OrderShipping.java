package com.mystrore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShipping {

	WebDriver ldriver;

	public OrderShipping(WebDriver rdriver) {
		ldriver = rdriver;

	PageFactory.initElements(rdriver, this);
	
	}

	@FindBy(id = "uniform-cgv")
	WebElement checkBox;
	
	@FindBy(name="processCarrier")
	WebElement shippingProceedCheckout;
	
	public void CheckBox() {
		checkBox.click();
	}

	public void ProcedeToCheckout() {
		shippingProceedCheckout.click();
	}
}
