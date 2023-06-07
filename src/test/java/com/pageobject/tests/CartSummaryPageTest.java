package com.pageobject.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageojbect.Pages.CartSummaryPage;
import com.pageojbect.Pages.CheckOutPage;
import com.pageojbect.Pages.FirstLoginPage;
import com.pageojbect.Pages.ProductPage;
import com.pageojbect.Pages.UserDetailsPage;

public class CartSummaryPageTest extends BaseClass{
	
	FirstLoginPage loginPage;
	ProductPage productPage;
	CartSummaryPage cartSummaryPage;
	UserDetailsPage userDetailsPage;

	
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
	@Test(groups = "smoke")
	public void validateProductDetails() {
		productPage = new ProductPage(getDriver());
		String actText=productPage.validateProductItem();
		String expText="Sauce Labs Backpack";
		Assert.assertEquals(actText, expText);
        productPage.validateCartButton();
        cartSummaryPage=productPage.validateCartLink2();
        logger.info("product verified and navigate to cartsummaryPage");
		
		
		
		
	}
	@Test
	public UserDetailsPage validateCheckoutAndNavigateToUserDetailPg() {
		userDetailsPage=cartSummaryPage.validatCheckOutbutton();
      
      logger.info("navigate to checkout");
		
		return new UserDetailsPage(getDriver());
	}
}
