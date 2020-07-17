package com.qa.flipkart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.flipkart.base.BaseClass;
import com.qa.flipkart.pages.HomePage;
import com.qa.flipkart.pages.LoginPage;
import com.qa.flipkart.pages.SearchPage;
import com.qa.flipkart.pages.SearchResultPage;

public class SearchPageTest extends BaseClass{
	
	
	LoginPage loginpage;
	HomePage homepage;
	SearchPage searchpage;
	SearchResultPage searchResultPage;
	public SearchPageTest () {
		super();
	}
	
	@BeforeClass
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
		homepage =new HomePage();
		searchpage=new SearchPage();
		searchResultPage=new SearchResultPage();
		homepage = loginpage.login(prop.getProperty("mobileno"), prop.getProperty("password"));
	}
	
	
	

	@Test(priority = 1)
	public void searchButtonIsDisplayedTest() {
		Assert.assertTrue(searchpage.searchButtonIsDisplayed());
	}

	@Test(priority = 0)
	public void searchButtonIsEnabledTest() {
		Assert.assertTrue(searchpage.searchButtonIsEnabled());
		
	}
	
	@Test(priority = 1)
	public void verifySearchTextboxDisplayedTest()
	{
	   Assert.assertTrue(searchpage.verifySearchTextboxDisplay(), "SearchTextbox is Not display");
	}
    
	@Test(priority = 1)
	public void verifySearchTextboxEnableTest()
	{
	   Assert.assertTrue(searchpage.verifySearchTextboxEnable(), "SearchTextbox is Not display");
	}
	
	
	@Test(priority = 2)
	public void verifyAutoSuggestTest() throws InterruptedException {
	 searchResultPage=searchpage.verifyAutoSuggest();
		
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {

		//driver.quit();
	}

}
