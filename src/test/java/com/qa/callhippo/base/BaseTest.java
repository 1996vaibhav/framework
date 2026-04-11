package com.qa.callhippo.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.callhippo.factory.DriverFactory;
import com.qa.callhippo.pages.AccountsPage;
import com.qa.callhippo.pages.LoginPage;
import com.qa.callhippo.pages.ProductInfoPage;
import com.qa.callhippo.pages.ProductListingPage;
import com.qa.callhippo.pages.RegistrationPage;

public class BaseTest {

	//parent of all testNG classes
	
	//create own webdriver first
	//all page reference should be mantain in base test

	
    protected WebDriver driver;
    
	DriverFactory df; //DriverFactory df = new DriverFactory(chrome);
	
	protected LoginPage loginPage; // LoginPage loginPage = new LoginPage(driver);

	protected AccountsPage accountPage ; //AccountPage accountPage = new AccountPage(driver);
	
	protected ProductListingPage productListingPage ; 
	
	protected ProductInfoPage productInfoPage ;
	
	protected RegistrationPage  registrationPage ;
	

	
	@BeforeTest
	public void setUp() {
		
	df = new DriverFactory();
	driver = df.intdriver("firefox"); //stored in THIS driver variable
	loginPage = new LoginPage(driver); //THIS driver from BaseTest sent to LoginPage!
	/*
	 * intdriver method is giving me the driver only so i am storing it in driver only 
	 */
	
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}
