package com.atmecs.falcon.testscript;


import org.testng.annotations.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import com.atmecs.falcon.automation.util.parser.PropertyParser;
import com.atmecs.falcon.pages.HomePage;
import com.atmecs.falcon.pages.SignupPage;
import com.atmecs.falcon.testdata.ExcelDataProvider;
import com.atmecs.falcon.testdata.Userdata;
import com.atmecs.falcon.testsuite.SampleTestSuiteBase;


public class SignupTest extends  SampleTestSuiteBase {
	String url = PropertyParser.readEnvOrConfigProperty("url");
	@BeforeMethod
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void initalizeBrowser(String os, String osVersion, String br, String browserVersion) {
	this.os=os;
	this.osVersion = osVersion;
	this.br = br;
	this.browserVersion = browserVersion;
	}
	
	@Test(dataProvider = "DataSheet", dataProviderClass=ExcelDataProvider.class)
	public void testSignUp(Userdata user) {
		
		HomePage homePage = new HomePage(browser);
		SignupPage signupPage = new SignupPage(browser);
		
		homePage.navigateToUrl(url, os, osVersion, br, browserVersion);
		homePage.clickSignupLink();
		signupPage.signUp(user.getUserName(), user.getPassword());
		
		
	}
	@AfterMethod
	public void closeBrowser() {
		browser.closeBrowser();
	}
}
