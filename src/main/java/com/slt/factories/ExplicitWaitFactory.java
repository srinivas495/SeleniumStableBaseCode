package com.slt.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.slt.constants.FrameworkConstants;
import com.slt.drivers.DriverManager;
import com.slt.enums.WaitStrategy;

public class ExplicitWaitFactory {

	public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) 
	{
		WebElement element = null;
		if(waitstrategy == WaitStrategy.CLICKABLE) 
		{
			element =new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExpcitlyWait())
					.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if (waitstrategy == WaitStrategy.PRESENCE) 
		{
			element =new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExpcitlyWait())
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}


		else if (waitstrategy == WaitStrategy.VISIBLE) 
		{
			new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExpcitlyWait())
			.until(ExpectedConditions.presenceOfElementLocated(by));
		}

		else if (waitstrategy == WaitStrategy.NONE) 
		{
			element = DriverManager.getDriver().findElement(by);
		}
		return element;


	}
}
