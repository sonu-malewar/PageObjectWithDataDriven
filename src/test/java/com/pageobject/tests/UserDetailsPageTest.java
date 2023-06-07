package com.pageobject.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageojbect.Pages.CartSummaryPage;

import com.pageojbect.Pages.FirstLoginPage;
import com.pageojbect.Pages.OrderDetailPage;
import com.pageojbect.Pages.ProductPage;
import com.pageojbect.Pages.UserDetailsPage;

public class UserDetailsPageTest extends BaseClass {

	FirstLoginPage loginPage;
	ProductPage productPage;
	CartSummaryPage cartSummaryPage;
	UserDetailsPage userDetailsPage;
	OrderDetailPage orderDetailPage;
	
	
	
	@BeforeTest(groups = {"smoke","regression"})
	public void setUp() {
		launchApp();
	}

	@AfterTest(groups = {"smoke","regression"})
	public void tearDown() {

		getDriver().quit();
	}

	@Test(groups = "smoke")
	public void loginTest() {
		loginPage= new FirstLoginPage(getDriver());
		loginPage.enterUsernameAndPassword();
		productPage=loginPage.clickOnLoginButton();
		logger.info("user logged in");
	}
	@Test
	public void validateUserAddedDetails() {
		productPage = new ProductPage(getDriver());
		productPage.validateProductItem();
		productPage.validateCartButton();
		cartSummaryPage=productPage.validateCartLink2();
		userDetailsPage=cartSummaryPage.validatCheckOutbutton();
		orderDetailPage=userDetailsPage.enterUserDetails();
		logger.info("user added details successfully");

	}
	@Test
	public OrderDetailPage NavigateToCheckOutPage() {
		productPage = new ProductPage(getDriver());
		productPage.validateProductItem();
		productPage.validateCartButton();
		cartSummaryPage=productPage.validateCartLink2();
		userDetailsPage=cartSummaryPage.validatCheckOutbutton();
		orderDetailPage=userDetailsPage.enterUserDetails();
		return new OrderDetailPage(getDriver());

	}
	

}
