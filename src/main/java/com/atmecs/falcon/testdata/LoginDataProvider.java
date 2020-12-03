package com.atmecs.falcon.testdata;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.constant.FilePathConstants;

public class LoginDataProvider {
@DataProvider(name = "LoginSheet")
	
	public static Object[][] getXlsData () {
		XlsReader xlsReader = new XlsReader();
		try {
		xlsReader.setPath(FilePathConstants.EXCEL_DATA_PATH);
		} catch (IOException e) {
		e.printStackTrace();
		}
		String sheetName = "LoginSheet";
		int rowCount = xlsReader.getRowCount(sheetName);
		int colCount = xlsReader.getColumnCount(sheetName);

		System.out.println("rowCount =" + rowCount);
		System.out.println("colCount =" + colCount);

		Object[][] data = new Object[rowCount][1];

		for (int rowIndex = 1; rowIndex < rowCount + 1; rowIndex++) {
			Userdata userdata = new Userdata();
			userdata.setLoginUsername(xlsReader.getCellDataByColumnIndex(sheetName, 0, rowIndex));
			userdata.setLoginPassword(xlsReader.getCellDataByColumnIndex(sheetName, 1, rowIndex));
			data[rowIndex - 1][0] = userdata;
		}
	return data;
}

}
