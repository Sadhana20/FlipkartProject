package com.qa.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.base.BaseClass;
import com.qa.flipkart.keywords.Constants;

public class CartPage extends BaseClass {

	// page factory-object repository

	@FindBy(xpath = "//a[@class='_3ko_Ud']")
	WebElement cartLink;

	@FindBy(xpath = "//button[@class=\"_2AkmmA iwYpF9 _7UHT_c\"]")
	WebElement placeOrderBtn;

	@FindBy(xpath = "//button[@class='_2AkmmA _2Z-ax5 _1eFTEo']")
	WebElement shopnowBtn;

	public CartPage() {
		PageFactory.initElements(Constants.driver, this);
	}

	public String validateCartTitle() {
		return Constants.driver.getTitle();

	}

	public void clickOnCartLink() {
		cartLink.click();
	}

	public boolean validateShopnowBtn() {
		return shopnowBtn.isEnabled();
	}
}
