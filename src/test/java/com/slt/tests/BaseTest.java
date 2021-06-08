package com.slt.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.slt.drivers.Driver;

public class BaseTest {

	protected BaseTest() {

	}
	
		
	@BeforeMethod
	protected void setUP() throws Exception {
		Driver.intiDriver();
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}

}
