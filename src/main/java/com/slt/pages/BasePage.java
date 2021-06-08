package com.slt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.slt.drivers.DriverManager;
import com.slt.enums.WaitStrategy;
import com.slt.factories.ExplicitWaitFactory;
import com.slt.reports.ExtentLogger;

public class BasePage {
	
	protected void click(By by , WaitStrategy waitstrategy ,String elementname) {
		
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.click();
		try {
			ExtentLogger.pass(elementname +" is Clicked", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void sendKeys(By by, String value, WaitStrategy waitstrategy ,String elementname) 
	{
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.sendKeys(value);
		try {
			ExtentLogger.pass(value + "is enterd succeefully in "+ elementname, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
		
	}
	
}
