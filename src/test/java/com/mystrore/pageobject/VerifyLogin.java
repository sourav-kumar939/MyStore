package com.mystrore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyLogin {
	
	//create object of webdriver
	
	WebDriver ldriver;
	
	//constructor
	public VerifyLogin(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify element
	@FindBy(id="email")
	WebElement registeredUserEmailAddress;
	
	@FindBy(id="passwd")
	WebElement registeredUserPasswordAddress;
	
	@FindBy(id="SubmitLogin")
	WebElement submitButton;
	
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement userName;
	
	@FindBy(linkText ="Sign out")
	WebElement signOut;
	
	public void email(String username) {
		registeredUserEmailAddress.sendKeys(username);
	}
	
	public void password(String pass) {
		registeredUserPasswordAddress.sendKeys(pass);
	}
	
	public void submitbutton() {
		submitButton.click();
	}
	
	public String verifyUser() {
		String text = userName.getText();
		return text;
	}
	
	public void sign_Out() {
		signOut.click();
	}

}
