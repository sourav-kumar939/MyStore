package com.mystore.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.utilities.ReadExcelFile;
import com.mystrore.pageobject.IndexPage;
import com.mystrore.pageobject.OrderAddress;
import com.mystrore.pageobject.OrderConfirm;
import com.mystrore.pageobject.OrderConfirmMessage;
import com.mystrore.pageobject.OrderPayment;
import com.mystrore.pageobject.OrderShipping;
import com.mystrore.pageobject.OrderSummary;
import com.mystrore.pageobject.ProductPage;
import com.mystrore.pageobject.SearchProduct;
import com.mystrore.pageobject.VerifyLogin;

import junit.framework.Assert;

public class TC_04_BuyProduct extends BaseClass{
	
	@Test(dataProvider="LoginDataProvider")
	public void BuyProduct(String UserName,String Password) {
		
		logger.info("\n***************TestCase Buy Product started*****************");
		
		//Sign-in
		IndexPage indexPage=new IndexPage(driver);
		indexPage.clickOnSignIn();
		logger.info("Clicked on sign-in link");
		
        VerifyLogin verifylogin=new VerifyLogin(driver);
		
		//Entered email and password
		verifylogin.email(UserName);
		logger.info("Email Address Entered");
		
		verifylogin.password(Password);
		logger.info("Password Entered");
		
		//Clicked on submit button
		verifylogin.submitbutton();
		logger.info("Submit Button Clicked");
		
		SearchProduct searchProduct=new SearchProduct(driver);
		
		//Entering "T-shirts" in search box
		String searchKey="T-shirts";
		
		searchProduct.SearchBox(searchKey);
		logger.info("T-shirts entered in search box");
		
		//Click on search button
		searchProduct.SearchButton();
		logger.info("Searched Button Clicked");
		
		searchProduct.MoreOption(driver);
		logger.info("Clicked on More Option");
		
		ProductPage productPage=new ProductPage(driver);
		
		productPage.IncreaseQuatity();
		logger.info("Quantity increased");
		
		productPage.SizeOfProduct("M");
		logger.info("Product size is M");
		
		productPage.AddToCart();
		logger.info("Add to cart clicked");
		
		productPage.ProcedeToCheckout();
		logger.info("Proceed to checkout clicked");
		
		OrderSummary orderSummary=new OrderSummary(driver);
		
		orderSummary.ProcedeToCheckout();
		logger.info("Order summary proceed to checkout clicked");
		
		OrderAddress orderAddress=new OrderAddress(driver);
		
		orderAddress.ProcedeToCheckout();
		logger.info("Order address proceed to checkout clicked");
		
		OrderShipping orderShipment=new OrderShipping(driver);
		
		orderShipment.CheckBox();
		logger.info("Clicked on check box");
		
		orderShipment.ProcedeToCheckout();
		logger.info("Order shipping proceed to checkout clicked");
		
		OrderPayment orderPayment=new OrderPayment(driver);
		
		orderPayment.PayByCheck();
		logger.info("Order payment pay by check clicked");
		
		OrderConfirm orderConfirm=new OrderConfirm(driver);
		
		orderConfirm.IConfirmMyOrder();
		logger.info("Order confirm clicked");
		
		OrderConfirmMessage message=new OrderConfirmMessage(driver);
		
		if(message.ConfirmMessage().contains("Your order on My Store is complete.")) {
			Assert.assertTrue(true);
			logger.info("Confirmation message displayed");
			verifylogin.sign_Out();
			logger.info("Sign-out done");
		}
		else {
			logger.info("Confirmation message not displayed");
			CaptureScreenShot(driver, "BuyProduct");
			Assert.assertTrue(false);
		}
		
		logger.info("***************TestCase Buy Product ends*****************"); 
	}
		
	
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() {
		String fileName = "./TestData/MyStoreTestData.xlsx";
		String sheetName="LoginTestData";
		String[][] text =ReadExcelFile.excelData(fileName, sheetName);
		return text;
	}

}
