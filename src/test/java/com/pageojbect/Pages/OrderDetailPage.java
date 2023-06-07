package com.pageojbect.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pageobject.tests.BaseClass;

import Utilities.Actions;

public class OrderDetailPage extends BaseClass {
	WebDriver driver;
	public OrderDetailPage (WebDriver ldriver){

		driver=ldriver;
		PageFactory.initElements(driver,this);
	}


	@FindBy(xpath="//div[@class='summary_subtotal_label']")
	WebElement productActPrice;

	@FindBy(xpath="//div[@class='summary_tax_label']")
	WebElement taxPrice;

	@FindBy(xpath=" //div[@class='summary_info_label summary_total_label']")
	WebElement totalPrice;

	@FindBy(xpath="//button[@id='finish']")
	WebElement finishBtn;

	public double getProductprice() {
		String price =productActPrice.getText();
		String price1= price.replaceAll("[a-zA-Z_/:/$/.]", "");
		Double actPrice =Double.parseDouble(price1);


		double finalPrice = actPrice/100;
		return finalPrice;
	}
	public double getProductpriceWithTax() {
		String price =totalPrice.getText();
		String price1= price.replaceAll("[a-zA-Z_/:/$/.]", "");
		Double finalPrice =Double.parseDouble(price1);


		double finalProprice = finalPrice/100;
		return finalProprice;
	}

	public CheckOutPage verifyClickOnFinsh() {
		Actions.clickOnElement(finishBtn, 10);

		return new CheckOutPage(driver);
	}


}
