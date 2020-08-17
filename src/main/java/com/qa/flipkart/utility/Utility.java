package com.qa.flipkart.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.qa.flipkart.base.BaseClass;
import com.qa.flipkart.keywords.Constants;

public class Utility extends BaseClass {

	public void mouseHover(WebDriver driver, WebElement ele) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).build().perform();
	}

	public void implicitWait() {
		Constants.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void waitToSendkeys(WebDriver driver, WebElement element, String value) {
		FluentWait wait = new FluentWait(Constants.driver);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public static void waitToElementDisplay(WebDriver driver, WebElement element) {
		FluentWait wait = new FluentWait(driver);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitToClickOn(WebDriver driver, WebElement element, int timeout) {
		FluentWait wait = new FluentWait(driver);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}
