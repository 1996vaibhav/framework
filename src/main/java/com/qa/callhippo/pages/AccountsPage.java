package com.qa.callhippo.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*
 * when ever we are clicking on any element and because of that we are landing on any new 
 * page then the method responsibility to give me next landing page object
 * page chaining model
 */

import com.qa.callhippo.constants.AppConstants;
import com.qa.callhippo.utils.ElementUtil;

public class AccountsPage {
	
	
	
	private  WebDriver driver;
	
	private ElementUtil elementUtil;

	
	private By headers = By.xpath("//div[@id='content']/h2");
	
	private By logoutLink = By.linkText("Logout");
	
	private By searchField = By.name("search");
	
	private By searchIcon = By.xpath("//div[@id='search']//span");
	
	
	
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);

		
	}
	
	
	public ArrayList<String> getHeaders() {
		List<WebElement> headersList = driver.findElements(headers);
		System.out.println(headersList.size());
		ArrayList<String> headersListVal = new ArrayList<String>();
		
		for(WebElement e : headersList) {
			String text = e.getText();
			headersListVal.add(text);	
		}
		return 	headersListVal;
	}
	
	public boolean isLogoutLinkExist() {
		return elementUtil.isElementDisplayed(logoutLink, AppConstants.DEFAULT_SHORT_WAIT);
		//return driver.findElement(logoutLink).isDisplayed();
	}

	public ProductListingPage doSearch(String searchKey) {
		System.out.println("search key is " + searchKey);
		WebElement searchEles = elementUtil.getWebElement(searchField,AppConstants.DEFAULT_SHORT_WAIT);
		searchEles.clear();
		searchEles.sendKeys(searchKey);
		elementUtil.doClick(searchIcon);
		
		return new ProductListingPage (driver);
		
		
		//driver.findElement(searchField).sendKeys(searchKey);
		//driver.findElement(searchIcon).click();	
		
	}
	
}
