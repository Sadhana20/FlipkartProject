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
	
	@Test
	public void verifyInvalidMobNoTest()
    {
		loginpage.verifyInvalidMobNo(prop.getProperty("mobileno"),prop.getProperty("password"));
				
    }
	@Test
	public void verifyInvalidPasswordTest()
    {
		loginpage.verifyInvalidPassword(prop.getProperty("mobileno"),prop.getProperty("password"));
    }


	  @Test
	  public void loginTest() throws InterruptedException
	  { 
		  homepage =loginpage.login(prop.getProperty("mobileno"), prop.getProperty("password"));
		  
		  Thread.sleep(3000);
	  }
	 
	  
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
