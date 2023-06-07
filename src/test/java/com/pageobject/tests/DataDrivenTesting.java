package com.pageobject.tests;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.XLSBUnsupportedException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dataprovider.DataProviders;
import com.pageojbect.Pages.DataDrivenPage;
import com.pageojbect.Pages.FirstLoginPage;

import Utilities.XLUtility;

public class DataDrivenTesting extends BaseClass {
	FirstLoginPage loginPage;
	

	
	@BeforeMethod
	public void setUp() {
		launchApp();
	}


	public void teardown() {
		getDriver().quit();
	}

	@Test(dataProvider = "Credentia1",dataProviderClass = DataProviders.class,groups ="regression")
	public void DataDrivenTest(String username,String password) throws IOException
	{

		loginPage= new FirstLoginPage(getDriver());

		//Data driven test
		loginPage.DataDrivenTestPara(username,password );
		loginPage.clickOnLoginButton();

		logger.info("user logged in successfully");
		//captureScreenShot(getDriver(), "verify_Login");
	}




}
