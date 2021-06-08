package com.slt.pages;

import org.openqa.selenium.By;

import com.slt.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage{

	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[text()='Logout']");

	public OrangeHRMHomePage clickWelcome() {
		click(linkWelcome, WaitStrategy.PRESENCE, "Welcome link" );
		return this;
	}

	public OrangeHRMLoginPage clickLogout() {
		
		click(linkLogout, WaitStrategy.CLICKABLE, "Logot button");
		return new OrangeHRMLoginPage();
	}
	
	
}
