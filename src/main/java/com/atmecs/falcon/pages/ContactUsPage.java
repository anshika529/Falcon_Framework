package com.atmecs.falcon.pages;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.constant.FilePathConstants;
import com.atmecs.falcon.utils.PropertyReader;

public class ContactUsPage extends BasePage {
	private ReportLogService report = new ReportLogServiceImpl(ContactUsPage.class);
	PropertyReader contactUsPageProperties = new PropertyReader(FilePathConstants.CONTACTUS_LOCATOR_PATH);
			
	public ContactUsPage(Browser browser) {
		super(browser);

	}
	public void contactUs(String email, String name, String message) {
		System.out.println("Email ="+ email);
		System.out.println("Name ="+ name);
		System.out.println("Message ="+ message);
		report.info("Enter Data In Email Field");
		browser.getTextField().enterTextField(LocatorType.XPATH, contactUsPageProperties.get("ContactEmail"), email);
		report.info("Enter Data In Name Field");
		browser.getTextField().enterTextField(LocatorType.XPATH, contactUsPageProperties.get("ContactName"), name);
		report.info("Enter Data In Message Field");
		browser.getTextField().enterTextField(LocatorType.XPATH, contactUsPageProperties.get("Message"), message);
		report.info("Click On Send Message Button");
		browser.getFindFromBrowser().findElementByXpath(contactUsPageProperties.get("SendMessageButton")).click();
		report.info("Getting Alert Message");
		String alert = browser.getAlert().getAlertText(2000);
		report.info("Alert Message ="+ alert);
}
}
