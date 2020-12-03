package com.atmecs.falcon.pages;

import com.atmecs.falcon.automation.ui.selenium.Browser;

public class BasePage {
	Browser browser;
	public BasePage(Browser browser) {
		this.browser = browser;
	}
	public void navigateToUrl(String url, String os, String osVersion, String br, String browserVersion) {
		browser.openURL(url, os, osVersion, br, browserVersion);
		browser.maximizeWindow();
	}
	
}
