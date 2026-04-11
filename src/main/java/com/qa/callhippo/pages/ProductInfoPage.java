package com.qa.callhippo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.callhippo.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	
	private ElementUtil elementUtil;
	
	private final By searchHeader = By.xpath("//div/h1");
	
	private final By productImage = By.xpath("//li/a/img");
	
	ProductInfoPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);	
	}
	
	
	
	public String getProductInfoPageHeaderText() {
		String headerVal = elementUtil.doElementGetText(searchHeader);
		System.out.println("header text is " + headerVal);
		return headerVal;
	}
	
	
	public int getProductImageCount() {
		int imageCount = elementUtil.waitForElementsVisible(productImage, 10).size();
		System.out.println("total image of searchable product are " + imageCount);
		return imageCount;
	}

}
