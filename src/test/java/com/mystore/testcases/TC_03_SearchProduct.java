package com.mystore.testcases;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import com.mystore.utilities.ReadExcelFile;
import com.mystrore.pageobject.IndexPage;
import com.mystrore.pageobject.SearchProduct;
import com.mystrore.pageobject.VerifyLogin;

import junit.framework.Assert;

public class TC_03_SearchProduct extends BaseClass{

	
	
	
	@Test(dataProvider="LoginDataProvider")
	public void searchProduct(String UserName,String Password) {
		
		logger.info("Verify Login Test Case Execution Strated........");
		
		IndexPage pg=new IndexPage(driver);
		
		//Sign-in
		pg.clickOnSignIn();
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
		
		//Click on search button
		searchProduct.SearchButton();
		
		//Verifying search key
		//String resultOfSearchBox=searchProduct.SearchResult();
		
		if(searchProduct.SearchResult().contains(searchKey)) {
			logger.info("Search Product Testcase : Passed");
			Assert.assertTrue(true);
			verifylogin.sign_Out();
			logger.info("Sign-Out Done");
		}
		else {
			logger.info("Search Product Testcase : Failed");
			CaptureScreenShot(driver, "searchProduct");
			Assert.assertTrue(false);
		}
		
		logger.info("***************TestCase Search Product ends*****************"); 
		
	}
	
	
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() {
		String fileName = "./TestData/MyStoreTestData.xlsx";
		String sheetName="LoginTestData";
		String[][] text =ReadExcelFile.excelData(fileName, sheetName);
		return text;
	}
	
	
	
	
	
	
	
	
//	@DataProvider(name = "LoginDataProvider")
//	public String[][] LoginDataProvider()
//	{
//		//System.out.println(System.getProperty("user.dir"));
//		String fileName = "./TestData/MyStoreTestData.xlsx";
//
//
//		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
//		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
//	
//
//		String data[][]=new String[ttlRows-1][ttlColumns];
//
//		for(int i=1;i<ttlRows;i++)//rows =1,2
//		{
//			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
//			{
//
//				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
//			}
//
//		}
//		return data;
//	}
	
	
}
