package com.qa.callhippo.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.callhippo.error.AppError;
import com.qa.callhippo.exceptions.FrameworkExceptions;

public class DriverFactory {

//      used to initialize the driver
//	    this class will decide where u want to run u r code on remote or in u r machine
//		used to start the browser
	
	
	public WebDriver driver;
	
	
	public WebDriver intdriver(String browserName) {
		
		
		if(browserName.trim().equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			System.out.println("chrome launched successfully");
		}
		
		else if(browserName.trim().equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();	
		}
		
		else if(browserName.trim().equalsIgnoreCase("safari")) {
			driver = new SafariDriver();	
		}
		
		else{
			System.out.println(AppError.INVALID_BROWSER_NAME + " " + browserName );
			throw new FrameworkExceptions("=========INVALID BROWSER===============");	
		}
		
		/*
		 * in order to read properties form config file we have to wriet java code
		 * in driver factory we maintain initilise property method also
		 * this initilise property method will read the data from config,property method by using java method
		 * 
		 * 
		 */
		
		driver.manage().deleteAllCookies(); //cookies clear
		
		driver.manage().window().maximize(); // window maximize
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login"); // url launch
		
		return driver; // return always goes back to the CLASS that called it's method

	}
	
//     first create the object of Properties
//	   create object of FileInputStream class
//	   make the connection with properties file
//	   load the properties
//	   return prop
	
	
	
	
	
	

}
