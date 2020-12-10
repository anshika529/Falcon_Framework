package com.atmecs.falcon.testscript;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.parser.PropertyParser;
import com.atmecs.falcon.pages.ContactUsPage;
import com.atmecs.falcon.pages.HomePage;
import com.atmecs.falcon.testdata.ContactUsDataProvider;
import com.atmecs.falcon.testdata.Userdata;
import com.atmecs.falcon.testsuite.SampleTestSuiteBase;

public class ContactUsTest  extends SampleTestSuiteBase {
String url = PropertyParser.readEnvOrConfigProperty("url");
	
	@BeforeMethod
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	
	public void initBrowser(String os,String osVersion,String br, String browserVersion) {
		this.os = os;
		this.osVersion = osVersion;
		this.br = br;
		this.browserVersion = browserVersion;
		}
	
	@Test(dataProvider = "ContactUsDataSheet",dataProviderClass = ContactUsDataProvider.class)
	
	public void testLogin(Userdata user) {
		
		HomePage homePage = new HomePage(browser);
		ContactUsPage contactUsPage = new ContactUsPage(browser);
		
		homePage.navigateToUrl(url, os, osVersion, br, browserVersion);
		homePage.clickContactUsLink();
		contactUsPage.contactUs(user.getEmail(), user.getName(), user.getMessage());
	}
	@AfterMethod
	public void closeBrowser() {
		browser.closeBrowser();
}

}
