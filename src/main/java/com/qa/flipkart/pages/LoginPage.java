package com.qa.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.base.BaseClass;
import com.qa.flipkart.keywords.Constants;

/**
 * @author Shivam
 *
 */
public class LoginPage extends BaseClass {

	@FindBy(xpath = "//input[@class='_2zrpKA _1dBPDZ']")
	WebElement mobileno;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement loginButton;

	@FindBy(xpath = "//span[@class='ZAtlA-']/span")

	WebElement erroeMessage;

	@FindBy(xpath = "//div[contains(text(),'Nisha')]")
	WebElement homepageUsername;

	public LoginPage() {
		PageFactory.initElements(Constants.driver, this);
	}

	public HomePage login(String mobNo, String pwd) {

		System.out.println("Enter UserName as : " + mobNo);
		mobileno.sendKeys(mobNo);

		System.out.println("Enter password as : " + pwd);
		password.sendKeys(pwd);

		System.out.println("click on login button");
		loginButton.click();

		return (HomePage) homepageUsername;

	}

	public boolean verifyInvalidInput(String mobNo, String pwd) {

		System.out.println("Enter UserName as : " + mobNo);
		mobileno.sendKeys(mobNo);

		System.out.println("Enter password as : " + pwd);
		password.sendKeys(pwd);

		System.out.println("click on login button");
		loginButton.click();

		if (erroeMessage.isDisplayed()) {
			System.out.println("****" + erroeMessage.getText() + "****");
		}
		return erroeMessage.isDisplayed();
		// Assert.assertTrue((erroeMessage).isDisplayed(), "wrong Mobile No and Password
		// error Message is not displayed ");

	}

}
