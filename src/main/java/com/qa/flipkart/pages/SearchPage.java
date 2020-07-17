package com.qa.flipkart.pages;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.qa.flipkart.base.BaseClass;
import com.qa.flipkart.utility.Utility;

public class SearchPage extends BaseClass {

	Utility util = new Utility();

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement searchButton;


	@FindBy(xpath = "//button[@class='vh79eN']")
	WebElement searchIcon;

	@FindBy(xpath = "//input[@type='text']")
	WebElement searchTextbox;

	/*
	 * @FindBy(xpath =
	 * "//li[@class='_1va75j']/parent::ul[@class='col-12-12 _1PBbw8']") WebElement
	 * autoSuggest;
	 */

	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	public Boolean searchButtonIsDisplayed() {
		return searchIcon.isDisplayed();
	}

	public Boolean searchButtonIsEnabled() {
		return searchButton.isEnabled();
	}
	
	public Boolean verifySearchTextboxDisplay() {
		return searchTextbox.isDisplayed();
	}

	public Boolean verifySearchTextboxEnable() {
		return searchTextbox.isEnabled();

	}


	public SearchResultPage verifyAutoSuggest() throws InterruptedException {
		searchTextbox.sendKeys("Men");
		Thread.sleep(3000);
		
		List<WebElement> suggesion = driver.findElements(By.xpath("//div[contains(text(),'men')]"));

		System.out.println("Auto Suggest List ::" + suggesion.size());

		
		for (WebElement suggest : suggesion) {
			//System.out.println(suggest.getText());
			
			if (suggest.getText().contains("mens shoes")) {
				suggest.click();
				Thread.sleep(3000);

				break;

			}
		}
		return new SearchResultPage();
		 
	}

}

