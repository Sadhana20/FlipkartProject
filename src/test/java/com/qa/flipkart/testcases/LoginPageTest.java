package com.qa.flipkart.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.flipkart.base.BaseClass;
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
		homepage = loginpage.login(prop.getProperty("mobileno"), prop.getProperty("password"));
		

		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void verifyInvalidPasswordTest() {
		loginpage.verifyInvalidInput(prop.getProperty("mobileno"), "sah12");

	}

	@Test(priority = 3)
	public void verifyInvalidMobNoTest() {
		loginpage.verifyInvalidInput("9860947525", prop.getProperty("password"));

	}

	@Test(priority = 4)
	public void verifyBlankFieldLoginTest() {
		loginpage.verifyInvalidInput("", "");

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
