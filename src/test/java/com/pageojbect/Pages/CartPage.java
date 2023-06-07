/*package com.pageojbect.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.Actions;

public class CartPage {
	

	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkoutButton;

	@FindBy(xpath="//input[@id='first-name']")
	WebElement enterFirstName;

	@FindBy(xpath="//input[@id='last-name']")
	WebElement enterLastName;

	@FindBy(xpath="//input[@id='postal-code']")
	WebElement enterZipcode;

	@FindBy(xpath="//input[@id='continue']")
	WebElement clickContinue;

	@FindBy(xpath="//button[@id='finish']")
	WebElement finishBtn;

	@FindBy(xpath="//*[text()='Thank you for your order!']")
	WebElement successMsg;

	@FindBy(xpath="//button[@id='cancel']")
	WebElement cancelBtn;

	@FindBy(xpath="//*[text()=\"Your Cart\"]")
	WebElement pageText;
	
	public void selectValueFromDrodown() {
		Actions.selectDropdownByValue(dropDown, "lohi");
	}

	public void addToCartbutton() {
		addToCartbutton.click();
	}

	public void cartLink() {
		cartLink.click();
	}

	public void checkoutButton() {
		checkoutButton.click();
	}

	public void enterFirstName(String firstName) {
		enterFirstName.sendKeys(firstName);;
	}

	public void enterLastName(String lastName) {
		enterLastName.sendKeys(lastName);
	}

	public void enterZipcode(String zipCode) {
		enterZipcode.sendKeys(zipCode);
	}

	public void clickContinue() {
		clickContinue.click();
	}


	public void clickOnFinish() {
		finishBtn.click();
	}

	public String verifySuccessMsg() {
		return successMsg.getText();
	}

	public void clickCancel() {
		cancelBtn.click();
	}
	public String verifyPgText() {
		return pageText.getText();
	}


}*/
