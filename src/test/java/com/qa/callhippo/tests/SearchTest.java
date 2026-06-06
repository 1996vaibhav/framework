package com.qa.callhippo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.callhippo.base.BaseTest;

public class SearchTest extends BaseTest{


	@BeforeClass
	public void doSetupForAccountsPage() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));


		/*
		 * @BeforeClass should have only ONE object call
		 * That ONE call should be Login only
		 * Everything else should go inside @Test methods
		 */

	}

	@Test
	public void doSelectProductTest() {
		productListingPage = accountPage.doSearch("macbook");
		productInfoPage = productListingPage.doSelectProduct("MacBook Air");
		String actualHeaderValue = productInfoPage.getProductInfoPageHeaderText();
		Assert.assertEquals(actualHeaderValue, "MacBook Air");

	}
	
	
	
//	@Test
//	public void getSearchResultCountTest() {
//		productListingPage = accountPage.doSearch("macbook");
//		int actual = productListingPage.getSearchResultCount();
//		Assert.assertEquals(actual,3 );
//	}
//
//
//
//	@Test
//	public void searchsubcategoryExistTest() {
//		productListingPage = accountPage.doSearch("macbook");
//		Assert.assertTrue(productListingPage.searchsubcategoryExist());
//
//	}

}
