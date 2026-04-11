package com.qa.callhippo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.callhippo.base.BaseTest;
import com.qa.callhippo.utils.StringUtil;

public class RegestrationPageTest extends BaseTest {

	@BeforeClass
	public void goToRegistrationPageTest() {
		registrationPage = loginPage.navigateToRegisetrPage();	
	}
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][]{
			
			{"vaibhav" , "sonar" , "9638521470" , "Test@123"} ,// email will be different
			{"rahul" , "kumar" , "963852100" , "Test@123"},
			{"jaya" , "sha" , "963852340" , "Test@123"}
			
		};
	}
	
	
	
	@Test(dataProvider = "getData")
	public void userRegisterTest(String firstName , String lastName , String telephone , String password) {
		
	Assert.assertTrue(registrationPage.
			userRegister(firstName, lastName, StringUtil.getRandomEmail() , telephone, password));
		
	
	//static method can be called from ANYWHERE — any class, any package, just import it! 
	}
	

}
