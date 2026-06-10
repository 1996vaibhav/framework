package com.qa.callhippo.base;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.callhippo.factory.DriverFactory;
import com.qa.callhippo.pages.AccountsPage;
import com.qa.callhippo.pages.LoginPage;
import com.qa.callhippo.pages.ProductInfoPage;
import com.qa.callhippo.pages.ProductListingPage;
import com.qa.callhippo.pages.RegistrationPage;

@Listeners(ChainTestListener.class)


public class BaseTest {

	//parent of all testNG classes
	
	//create own webdriver first
	//all page reference should be mantain in base test

	

	
    protected WebDriver driver;
    protected Properties prop;
    
	DriverFactory df; //DriverFactory df = new DriverFactory(chrome);
	
	protected LoginPage loginPage; // LoginPage loginPage = new LoginPage(driver);

	protected AccountsPage accountPage ; //AccountPage accountPage = new AccountPage(driver);
	
	protected ProductListingPage productListingPage ; 
	
	protected ProductInfoPage productInfoPage ;
	
	protected RegistrationPage  registrationPage ;
	

	/*
	 * here we want to read browser name from testNG file
	 * 
	 */	
	
	/*
	 * need to read parameters frm testNG xml 
	 * 
	 * 
	 */
	
	
	@Parameters({"browser"})
	
	@BeforeTest
	public void setUp(String browserName) {
		
	df = new DriverFactory();
	
	prop = df.initProp();

	if(browserName!=null) {
		prop.setProperty("browser", browserName);
	}
	
	
	
	
	
	driver = df.initDriver(prop); //stored in THIS driver variable
	
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
