package com.pageojbect.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pageobject.tests.BaseClass;

import Utilities.Actions;

public class CheckOutPage extends BaseClass {
	
	WebDriver driver;
	public CheckOutPage(WebDriver ldriver){
		
		driver = ldriver;
		PageFactory.initElements(driver, this );
	}
	
	@FindBy(xpath="//h2[text()='Thank you for your order!']")
	WebElement confMesg;
	
	@FindBy(xpath="//button[@id='back-to-products']")
	WebElement backBtn;
     
	public String getConfMesg() {
		String actCmsg = confMesg.getText();
		
		return actCmsg;
		
	}
	public ProductPage navigateBackToProductsPg() {
		Actions.clickOnElement(backBtn, 10);
		return new ProductPage(driver);
}
}