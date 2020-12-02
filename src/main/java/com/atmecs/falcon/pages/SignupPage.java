package com.atmecs.falcon.pages;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.constant.FilePathConstants;
import com.atmecs.falcon.utils.PropertyReader;



public class SignupPage extends BasePage{
	private ReportLogService report = new ReportLogServiceImpl(HomePage.class);
	PropertyReader signupPageProperties = new PropertyReader(FilePathConstants.SIGNUP_LOCATOR_PATH);

	public SignupPage(Browser browser) {
		super(browser);
	
	}
	public void signUp(String username, String password) {
		System.out.println("UserName ="+ username);
		System.out.println("Password ="+ password);
		report.info("Insert Username to Signup");
		browser.getWait().waitForElementPresence(LocatorType.XPATH, signupPageProperties.get("SignupUsername"),5000);
		browser.getTextField().enterTextField(LocatorType.XPATH, signupPageProperties.get("SignupUsername"), username);
		report.info("Insert Password to Signup");
		browser.getTextField().enterTextField(LocatorType.XPATH, signupPageProperties.get("SignupPassword"), password);
		report.info("Click On SignUp Button");
		browser.getFindFromBrowser().findElementByXpath(signupPageProperties.get("SignupButton")).click();
		report.info("Getting Alert Message");
		String alertText = browser.getAlert().getAlertText(2000);
		report.info("Alert Message = " + alertText);
		
	}
}
