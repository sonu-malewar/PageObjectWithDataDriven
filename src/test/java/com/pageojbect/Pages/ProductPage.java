package com.pageojbect.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pageobject.tests.BaseClass;

import Utilities.Actions;

public class ProductPage extends BaseClass  {

	WebDriver driver;

	public ProductPage(WebDriver ldriver){

		driver=ldriver;

		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath=" //span[@class='title']")
	WebElement productText;
	
	@FindBy(xpath="//div[contains(text(),'Sauce Labs Backpack')]")
	WebElement productItem;

	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement addToCartbutton;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cartLink;
	
	
    public String productText() {
		
		String text = productText.getText();
		return text;
	}

	
	
	
	public String validateProductItem() {
		Actions.isDisplayed(productItem);
		Actions.clickOnElement(productItem, 20);
		String text = productItem.getText();
		return text;
	}
	
	
		
	
	
	// click on addtocart button 
	public void validateCartButton() {
		Actions.isDisplayed(addToCartbutton);
		Actions.clickOnElement(addToCartbutton, 20);
	}
	
	public void validateCartLink1() {
		Actions.isDisplayed(addToCartbutton);
		Actions.clickOnElement(addToCartbutton, 20);
	}
	
	public CartSummaryPage validateCartLink2() {
		Actions.clickOnElement(cartLink, 10);
		return new CartSummaryPage(driver);
		
			}
	
	public String getCurrentUrl() {
		
		String productPageurl = driver.getCurrentUrl();
		return productPageurl;
	}
			
			
			
		
	
	
	


	
}
