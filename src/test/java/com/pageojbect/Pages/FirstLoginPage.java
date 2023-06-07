package com.pageojbect.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pageobject.tests.BaseClass;

import Utilities.Actions;

public class FirstLoginPage extends BaseClass {
	
	WebDriver driver;

	public FirstLoginPage(WebDriver ldriver){

		driver=ldriver;

		PageFactory.initElements(driver,this);
	}

	//identify webelements
	@FindBy(xpath="//input[@id='user-name']") 
	WebElement uname;

	@FindBy(xpath="//input[@id='password']")
	WebElement pwd;

	@FindBy(xpath=" //input[@id='login-button']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[text()='Swag Labs']")
	WebElement pageTitle;
	
	
	
	//identify action on webelement
	public void enterUsernameAndPassword() {
		Actions.enterText(uname, "standard_user");
		Actions.enterText(pwd, "secret_sauce");
	}

	public void DataDrivenTestPara(String username,String password) {
		Actions.enterText(uname, username);
		Actions.enterText(pwd, password);
	}


	public ProductPage clickOnLoginButton() {
		Actions.clickOnElement(loginButton, 10);
		return new ProductPage(driver);
	}
	
	
	
	
	
}
