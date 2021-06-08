package com.slt.constants;

import com.slt.enums.ConfigProperties;
import com.slt.utils.PropertyUtils;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String RESOURCERPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCERPATH + "/exectables/chromedriver.exe";
	private static final String CONFIGRPATH = RESOURCERPATH + "/config/config.properties";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/";
	private static final String EXCELPATH = RESOURCERPATH+"/excel/testdata.xlsx";
	
	private static String extentReportFilePath = "";
	public static String getExcelPath() {
		return EXCELPATH;
	}

	public static String getExtentReportFilePath() throws Exception  {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}
	
	private static String createReportPath() throws Exception  {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"/index.html";
		}
	}
	
	private static final int  EXPCITLYWAIT = 10;


	public static int getExpcitlyWait() {
		return EXPCITLYWAIT;
	}


	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}


	public static String getConfigrPath() {
		return CONFIGRPATH;
	}
}
