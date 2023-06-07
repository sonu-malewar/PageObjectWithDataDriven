package com.pageobject.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.pageojbect.Pages.DataDrivenPage;
import com.pageojbect.Pages.FirstLoginPage;
import com.pageojbect.Pages.LogOutPage;
import com.pageojbect.Pages.ProductPage;

import Utilities.Actions;
import Utilities.ExtentListenerClass;

import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	

	public static Logger logger;
	public static Properties prop;

	public FirstLoginPage fLgp;
	//public LogOutPage logOutPg;
	//public ProductPage pPg;
	//public DataDrivenPage dDp;
//declare threadLocal driver
public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
public static WebDriver getDriver() {
	
	return driver.get();
}

	@BeforeSuite
	public void loadConfig() throws IOException {
		
		logger= LogManager.getLogger("PageObject");
		ExtentListenerClass.configureReport();
		try{
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

   
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		String browsername=prop.getProperty("browser");

		switch(browsername) {

		case "chrome" :
			
			 // ChromeOptions options = new ChromeOptions();
			  //options.addArguments("--remote-allow-origins");
			 
			//driver= new ChromeDriver(options);
			driver.set(new ChromeDriver()); // set browser to ThreadLocal
			break;
		case "firefox" :
			//driver= new FirefoxDriver();
			driver.set(new ChromeDriver());
			break;
		}
     
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();

		//for logging
		//logger = LogManager.getLogger("PageObject");

		//open url
		
		logger.info("url opened");

	}
@AfterSuite
public void afterSuite() {
	getDriver().quit();
	
}

	
	
	

	

	


}
