package com.atmecs.falcon.testdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.constant.FilePathConstants;

public class ExcelDataProvider {

	@DataProvider(name = "DataSheet")
	
	public static Object[][] getXlsData () {
		XlsReader xlsReader = new XlsReader();
		try {
		xlsReader.setPath(FilePathConstants.EXCEL_DATA_PATH);
		} catch (IOException e) {
		e.printStackTrace();
		}
		String sheetName = "DataSheet";
		int rowCount = xlsReader.getRowCount(sheetName);
		int colCount = xlsReader.getColumnCount(sheetName);

		System.out.println("rowCount =" + rowCount);
		System.out.println("colCount =" + colCount);

		Object[][] data = new Object[rowCount][1];

		for (int rowIndex = 1; rowIndex < rowCount + 1; rowIndex++) {
			Userdata user = new Userdata();
			user.setUserName(xlsReader.getCellDataByColumnIndex(sheetName, 0, rowIndex));
			user.setPassword(xlsReader.getCellDataByColumnIndex(sheetName, 1, rowIndex));
			data[rowIndex - 1][0] = user;
		}
		return data;

	}
	
//	@DataProvider(name = "DataSheet")
//	
//	public static Object[][] getXlsData () {
//		XlsReader xlsReader = new XlsReader();
//		try {
//		xlsReader.setPath(FilePathConstants.EXCEL_DATA_PATH);
//		} catch (IOException e) {
//		e.printStackTrace();
//		}
//		String sheetName = "DataSheet";
//		int rowCount = xlsReader.getRowCount(sheetName);
//		int colCount = xlsReader.getColumnCount(sheetName);
//
//		System.out.println("rowCount =" + rowCount);
//		System.out.println("colCount =" + colCount);
//
//		Object[][] data = new Object[rowCount][colCount];
//
//		for (int rowIndex = 1; rowIndex < rowCount + 1; rowIndex++) {
//		for (int columnIndex = 0; columnIndex < colCount; columnIndex++) {
//		String value = xlsReader.getCellDataByColumnIndex(sheetName, columnIndex, rowIndex);
//		data[rowIndex - 1][columnIndex] = value;
//		}
//
//		}
//		return data;
//
//	}
}
