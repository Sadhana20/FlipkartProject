package com.qa.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//input[@class='_2zrpKA _1dBPDZ']")
	WebElement mobileno;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String mobNo, String pwd) {
		mobileno.sendKeys(mobNo);
		password.sendKeys(pwd);
		loginButton.click();
		System.out.println("Login SuccessFully");
		return new HomePage();
	}

	public void verifyInvalidMobNo(String actualMobNo, String pwd) {
		actualMobNo = "8788964270";
		String expectedMobNo = prop.getProperty("mobileno");
		if (actualMobNo.equals(expectedMobNo)) {
			mobileno.sendKeys(actualMobNo);
			password.sendKeys(pwd);
			loginButton.click();
		} else {
			System.out.println("Please Enter valid Mobile No");
		}

	}

	public void verifyInvalidPassword(String mobNo, String actualpwd) {
		actualpwd = "Harsh0107#";
		String expectedPassword = prop.getProperty("password");
		if (actualpwd.equals(expectedPassword)) {
			mobileno.sendKeys(mobNo);
			password.sendKeys(actualpwd);
			loginButton.click();
		} else {
			System.out.println("Please Enter valid Password");
		}

	}

	public void verifyInvalidMobNoAndPassword(String actualMobNo, String actualpwd) {
		actualMobNo = "8788964270";
		actualpwd = "Harsh0107#";
		String expectedMobNo = prop.getProperty("mobileno");
		String expectedPassword = prop.getProperty("password");
		if (actualMobNo.equals(expectedMobNo) && actualpwd.equals(expectedPassword)) {
			mobileno.sendKeys(actualMobNo);
			password.sendKeys(actualpwd);
			loginButton.click();
		} else {
			System.out.println("Please Enter valid Mobile No & Password");
		}

	}

}
