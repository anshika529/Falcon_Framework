package com.atmecs.falcon.testdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.constant.FilePathConstants;

public class ContactUsDataProvider {
@DataProvider(name = "ContactUsDataSheet")
	
	public static Object[][] getXlsData () {
		XlsReader xlsReader = new XlsReader();
		try {
		xlsReader.setPath(FilePathConstants.EXCEL_DATA_PATH);
		} catch (IOException e) {
		e.printStackTrace();
		}
		String sheetName = "ContactUsDataSheet";
		int rowCount = xlsReader.getRowCount(sheetName);
		int colCount = xlsReader.getColumnCount(sheetName);

		System.out.println("rowCount =" + rowCount);
		System.out.println("colCount =" + colCount);

		Object[][] data = new Object[rowCount][1];

		for (int rowIndex = 1; rowIndex < rowCount + 1; rowIndex++) {
			Userdata user = new Userdata();
			user.setEmail(xlsReader.getCellDataByColumnIndex(sheetName, 0, rowIndex));
			user.setName(xlsReader.getCellDataByColumnIndex(sheetName, 1, rowIndex));
			user.setMessage(xlsReader.getCellDataByColumnIndex(sheetName, 2, rowIndex));
			data[rowIndex - 1][0] = user;
		}
		return data;


}
}
