package com.slt.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.slt.constants.FrameworkConstants;
public final class ExtentReport {
	
	private ExtentReport ()	{}
	
	private static ExtentReports extent;
	public static ExtentTest test;	
	
	public static void initReports() throws Exception 
	{
		if(Objects.isNull(extent)) 
		{
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Srinivas Demo Project Reports");
		spark.config().setReportName("Demo Project report");
		}
	}
	
	public static void flushReports() throws Exception {
		if(Objects.nonNull(extent)) 
		{
			extent.flush();
		}
		    
		// Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI()); 
	}
	
	public static void createTest(String testcasename) 
	{
		ExtentManager.setExtentTest(extent.createTest(testcasename));
	}
	
}
