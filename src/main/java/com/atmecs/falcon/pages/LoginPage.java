package com.atmecs.falcon.pages;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.constant.FilePathConstants;
import com.atmecs.falcon.utils.PropertyReader;


public class LoginPage extends BasePage {
	private ReportLogService report = new ReportLogServiceImpl(LoginPage.class);
	PropertyReader loginPageProperties = new PropertyReader(FilePathConstants.LOGIN_LOCATOR_PATH);
			
	public LoginPage(Browser browser) {
		super(browser);

	}
	public void login(String username, String password) {
		System.out.println("LoginUsername ="+ username);
		System.out.println("LoginPassword ="+ password);
		report.info("Enter UserName To Login");
		browser.getWait().waitForElementPresence(LocatorType.XPATH, loginPageProperties.get("LoginUsername"), 2000);
		browser.getTextField().enterTextField(LocatorType.XPATH, loginPageProperties.get("LoginUsername"), username);
		report.info("Enter Password To Login");
		browser.getWait().waitForElementPresence(LocatorType.XPATH, loginPageProperties.get("LoginPassword"), 2000);
		browser.getTextField().enterTextField(LocatorType.XPATH, loginPageProperties.get("LoginPassword"), password);
		report.info("Click On Login Button");
		browser.getFindFromBrowser().findElementByXpath(loginPageProperties.get("LoginButton")).click();
//		report.info("Getting Alert Message");
//		String alertText = browser.getAlert().getAlertText(2000);
//		report.info("Alert Message = " + alertText);
	}
}
