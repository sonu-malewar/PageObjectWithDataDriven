package com.pageobject.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dataprovider.DataProviders;
import com.pageojbect.Pages.CartSummaryPage;
import com.pageojbect.Pages.CheckOutPage;
import com.pageojbect.Pages.FirstLoginPage;
import com.pageojbect.Pages.OrderDetailPage;
import com.pageojbect.Pages.ProductPage;
import com.pageojbect.Pages.UserDetailsPage;

public class OrderDetailPageTest extends BaseClass {
	FirstLoginPage loginPage;
	ProductPage productPage;
	CartSummaryPage cartSummaryPage;
	UserDetailsPage userDetailsPage;
	OrderDetailPage orderDetailPage;
	CheckOutPage checkOutPage;



	@Parameters("browser")
	@BeforeTest(groups = {"smoke","regression"})
	public void setUp() {
		launchApp();
	}

	@AfterTest(groups = {"smoke","regression"})
	public void tearDown() {

		getDriver().quit();
	}
	@Test
	public void loginTest() {
		loginPage= new FirstLoginPage(getDriver());
		loginPage.enterUsernameAndPassword();
		productPage=loginPage.clickOnLoginButton();
		logger.info("user logged in");
	}
	@Test
	public void validateActualProductPrice() {
		
		productPage.validateProductItem();
		productPage.validateCartButton();
		cartSummaryPage=productPage.validateCartLink2();
		userDetailsPage= cartSummaryPage.validatCheckOutbutton();
		userDetailsPage.enterUserDetails();
		 orderDetailPage = new OrderDetailPage(getDriver());
		double actProductPrice = orderDetailPage.getProductprice();
		double expPrice1=29.99;
		Assert.assertEquals(actProductPrice, expPrice1);
		logger.info("Actual price matched");
		double finalProductPrice = orderDetailPage.getProductpriceWithTax();
		double exptotalPrice=32.39;
		Assert.assertEquals(finalProductPrice, exptotalPrice);
		logger.info("Final price matched");

	}

	public CheckOutPage navigateTocheckOutPage() {
		
		productPage.validateProductItem();
		productPage.validateCartButton();
		cartSummaryPage=productPage.validateCartLink2();
		cartSummaryPage.validatCheckOutbutton();
		orderDetailPage=userDetailsPage.enterUserDetails();
	    orderDetailPage.verifyClickOnFinsh();
		logger.info("Navigate to checkoutPage");
		return new CheckOutPage(getDriver());



	}





}
