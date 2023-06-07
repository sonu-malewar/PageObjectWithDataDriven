package com.pageobject.tests;

import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageojbect.Pages.CartSummaryPage;
import com.pageojbect.Pages.CheckOutPage;
import com.pageojbect.Pages.FirstLoginPage;
import com.pageojbect.Pages.OrderDetailPage;
import com.pageojbect.Pages.ProductPage;
import com.pageojbect.Pages.UserDetailsPage;

import Utilities.Actions;

public class CheckOutPageTest extends BaseClass {
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
	@Test(groups ="smoke")
	public void endToendFlow() {
		loginPage= new FirstLoginPage(getDriver());
		loginPage.enterUsernameAndPassword();
		productPage=loginPage.clickOnLoginButton();
		logger.info("user logged in");
		productPage= new ProductPage(getDriver());
		
		productPage.validateProductItem();
		
		
		
		productPage.validateCartButton();
		cartSummaryPage=productPage.validateCartLink2();
		userDetailsPage= cartSummaryPage.validatCheckOutbutton();
		orderDetailPage=userDetailsPage.enterUserDetails();
		
		checkOutPage=orderDetailPage.verifyClickOnFinsh();
		
		String actMsg = checkOutPage.getConfMesg();
		String expCmsg ="Thank you for your order!";
		Assert.assertEquals(actMsg, expCmsg);
		logger.info("confirm msg dislayed");
		
		
	}
	
	
		
	@Test(groups = "regression")
	public void navigateBackToProductPg() {
		productPage = new ProductPage(getDriver());
		productPage.validateProductItem();
		
		productPage.validateCartButton();
		cartSummaryPage=productPage.validateCartLink2();
		userDetailsPage= cartSummaryPage.validatCheckOutbutton();
		orderDetailPage=userDetailsPage.enterUserDetails();
		
		checkOutPage=orderDetailPage.verifyClickOnFinsh();
	
		productPage=checkOutPage.navigateBackToProductsPg();
		
		String actPrdtext=productPage.productText();
		String expPrdText="Products";
		Assert.assertEquals(actPrdtext, expPrdText);
		logger.info("Navigate back to productsPage");
		
	}
}
