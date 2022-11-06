package com.mystrore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	//create object of webdriver
	
	WebDriver ldriver;
	
	//constructor
	public IndexPage(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify element
	@FindBy(linkText="Sign in")
	WebElement signIn;
	
	//identify action on webelement
	public void clickOnSignIn() {
		signIn.click();
	}
	
	public String pageTitle() {
		System.out.println("Title is----------------"+ldriver.getTitle());
		return(ldriver.getTitle());
	}
	
	
	
}
