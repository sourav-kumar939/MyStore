package com.mystrore.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	WebDriver ldriver;
	
	public ProductPage(WebDriver rdriver){
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="(//p[@id='quantity_wanted_p']/a)[2]")
	WebElement increaseQuantity;
	
	@FindBy(id="group_1")
	WebElement sizeOfProduct;
	
	@FindBy(name="Submit")
	WebElement addToCart;
	
	@FindBy(linkText ="Proceed to checkout")
	WebElement proceedToCheckout;
	
	public void IncreaseQuatity() {
		increaseQuantity.click();
	}
	
	public void SizeOfProduct(String size) {
		Select select=new Select(sizeOfProduct);
		select.selectByVisibleText(size);
	}
	
	public void AddToCart() {
		addToCart.click();
	}
	
	public void ProcedeToCheckout() {
		WebDriverWait wait=new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
		proceedToCheckout.click();
	}
	//.visibilityOf(proceedToCheckout)
	
}
