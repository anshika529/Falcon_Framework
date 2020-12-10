package com.atmecs.falcon.constant;

import java.io.File;

public class FilePathConstants {
	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;

	public final static String RESOURCES_HOME = USER_HOME + "src" + File.separator + "main" + File.separator
			+ "resources" + File.separator;

	public final static String LOCATOR_HOME = RESOURCES_HOME + "locators" + File.separator;
	public final static String ATMECS_HOME = LOCATOR_HOME + "atmecs" + File.separator;
	public final static String DEMOBLAZE_HOME = LOCATOR_HOME + "demoblaze" + File.separator;
	public final static String EXCEL_HOME = RESOURCES_HOME + "exceldata" + File.separator;

	public final static String LIB_HOME = USER_HOME + "lib" + File.separator;

	// Excel file Path
	
		public final static String EXCEL_DATA_PATH = EXCEL_HOME 
				+ "dataFile.xlsx";
		
		// Page Locators Properties File Path
		
		public final static String HOME_LOCATOR_PATH = DEMOBLAZE_HOME
				+ "HomePageLocators.properties";
		
		public final static String SIGNUP_LOCATOR_PATH = DEMOBLAZE_HOME 
				+ "SignUpPageLocators.properties";
		
		public final static String LOGIN_LOCATOR_PATH = DEMOBLAZE_HOME 
				+ "LoginPageLocators.properties";
		
		public final static String CONTACTUS_LOCATOR_PATH = DEMOBLAZE_HOME 
				+ "ContactUsPageLocators.properties";

}
