package com.qa.flipkart.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.flipkart.base.BaseClass;

public class Utility extends BaseClass {
	
	
public void mouseHover(WebDriver driver, WebElement ele)
{
	Actions actions= new Actions(driver);
	actions.moveToElement(ele).build().perform();
}
	
	
	
	
	
}
