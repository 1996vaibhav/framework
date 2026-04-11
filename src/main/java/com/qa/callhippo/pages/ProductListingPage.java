package com.qa.callhippo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.callhippo.constants.AppConstants;
import com.qa.callhippo.utils.ElementUtil;

public class ProductListingPage {
	
	public WebDriver driver ; 

	
	ElementUtil elementUtil;

	/*
	 * After performing a search operation, verify how many results are displayed 
	 * for the given search input.
	 * 
	 * For example, if we search for "Samsung" and 3 products are displayed,
	 * then the requirement is to capture and validate the exact count of 
	 * the search results.
	 */
	/*
	 * ================================================================================================
	 * linkText works when text is present inside an <a> (anchor) tag
	 * ================================================================================================
	 */
	
	private  final By searchSubCategory = By.xpath("//div[@id='content']//div//label");
	
	private final By searchResult = By.xpath("//div[@id='content']//div[@class='product-thumb']");
	
	private final By searchHeader = By.xpath("//div/h1");
	
	
	public ProductListingPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

			
	}
	
	
	
	public int getSearchResultCount() {
		int seachCount = elementUtil.waitForElementsVisible(searchResult, 10).size();
		System.out.println("total product listed under brand macbook are " + seachCount);
		return seachCount;
		
	}
	
	
	public String getSearchHeaderText() {
		String headerText = elementUtil.doElementGetText(searchHeader);
		System.out.println("header text present on product page is " + headerText );
		return headerText;
	}
	
	
	public boolean searchsubcategoryExist() {
		return elementUtil.isElementDisplayed(searchSubCategory, AppConstants.DEFAULT_SHORT_WAIT);
		
	}
	
	
	public ProductInfoPage doSelectProduct(String productName) {
//		   need to click on the product , think this as a customer , after getting samsung related result we 
//		   click on our choice of product , sanme need to check it over here
		   System.out.println("product name is " + productName);
//		   By selectedProduct = By.linkText(productName);
//		   elementUtil.doClick(By.linkText(productName));
		   
		   elementUtil.doWaitForClick(By.linkText(productName) , 10);
//		   y locator declared inside this method 
		   
//		   When do we use class-level locator?
//		   When element is fixed and never changes
//		   example - searchfield
//		   When do we use method-level locator?
//         When element is dynamic
//		   example - product name 
		   
		   
		   return new ProductInfoPage(driver);
		
	}
	
	

	
	
	
	
	
	



}
