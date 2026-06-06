package com.qa.callhippo.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.callhippo.base.BaseTest;

public class AccountPageTest extends BaseTest {


	//		never returns anything — all its methods are void in nature!
	//		create object of AccountsPage class

	@BeforeClass
	public void accPageSetUp() {
//		doLogin method returning the AccountPage object 
//		so store it inside the AccountPage reference i.e. accountPage
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accountPage.isLogoutLinkExist());
		
	}
	
	
	


}
