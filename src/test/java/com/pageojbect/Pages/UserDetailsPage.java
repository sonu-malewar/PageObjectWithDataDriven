package com.pageojbect.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pageobject.tests.BaseClass;

import Utilities.Actions;

public class UserDetailsPage extends BaseClass {
	
	WebDriver driver;

	public UserDetailsPage(WebDriver ldriver) {
		driver=ldriver;

		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath=" //input[@id='first-name']")
	WebElement firstName;
	
	@FindBy(xpath=" //input[@id='last-name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement postalCode;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueBTn;
	
	public OrderDetailPage enterUserDetails() {
		Actions.enterText(firstName, "Sonu");
		Actions.enterText(lastName, "Malewar");
		Actions.enterText(postalCode, "411021");
		Actions.clickOnElement(continueBTn, 10);
		return new OrderDetailPage(driver);
		}

}
