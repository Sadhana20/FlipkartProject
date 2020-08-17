package com.qa.flipkart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.flipkart.base.BaseClass;
import com.qa.flipkart.keywords.Constants;
import com.qa.flipkart.pages.HomePage;
import com.qa.flipkart.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		HomePage flag = loginpage.login(Constants.prop.getProperty("mobileno"), Constants.prop.getProperty("password"));
		Thread.sleep(4000);
		Assert.assertEquals(flag, "unable to login");
	}

	@Test(priority = 2)
	public void verifyInvalidPasswordTest() {
		boolean flag = loginpage.verifyInvalidInput(Constants.prop.getProperty("mobileno"), "sah12");
		Assert.assertTrue(flag, "wrong Mobile No and Password   error Message is not displayed");

	}

	@Test(priority = 3)
	public void verifyInvalidMobNoTest() {
		loginpage.verifyInvalidInput("9860947525", Constants.prop.getProperty("password"));

	}

	@Test(priority = 4)
	public void verifyBlankFieldLoginTest() {
		loginpage.verifyInvalidInput("", "");

	}

	@AfterMethod
	public void closeBrowser() {
		Constants.driver.quit();
	}
}
