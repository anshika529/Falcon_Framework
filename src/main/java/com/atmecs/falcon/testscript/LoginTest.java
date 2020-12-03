package com.atmecs.falcon.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.parser.PropertyParser;
import com.atmecs.falcon.pages.HomePage;
import com.atmecs.falcon.pages.LoginPage;
import com.atmecs.falcon.testdata.LoginDataProvider;
import com.atmecs.falcon.testdata.Userdata;
import com.atmecs.falcon.testsuite.SampleTestSuiteBase;


public class LoginTest extends SampleTestSuiteBase {
String url = PropertyParser.readEnvOrConfigProperty("url");
	
	@BeforeMethod
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	
	public void initBrowser(String os,String osVersion,String br, String browserVersion) {
		this.os = os;
		this.osVersion = osVersion;
		this.br = br;
		this.browserVersion = browserVersion;
		}
	
@Test(dataProvider = "LoginSheet",dataProviderClass = LoginDataProvider.class)
	
	public void testLogin(Userdata user) {
		
		HomePage homePage = new HomePage(browser);
		LoginPage loginPage = new LoginPage(browser);
		
		homePage.navigateToUrl(url, os, osVersion, br, browserVersion);
		homePage.clickLoginLink();
		loginPage.login(user.getLoginUsername(), user.getLoginPassword());
	}
}
