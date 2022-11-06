package com.mystrore.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProduct {
	
	//create object of webdriver
		WebDriver ldriver;
		
		public SearchProduct(WebDriver rdriver) {
			ldriver=rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(id="search_query_top")
		WebElement searchBox;

		@FindBy(name="submit_search")
		WebElement searchButton;
		
		@FindBy(linkText = "Faded Short Sleeve T-shirts")
		WebElement searchResultProduct;
		
		@FindBy(xpath ="//div[@class='product-image-container']")
		WebElement moreOption;
		
		@FindBy(linkText ="More")
		WebElement moreOption2;
		
		public void SearchBox(String searchKey) {
			searchBox.sendKeys(searchKey);
		}
		
		public void SearchButton() {
			searchButton.click();
		}
		
		public String SearchResult() {
			return(searchResultProduct.getText());
		}
		
		public void MoreOption(WebDriver rdriver) {
//			WebDriverWait wait=new WebDriverWait(ldriver,Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.visibilityOf(moreOption));
			Actions action=new Actions(rdriver);
			action.moveToElement(moreOption).perform();
			action.moveToElement(moreOption2).click().perform();
			
		}
		
		
}
