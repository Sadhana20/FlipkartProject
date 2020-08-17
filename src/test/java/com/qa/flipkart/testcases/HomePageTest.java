package com.qa.flipkart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.flipkart.base.BaseClass;
import com.qa.flipkart.keywords.Constants;
import com.qa.flipkart.pages.HomePage;
import com.qa.flipkart.pages.LoginPage;
import com.qa.flipkart.pages.SearchResultPage;
import com.qa.flipkart.utility.Utility;

public class HomePageTest extends BaseClass {

	LoginPage loginpage;
	HomePage homepage;
	SearchResultPage searchresultpage;
	Utility util;

	public HomePageTest() {
		super();
	}

	@BeforeClass
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		searchresultpage = new SearchResultPage();

		homepage = loginpage.login(Constants.prop.getProperty("mobileno"), Constants.prop.getProperty("password"));

	}

	@Test(priority = 0)
	public void verifyHomepageTitleTest() {
		String homepagetitle = homepage.verifyHomepageTitle();
		Assert.assertEquals(homepagetitle,
				"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!",
				"Title is not like Expected");
	}

	@Test(priority = 0)
	public void flipkartLogoIsDisplayedTest() {
		Assert.assertTrue(homepage.flipkartLogoIsDisplayed());

	}

	@Test(priority = 1)
	public void mouseHoverOnElectronicsTest() throws InterruptedException {
		homepage.mouseHoverOnElectronics();
	}

	@Test(priority = 2)
	public void mouseHoverOnTVnandAppliancesTest() throws InterruptedException {
		homepage.mouseHoverOnTVnandAppliances();
	}

	@Test(priority = 1)
	public void verifyTextboxLabelTest() {

		String label = homepage.verifyTextboxLabel();
		Assert.assertEquals(label, "Search for products, brands and more", "not matched");

	}

	@Test(priority = 3)
	public void mouseHoverOnMenTest() throws InterruptedException {
		homepage.mouseHoverOnMen();
	}

	@Test(priority = 4)
	public void mouseHoverOnWomenTest() throws InterruptedException {
		homepage.mouseHoverOnWomen();
	}

	@Test(priority = 5)
	public void mouseHoverOnBabyAndKidTest() throws InterruptedException {
		homepage.mouseHoverOnBabyAndKid();
	}

	@Test(priority = 6)
	public void mouseHoverOnHomeandFurnitureTest() throws InterruptedException {
		homepage.mouseHoverOnHomeandFurniture();
	}

	@Test(priority = 7)
	public void mouseHoverOnSportAndBookTest() throws InterruptedException {
		homepage.mouseHoverOnSportAndBook();
	}

	@Test(priority = 8)
	public void mouseHoverOnuserNameLabelTest() throws InterruptedException {
		homepage.mouseHoverOnUserNameLabel();
	}

	@Test(priority = 8)
	public void mouseHoverOnMoreTest() throws InterruptedException {
		homepage.mouseHoverOnMoreLabel();
	}

	@Test(priority = 9)
	public void clickOnSearchTextboxTest() {

		searchresultpage = homepage.clickOnSearchTextbox();

	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {

		Constants.driver.quit();
	}
}
