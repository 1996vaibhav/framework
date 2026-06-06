package com.qa.callhippo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.callhippo.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {
	
	
	@BeforeClass
	public void productPageSetUp() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	/*
	 * paramaterization of test
	 * in test we are going to supply some parameter
	 * thses paramaters are coming from data provider
	 * data provider method in testNG will return 2-dimensional object array
	 * 
	 * Each row = one complete set of data
	 * Inside row = values (username, password)
	 * 
	 * 2D Object array = multiple rows of data(can have string or integer)
	 * 
	 * data provider in TestNG will always return 2D Array
	 * 
	 *  data-provider purpose 
	 *  To run the same test multiple times with different sets of data.
	 *  
	 *  Every test have it's own data
	 *  
	 */
	
	
	
	@DataProvider
	public Object[][] getProducts() {
		return new Object[][] {
			{"macbook" ,"MacBook Air"},
			{"samsung" , "Samsung SyncMaster 941BW"},
			{"imac" , "iMac"}
			
		};
	}
	
	
	@Test(dataProvider = "getProducts")
	public void doProductInfoPageTest(String searchsKey , String productsName) {
		productListingPage = accountPage.doSearch(searchsKey);
		productInfoPage = productListingPage.doSelectProduct(productsName);
		String actualHeaderValue = productInfoPage.getProductInfoPageHeaderText();
		Assert.assertEquals(actualHeaderValue, productsName);

	}
	
	
	
	@DataProvider
	public Object[][] getProductsImage() {
		return new Object[][] {
			{"macbook" ,"MacBook Air" , 4},
			{"samsung" , "Samsung SyncMaster 941BW" , 1},
			{"imac" , "iMac" , 3}
			
		};
	}
	
	@Test(dataProvider = "getProductsImage")
	public void doProductImageCount(String searchsKey , String productsName ,  int imageCount) {
		productListingPage = accountPage.doSearch(searchsKey);
		productInfoPage = productListingPage.doSelectProduct(productsName);
		int actualImage = productInfoPage.getProductImageCount();
		Assert.assertEquals(actualImage, imageCount);
		
		
		
	}
	
	
	
	
	
	
	

}
