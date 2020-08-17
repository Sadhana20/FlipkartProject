package com.qa.flipkart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.qa.flipkart.keywords.Constants;
import com.qa.flipkart.keywords.Keywords;

public class BaseClass {

	// Actions action =new Actions(driver);

	public BaseClass() {
		try {
			Constants.prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\monika hase\\FlipkartProject\\FlipkartProject\\src\\main\\java\\com\\qa\\flipkart\\config\\config.properties");
			Constants.prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		Keywords.launchBrowser("Chrome");
		Constants.driver.manage().window().maximize();
		Constants.driver.manage().deleteAllCookies();
		Constants.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Constants.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		Constants.driver.get(Constants.prop.getProperty("url"));
	}

}
