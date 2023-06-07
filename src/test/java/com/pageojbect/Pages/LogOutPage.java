package com.pageojbect.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	
	WebDriver driver;

	public LogOutPage(WebDriver ldriver){

		driver=ldriver;

		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='bm-burger-button']")
	WebElement burgerMenu;
	
	@FindBy(xpath="//a[@id='about_sidebar_link']")
	WebElement aboutLink;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement logoutLink;
	
	public void clickOn_burgerMenu() {
		 burgerMenu.click();;
		
	}
	
	public void logoutLink() {
		logoutLink.click();;
	
	}
}