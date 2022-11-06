package com.mystrore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterUserAccount {

	// create object of webdriver
	WebDriver ldriver;

	public RegisterUserAccount(WebDriver rdriver) {
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement userName;

	public String getUserName() {
		String text = userName.getText();
		return text;
	}
}
