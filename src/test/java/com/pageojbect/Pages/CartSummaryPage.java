package com.pageojbect.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.Actions;

public class CartSummaryPage {
	WebDriver driver;

	public CartSummaryPage(WebDriver ldriver){

		driver=ldriver;

		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//div[@class='inventory_item_name']")
	WebElement productTitle1;

	@FindBy(xpath="//div[@class='inventory_item_price']")
	WebElement productPrice;

	@FindBy(xpath=" //button[@id='checkout']")
	WebElement checkOutbutton;

	
	public double getProductPrice() {
		
		String productTitle=productTitle1.getText();
		String price = productPrice.getText();
		String productPrice = price.replaceAll("[^a-zA-Z0-9]","");
		Double finalPrice=Double.parseDouble(productPrice);
		return finalPrice/10;
	}
	
	public UserDetailsPage validatCheckOutbutton() {

		Actions.isDisplayed(checkOutbutton);
		Actions.clickOnElement(checkOutbutton, 10);
		return new UserDetailsPage(driver);
		
		
	}

}
