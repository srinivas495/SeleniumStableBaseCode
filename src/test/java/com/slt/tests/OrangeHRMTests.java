package com.slt.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.slt.pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTest {
	
	public OrangeHRMTests() {

	}
	
	@Test(dataProvider = "LoginTestDataProvider")
	public void loginLogoutTests(String userName, String password ) {
		
				
		String title = new OrangeHRMLoginPage().enterUserName(userName).enterPassword(password).clickLogin()
				.clickWelcome().clickLogout()
				.getTitle();
		
		Assertions.assertThat(title)
				.isEqualTo("OrangeHRM");
	}
	
		public void newTest(String userName, String password ) {
			
			
			String title = new OrangeHRMLoginPage().enterUserName(userName).enterPassword(password).clickLogin()
					.clickWelcome().clickLogout()
					.getTitle();
			
			Assertions.assertThat(title)
					.isEqualTo("OrangeHRM");
				
	}
	
	@DataProvider(name = "LoginTestDataProvider" , parallel = true)
	public Object[][] getData(){
		
		return new Object[][] {
			{"Admin", "admin123"},
			{"Admin", "admin123"} 
		};
		
	}
	
}
