package com.qa.flipkart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.flipkart.base.BaseClass;
import com.qa.flipkart.keywords.Constants;
import com.qa.flipkart.pages.CartPage;
import com.qa.flipkart.pages.HomePage;
import com.qa.flipkart.pages.LoginPage;
import com.qa.flipkart.utility.Utility;

public class CartPageTest extends BaseClass {
	CartPage cartPage;
	HomePage homePage;
	LoginPage loginPage;
	Utility util;

	public CartPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		cartPage = new CartPage();
		util = new Utility();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(Constants.prop.getProperty("mobileno"), Constants.prop.getProperty("password"));
		cartPage.clickOnCartLink();
		Thread.sleep(4000);

	}

	@Test(priority = 1)
	public void verifyCartPage() throws InterruptedException {
		String title = cartPage.validateCartTitle();
		Assert.assertEquals(title, "Shopping Cart | Flipkart.com", "title is missmatch");

	}

	@Test(priority = 2)
	public void verifyShopnowBtn() {
		boolean flag = cartPage.validateShopnowBtn();
		Assert.assertTrue(flag);

	}

	@AfterMethod
	public void tearDown() {
		Constants.driver.quit();
	}
}
