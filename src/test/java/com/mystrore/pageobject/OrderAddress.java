package com.mystrore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAddress {

	WebDriver ldriver;

	public OrderAddress(WebDriver rdriver) {
		ldriver = rdriver;

	PageFactory.initElements(rdriver, this);
	}

	@FindBy(name="processAddress")
	WebElement addressProceedCheckout;

	public void ProcedeToCheckout() {
		addressProceedCheckout.click();
	}
}
