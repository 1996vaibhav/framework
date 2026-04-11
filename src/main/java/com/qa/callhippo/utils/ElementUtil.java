package com.qa.callhippo.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {


	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
		
	}
	/*
	 * By product = By.xpath("//img[contains(@title,'" + productName + "')]/parent::a");
	 */
	
	public  String waitForFullTitleToBeExist(int timeout , String fullTitleValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		try {
		wait.until(ExpectedConditions.titleIs(fullTitleValue));
		return driver.getTitle();
		}catch(TimeoutException e){
			System.out.println(e.getMessage());
			System.out.println("title mismatch" + "passing the wrong title " + fullTitleValue);
		}
		return driver.getTitle();
	
	
}
	
	

	public  String waitForPartialTitleToBeExist(int timeout , String fractionalTitleValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		try {
		wait.until(ExpectedConditions.titleContains(fractionalTitleValue));
		}catch(TimeoutException e){
			System.out.println(e.getMessage());
			System.out.println("title mismatch" + "passing the wrong title " + fractionalTitleValue);
		}
		return driver.getTitle();
		

	}

	
	public  String waitForFullURL(int timeout , String fullURLValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		
		try {
		wait.until(ExpectedConditions.urlToBe(fullURLValue));
		return driver.getCurrentUrl();
		}catch(TimeoutException e){
			System.out.println(e.getMessage());
			System.out.println("url mismatch" + "passing the wrong url " + fullURLValue);
		}
		return driver.getCurrentUrl();
		

	}
	
	
	public boolean isElementDisplayed(By locator , int timeout) {
		
		try {
			

			return getWebElement(locator, timeout).isDisplayed();

			
		} 
		catch (NoSuchElementException e) {
			System.out.println("element not found on web page" + locator);
			return false;
			
		}
		
	}


	public   WebElement getWebElement(By locator , int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		
	}
	
	
	
    public  WebElement doGetWebElement(By locator , int timeout) {
		
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	
	  return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 	
}	
    
    
    public  void doSendValueToInputField(By locator , int timeout , String value) {
    	doGetWebElement(locator, timeout).sendKeys(value);		
	}	
    
    
    public  void doClick(By locator) {
    	getElement(locator).click();
   	 
    }
    
    public void doWaitForClick(By locator , int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    

    public String doElementGetText(By locator) {
        return getElement(locator).getText();
    }
    
    
    public WebElement getElement(By locator) {
    	return driver.findElement(locator);
    }
    
    public void doSendKeys(By locator , String value) {
    	 getElement(locator).sendKeys(value);
    }
    
    public List<WebElement> waitForElementsPresence(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    
    public List<WebElement> waitForElementsVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
	
    
    public WebElement  waitForElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
	

