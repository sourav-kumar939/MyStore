package com.mystrore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationDetails {

	//create object of webdriver
	WebDriver ldriver;
	
	public AccountCreationDetails(WebDriver rdriver) {
		ldriver=rdriver;
		
		//This method will create web element
		PageFactory.initElements(rdriver, this);
	}
	
	//identify webelement
	@FindBy(id="id_gender1")
	WebElement title;
    
	@FindBy(id="customer_firstname")
	WebElement firstName;
	
	@FindBy(id="customer_lastname")
	WebElement lastName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	//Date of birth
	@FindBy(id="days")
	WebElement date;
	//Date of month
	@FindBy(id="months")
	WebElement month;
	//Date of year
	@FindBy(id="years")
	WebElement year;
	
	@FindBy(id="newsletter")
	WebElement checkbox;
	
	@FindBy(id="firstname")
	WebElement addFirstName;
	
	@FindBy(id="lastname")
	WebElement addLastName;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="address1")
	WebElement address_1;
	
	@FindBy(id="address2")
	WebElement address_2;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement zipCode;
	
	@FindBy(id="id_country")
	WebElement country;
	
	@FindBy(id="other")
	WebElement additionalInformation;
	
	@FindBy(id="phone")
	WebElement homePhone;
	
	@FindBy(id="phone_mobile")
	WebElement mobilePhone;
	
	@FindBy(id="alias")
	WebElement futureReference;
	
	@FindBy(id="submitAccount")
	WebElement submitButton;
	
	//action to be performed on identify element
	
	public void title() {
		title.click();;
	}
	
	public void enterCustomerFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void enterCustomerLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void enterCustomerPassword(String cpwd) {
		password.sendKeys(cpwd);
	}
	
	public void customerBirthDate(String birthDate) {
		Select select=new Select(date);
	    select.selectByVisibleText(birthDate);
		//select.selectByValue(birthDate);
	}
	
	public void customerBirthMonth(String birthMonth) {
		Select select=new Select(month);
		select.selectByVisibleText(birthMonth);
		//select.selectByValue(birthMonth);
	}
	
	public void customerBirthYear(String birthYear) {
		Select select=new Select(year);
		select.selectByVisibleText(birthYear);
		//select.selectByValue(birthYear);
	}
	
	public void checkBox() {
		checkbox.click();
	}
	
	public void enterAddFirstName(String addFName) {
		
		addFirstName.clear();
		addFirstName.sendKeys(addFName);
	}
	
	public void enterAddLastName(String addLName) {
		addLastName.clear();
		addLastName.sendKeys(addLName);
	}
	
	public void company(String cmpy) {
		company.sendKeys(cmpy);
	}
	
	public void enterFirstAddress(String firstAddress) {
		address_1.sendKeys(firstAddress);
	}
	
	public void enterSecondAddress(String secondAddress) {
		address_2.sendKeys(secondAddress);
	}
	
	public void enterCity(String City) {
		city.sendKeys(City);
	}
	
	public void enterState(String State) {
		Select select=new Select(state);
		select.selectByVisibleText(State);
	}
	
	public void zipCode(String ZipCode) {
		zipCode.sendKeys(ZipCode);
	}
	
	public void selectCountry(String Country) {
		Select select=new Select(country);
		select.selectByVisibleText(Country);
	}
	
	public void additionalInformation(String addInformation) {
		additionalInformation.sendKeys(addInformation);
	}
	
	public void enterHomePhone(String HomePhone) {
		homePhone.sendKeys(HomePhone);
	}
	
	public void enterMobilePhone(String MobilePhone) {
		mobilePhone.sendKeys(MobilePhone);
	}
	
	public void enterFutureReference(String FurureReference) {
		futureReference.clear();
		futureReference.sendKeys(FurureReference);
	}
	
	public void submitButton() {
		submitButton.click();
	}
	

}
