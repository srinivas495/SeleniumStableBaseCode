package com.slt.drivers;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import com.slt.constants.FrameworkConstants;
import com.slt.enums.ConfigProperties;
import com.slt.utils.PropertyUtils;


public final class Driver {

	private Driver() {

	}

	public static void intiDriver() throws Exception 
	{
		if(Objects.isNull(DriverManager.getDriver())) {
			System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromeDriverPath());
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
	}

	public static void quitDriver() 
	{
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
