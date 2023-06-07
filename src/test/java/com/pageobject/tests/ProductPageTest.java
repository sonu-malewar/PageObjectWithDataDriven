package com.pageobject.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageojbect.Pages.CartSummaryPage;
import com.pageojbect.Pages.FirstLoginPage;
import com.pageojbect.Pages.LogOutPage;
import com.pageojbect.Pages.ProductPage;

import Utilities.Actions;
import Utilities.XLUtility;

public class ProductPageTest extends BaseClass

{
	FirstLoginPage loginPage;
	ProductPage productPage;
	CartSummaryPage cartSummaryPage;
	

	
	@BeforeTest(groups ="smoke")
	public void setUp() {
		launchApp();
	}

	@AfterTest(groups ="smoke")
	public void tearDown() {

		getDriver().quit();
	}
	@Test
	public void loginTest(String uname, String pwd) {
		loginPage= new FirstLoginPage(getDriver());
		loginPage.enterUsernameAndPassword();
		productPage=loginPage.clickOnLoginButton();

	}

	@Test
	public void pageTextValidate() {
		productPage= new ProductPage(getDriver());
		String text = productPage.productText();
		String actualText="Products";
		Assert.assertEquals(text, actualText);
		logger.info("product text matches");

	}

	@Test
	public void verifyProductIsDisplayed() {
		productPage= new ProductPage(getDriver());
		productPage.validateProductItem();
		logger.info("click on product");
		}
	

	@Test
	public CartSummaryPage verifyClickOnCart() {
		
		 productPage.validateCartButton();
		
		logger.info("cart button displayed and clicked ");
		
		productPage.validateCartLink1();
		
		logger.info("click on cart button ");
		
		int count=0;
		int expectedCount=1;
		while(count==0) {

			count++;
			System.out.println("Cart count " +count);
			break;
		}
		
		Assert.assertEquals(expectedCount, count);
		
		logger.info("count gets increased");
		
		return new CartSummaryPage(getDriver());


	}
	
	




	/*
	 * @Test(groups = "smoke",priority = 1,enabled = true ) public void
	 * endToEndFlow_ForPlaceOrder() throws IOException { FirstLoginPageTest flpt =
	 * new FirstLoginPageTest(); flpt.verify_Login(); ProductPage pPg = new
	 * ProductPage(driver); pPg.addToCartbutton(); pPg.cartLink();
	 * pPg.checkoutButton(); pPg.enterFirstName("Sonu");
	 * pPg.enterLastName("Malewar"); pPg.enterZipcode("411021");
	 * pPg.clickContinue(); pPg.clickOnFinish();
	 * 
	 * logger.info("user has placed order successfully");
	 * 
	 * Assert.assertEquals(pPg.verifySuccessMsg(),"Thank you for your order!");
	 * 
	 * logger.info("Thank you text matches successfully");
	 * 
	 * captureScreenShot(driver, "endToEndFlow_ForPlaceOrder"); }
	 * 
	 * @Test public void doSelectByValue() { ProductPage pPg = new
	 * ProductPage(driver); pPg.selectValueFromDrodown(); }
	 * 
	 * 
	 * @Test(groups = "regression",priority = 2, enabled= false, dependsOnMethods =
	 * {"verify_Login"}) public void verifyCart_cancel() throws IOException {
	 * FirstLoginPageTest flpt = new FirstLoginPageTest(); flpt.verify_Login();
	 * ProductPage pPg = new ProductPage(driver); pPg.addToCartbutton();
	 * pPg.cartLink(); pPg.checkoutButton(); pPg.clickCancel();
	 * 
	 * logger.info("cancel cart item");
	 * 
	 * Assert.assertEquals(pPg.verifyPgText(),"Your Cart");
	 * 
	 * logger.info("Your cart text matches"); captureScreenShot(driver,
	 * "verifyCart_cancel"); }
	 */

}




