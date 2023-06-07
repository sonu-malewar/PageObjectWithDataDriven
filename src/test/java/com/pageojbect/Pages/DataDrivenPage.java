package com.pageojbect.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataDrivenPage {
	
	WebDriver driver;

	public DataDrivenPage(WebDriver ldriver){

		driver=ldriver;

		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//input[@id='user-name']") 
	WebElement user;

	@FindBy(xpath="//input[@id='password']")
	WebElement pass;

	@FindBy(xpath=" //input[@id='login-button']")
	WebElement loginButton;
	

	
	
	//identify action on webelement
	public void enterUsername(String userN) {
		user.sendKeys(userN);
	}

	public void enterPassword(String passW) {
		pass.sendKeys(passW);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

}
