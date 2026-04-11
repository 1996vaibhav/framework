package com.qa.callhippo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.callhippo.constants.AppConstants;
import com.qa.callhippo.utils.ElementUtil;


public class LoginPage {
	
	
	/*
	 *  every page class will have it's own element util
	 *  
	 *  naming of the method should always depends upon the behavior of method
	 *  
	 *  
	 */


	private WebDriver driver; //← SCOPE = entire class ✅
	
	private ElementUtil elementUtil;
	

	//	locators should be private in nature
	//	Locators are private so that no other class can access and accidentally change their value
	//	functionality of page method is that perform something on page or get something from page and then return 
	//	private locators are used in our public methods 
	//	Locators are hidden from the world, Public Methods are the only gateway to use them — this is Encapsulation

	private By emailEle = By.name("email");

	private By passwordEle = By.name("password");

	private By signInButtonEle = By.xpath("//input[@type='submit']");

	private By forgottenPasswordLink = By.xpath("//a[text()='Forgotten Password']");
	
	private By registerLink = By.linkText("Register");
	
	
	


	//		public constructor

	public LoginPage(WebDriver driver) { //FIRST received HERE as parameter! (driver)
		this.driver = driver;	   //saved into class variable! +  SCOPE = only inside this constructor!
		elementUtil = new ElementUtil(driver);
		
		
		
	} //Constructor ends, parameter DIES here!
	
//	Constructor should always be public so that other classes can create an object of that class!



	//		Methods public in nature
	//	    Methods are public because our Test class needs to call them — if they were private, 
	//	    test class cannot interact with the page at all and our entire framework breaks."
	
	
//	         getting something = return
//	         Action only = void = no return


	public String getTitle() {
		
	 
		String pageTitle = elementUtil.waitForPartialTitleToBeExist(AppConstants.DEFAULT_SHORT_WAIT, AppConstants.LOGIN_PAGE_TITLE);
		
//		String pageTitle = driver.getTitle();
		
		
		System.out.println(pageTitle);
		return 	pageTitle;
	}


	public String loginPageUrl() {
		
		
		String currentPageUrl = elementUtil.waitForFullURL(AppConstants.DEFAULT_SHORT_WAIT, AppConstants.LOGIN_PAGE_URL);
		
//		String currentPageUrl = driver.getCurrentUrl();
		
		System.out.println(currentPageUrl);
		return currentPageUrl;
	}

	public boolean  isSignInButtonExist() {
		return  elementUtil.isElementDisplayed(signInButtonEle, AppConstants.DEFAULT_SHORT_WAIT);
		
		
		//return driver.findElement(signInButtonEle).isDisplayed();
		
		
	}


	public boolean  isForgotPasswordLinkExist() {
		return elementUtil.isElementDisplayed(forgottenPasswordLink , AppConstants.DEFAULT_SHORT_WAIT);
		
		
		//return driver.findElement(forgottenPasswordLink).isDisplayed();
		
		/*
		 * naming convention of methods
		 * method name should always define the behavior of application
		 * 
		 */
		
		
	}


	public AccountsPage doLogin(String userName , String password) {
		
		elementUtil.doSendValueToInputField(emailEle, AppConstants.DEFAULT_SHORT_WAIT, userName);
		elementUtil.doSendValueToInputField(passwordEle, AppConstants.DEFAULT_SHORT_WAIT, password);
		elementUtil.doClick(signInButtonEle);
		
		
//		driver.findElement(emailEle).sendKeys(userName);
//		driver.findElement(passwordEle).sendKeys(password);
//		driver.findElement(signInButtonEle).click();
		
		return new AccountsPage(driver);
		
//		In a proper POM framework, after clicking login you land on a new page (Dashboard) — 
//		so ideally it should return that page object along with the driver
//		if a method returns integer , u store it inside the int
//		if a method returns String , u store it inside the String
//		do if a method returning another class object , then store it inside that specific object
		
		
	}


	
	public RegistrationPage navigateToRegisetrPage() {
		elementUtil.waitForElementVisible(registerLink, AppConstants.DEFAULT_MEDIUEM_WAIT).click();
		return new RegistrationPage(driver);
		
	}

}
