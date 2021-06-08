package com.slt.pages;

import org.openqa.selenium.By;

import com.slt.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage {
	
	
	private final By textboxUsername = By.id("txtUsername");
	private final By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
	private final By buttonLogin = By.id("btnLogin");
	
	
	public OrangeHRMLoginPage enterUserName(String username) {
		sendKeys(textboxUsername, username , WaitStrategy.PRESENCE, "username");
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textboxPassword, password, WaitStrategy.PRESENCE, "password");
		return this;
	}
	
	public OrangeHRMHomePage clickLogin() {
		click(buttonLogin, WaitStrategy.CLICKABLE, "Login button");
		return new OrangeHRMHomePage();
	}
	
	public String getTitle() {
		return getPageTitle();
		
	}
	
	
	
}
