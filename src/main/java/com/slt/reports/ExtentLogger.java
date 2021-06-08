package com.slt.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.slt.drivers.DriverManager;
import com.slt.enums.ConfigProperties;
import com.slt.utils.PropertyUtils;
import com.slt.utils.ScreenshotUtils;

public final class ExtentLogger {
	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);

	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);

	}


	public static void pass(String message, boolean isScreenshotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotNeeded ) {
			ExtentManager.getExtentTest()
			.pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}


	public static void fail(String message, boolean isScreenshotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotNeeded ) {
			ExtentManager.getExtentTest()
			.pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}


	public static void skip(String message, boolean isScreenshotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotNeeded ) {
			ExtentManager.getExtentTest()
			.pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}

	
}
