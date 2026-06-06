package com.qa.callhippo.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.callhippo.error.AppError;
import com.qa.callhippo.exceptions.FrameworkExceptions;

public class DriverFactory {

//      used to initialize the driver
//	    this class will decide where u want to run u r code on remote or in u r machine
//		used to start the browser
	
	
	public WebDriver driver;
	public Properties prop ; 
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	
	
	public WebDriver intdriver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.trim().equalsIgnoreCase("chrome")){
			//driver = new ChromeDriver();
			tldriver.set(new ChromeDriver());
			System.out.println("chrome launched successfully");
		}
		
		else if(browserName.trim().equalsIgnoreCase("firefox")) {
			//driver = new FirefoxDriver();	
			tldriver.set(new FirefoxDriver());
			System.out.println("firefox launched successfully");

		}
		
		else if(browserName.trim().equalsIgnoreCase("edge")) {
			//driver = new EdgeDriver();
			tldriver.set(new EdgeDriver());
			System.out.println("edge launched successfully");

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
		
		getDriver().manage().deleteAllCookies(); //cookies clear
		
		getDriver().manage().window().maximize(); // window maximize
		
		getDriver().get(prop.getProperty("url")); // url launch
		
		return getDriver(); // return always goes back to the CLASS that called it's method

	}
	
	
	
	public static WebDriver getDriver() {
		return tldriver.get();
	}
	
//	   need to read data from config.properties
//     first create the object of Properties
//	   create object of FileInputStream 
//	   make the connection with properties file using FileInputStream
//	   provide path of config properties inside constructor of FileInputStream
//	   load the properties
//	   return prop
	
	
	public Properties initProp() {
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
		
		
	}
	
	
	
	
	
	

}
