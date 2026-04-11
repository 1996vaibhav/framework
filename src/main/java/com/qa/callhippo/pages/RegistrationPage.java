package com.qa.callhippo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.callhippo.constants.AppConstants;
import com.qa.callhippo.utils.ElementUtil;

public class RegistrationPage {

	private WebDriver driver;
	
	ElementUtil elementUtil;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);	
	}
	
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

	private By successMessg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	
	

	public boolean userRegister(String firstName, String lastName, String email,
	        String telephone, String password) {
		
		
		

		elementUtil.waitForElementVisible(this.firstName, AppConstants.DEFAULT_MEDIUEM_WAIT).sendKeys(firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmpassword, password);


		elementUtil.doClick(agreeCheckBox);
		elementUtil.doClick(continueButton);

	    String successMesg = elementUtil.waitForElementVisible(successMessg, AppConstants.DEFAULT_MEDIUEM_WAIT).getText();

	    System.out.println(successMesg);

	    if (successMesg.contains(AppConstants.USER_REGISTER_SUCCESS_MESSAGE)) {
	    	elementUtil.doClick(logoutLink);
	    	elementUtil.doClick(registerLink);
	    	
	    	return true; //Always do your actions BEFORE return 
	    	
	    } else {
	        return false;
	    }
	}
	
	
	

}
