package com.atmecs.falcon.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	Properties properties;
	public PropertyReader (String filePath) {
		properties = new Properties();
		try {
			properties.load(new FileInputStream (new File(filePath)));
		}catch (FileNotFoundException e ) {
			System.out.println("File not found in the given location" + e.getMessage());
		}catch (IOException e) {
			System.out.println("Input Output Exception" + e.getMessage());
		}		
	}
	
	public String get(String key) {
		return properties.getProperty(key);
	}
}
