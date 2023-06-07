package com.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utilities.XLUtility;

public class DataProviders {

	XLUtility obj = new XLUtility();

	@DataProvider(name ="Credentia1")
	public Object[][] getExcelData() throws IOException {
		//Totals rows count
		int rows=obj.getRowCount("Crendential");
		int actRows=rows-1;
		//Total Columns
		int column=obj.getColumnCount("Crendential",1);


		Object[][] data= new Object[actRows][column];

		for(int i=0;i<actRows;i++) {
			for(int j=0; j<column;j++) {
				data[i][j]=obj.getCellData("Crendential", i+2, j);
			}

		}
		return data;
	}


}

