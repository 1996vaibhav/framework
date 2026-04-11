package com.qa.callhippo.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// No need to create driver here
// BaseTest already did that!


import com.qa.callhippo.base.BaseTest;

public class LoginPageTest extends BaseTest{
	
	
//	LoginPageTest never returns anything — all its methods are void!
//	Every test class will not be executing directly first it will go to base test and will execute first BeForeTest
//	@BeforeTest ->@BeforeMethod ->@Test
	
	
	


	@Test
	public void LoginPageTitleTest() {
		String actTitle = loginPage.getTitle();
		Assert.assertEquals(actTitle, "Account Login");
		
	}
	@Test
	public void LoginPageUrlTest() {
		String actUrl = loginPage.loginPageUrl();
		Assert.assertTrue(actUrl.contains("route=account/login"));
		
	}
	@Test
	public void aisSignInButtonExistTest() {
		Assert.assertTrue(loginPage.isSignInButtonExist());
	}
	
	
	@Test
	public void aisForgottenPasswordLink() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][]{
			
			{"avi@google.com" , "Test@123"}

			
		};
	}
	
	@Test(dataProvider="getData")
	public void doLoginTest(String userName , String password) {
		accountPage = loginPage.doLogin(userName, password);
	    Assert.assertTrue(accountPage.isLogoutLinkExist());
	}
	
	// should not have any driver 
}
