package com.pageobject.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dataprovider.DataProviders;
import com.pageojbect.Pages.FirstLoginPage;
import com.pageojbect.Pages.LogOutPage;

public class FirstLoginPageTest extends BaseClass
{
	FirstLoginPage loginPage;
	
	
	@BeforeMethod(groups = "smoke")
	public void setUp() {
		launchApp();
	}
	
   @AfterMethod(groups = "smoke")
	public void teardown() {
		getDriver().quit();
	}

	
	@Test(groups ="smoke")
	public void verify_Login() throws IOException
	{

		loginPage= new FirstLoginPage(getDriver());
		//loginPage.enterUsernameAndPassword();
		loginPage.clickOnLoginButton();
		logger.info("user logged in successfully");
		//captureScreenShot(getDriver(), "verify_Login");
	}

	@Test(groups ="smoke")
	public void verifyTitle() throws IOException {
		loginPage= new FirstLoginPage(getDriver());

		Assert.assertEquals(getDriver().getTitle(),"Swag Labs1");

		logger.info("page title matches as Swag Labs ");
		

	}













}
