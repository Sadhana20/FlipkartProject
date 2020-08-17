package com.qa.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.flipkart.base.BaseClass;
import com.qa.flipkart.keywords.Constants;
import com.qa.flipkart.utility.Utility;

public class HomePage extends BaseClass {

	Utility util = new Utility();
	Actions actions;

	@FindBy(xpath = "//img[@class='_1e_EAo']")
	WebElement flipkartLogo;

	@FindBy(xpath = "//input[@type=\"text\"]")
	WebElement searchTextbox;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement searchButton;

	@FindBy(xpath = "//input[@title='Search for products, brands and more']")
	WebElement textboxLabel;

	@FindBy(xpath = "//span[@class='_1QZ6fC _3Lgyp8' and contains(text(),'Electronics')]")
	WebElement electronicsLabel;
	@FindBy(xpath = "//a[@title='Mobiles']")
	WebElement mobileTitle;

	@FindBy(xpath = "//*[contains(text(), 'TVs & Appliances')]")
	WebElement tvnandAppliancesLabel;
	@FindBy(xpath = "//a[@title='Microwave Ovens']")
	WebElement microwaveOvens;

	@FindBy(xpath = "//span[@class='_1QZ6fC _3Lgyp8' and contains(text(),'Men')]")
	WebElement menLabel;

	@FindBy(xpath = "//span[@class='_1QZ6fC _3Lgyp8' and contains(text(),'Women')]")
	WebElement womenLabel;

	@FindBy(xpath = "//span[@class='_1QZ6fC _3Lgyp8' and contains(text(),'Baby & Kids')]")
	WebElement babyandKidLabel;

	@FindBy(xpath = "//span[@class='_1QZ6fC _3Lgyp8' and contains(text(),'Home & Furniture')]")
	WebElement homeAndFurnitureLabel;

	@FindBy(xpath = "//span[@class='_1QZ6fC _3Lgyp8' and contains(text(),'Sports, Books & More')]")
	WebElement sportAndBookLabel;

	@FindBy(xpath = "//div[@class='_2aUbKa']")
	WebElement userNameLabel;

	@FindBy(xpath = "//div[(text()='More')]")
	WebElement moreLabel;

	public HomePage() {
		PageFactory.initElements(Constants.driver, this);
	}

	public String verifyHomepageTitle() {
		return Constants.driver.getTitle();

	}

	public String verifyTextboxLabel() {
		String label = textboxLabel.getAttribute("title");
		return label;

	}

	public boolean flipkartLogoIsDisplayed() {

		Boolean flag;
		// return flipkartLogo.isDisplayed();

		try {
			return flipkartLogo.isDisplayed();
		} catch (StaleElementReferenceException e) {
			WebElement logo = Constants.driver.findElement(By.xpath("//img[@class='_1e_EAo']"));
			flag = logo.isDisplayed();

		}
		return flag;
	}

	public void mouseHoverOnTVnandAppliances() throws InterruptedException {
		util.mouseHover(Constants.driver, tvnandAppliancesLabel);
		Assert.assertTrue(microwaveOvens.isDisplayed(), "Mouse not Hower on Microwave Ovens ");
		Thread.sleep(2000);

	}

	public void mouseHoverOnElectronics() throws InterruptedException {
		util.mouseHover(Constants.driver, electronicsLabel);
		Assert.assertTrue(mobileTitle.isDisplayed(), "Mouse not Hower on Electronics Label");
		Thread.sleep(2000);

	}

	public void mouseHoverOnMen() throws InterruptedException {
		util.mouseHover(Constants.driver, menLabel);
		Thread.sleep(2000);

	}

	public void mouseHoverOnWomen() throws InterruptedException {
		util.mouseHover(Constants.driver, womenLabel);

		Thread.sleep(3000);

	}

	public void mouseHoverOnBabyAndKid() throws InterruptedException {
		util.mouseHover(Constants.driver, babyandKidLabel);
		// Assert.assertTrue(mobileTitle.isDisplayed(), "Mouse not Hower on Electronics
		// Label");
		Thread.sleep(2000);
	}

	public void mouseHoverOnHomeandFurniture() throws InterruptedException {
		util.mouseHover(Constants.driver, homeAndFurnitureLabel);
		// Assert.assertTrue(mobileTitle.isDisplayed(), "Mouse not Hower on Electronics
		// Label");
		Thread.sleep(2000);
	}

	public void mouseHoverOnSportAndBook() throws InterruptedException {
		util.mouseHover(Constants.driver, sportAndBookLabel);
		// Assert.assertTrue(mobileTitle.isDisplayed(), "Mouse not Hower on Electronics
		// Label");
		Thread.sleep(2000);

	}

	public void mouseHoverOnUserNameLabel() throws InterruptedException {
		util.mouseHover(Constants.driver, userNameLabel);
		// Assert.assertTrue(mobileTitle.isDisplayed(), "Mouse not Hower on Electronics
		// Label");
		Thread.sleep(2000);

	}

	public void mouseHoverOnMoreLabel() throws InterruptedException {
		util.mouseHover(Constants.driver, moreLabel);
		Assert.assertTrue(mobileTitle.isDisplayed(), "Mouse not Hower on Electronics Label");
		Thread.sleep(2000);

	}

	public SearchResultPage clickOnSearchTextbox() {

		searchTextbox.sendKeys("samsung");
		try {
			searchButton.click();
		} catch (StaleElementReferenceException e) {
			WebElement searchButton1 = Constants.driver.findElement(By.xpath("//button[@type=\"submit\"]"));
			searchButton1.click();

		}
		return new SearchResultPage();

	}

}
