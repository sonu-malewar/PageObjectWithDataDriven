package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class XLUtility {

	public static String path=System.getProperty("user.dir")+"\\TestData\\TestData.xlsx";
	
	XSSFWorkbook xbook = null;
	XSSFSheet xsheet= null;;
	XSSFRow xrow = null;
	XSSFCell xcell= null;
	public FileInputStream fis = null;

	// method to select value from dropdown ueing select class



	public XLUtility(){

		this.path=path;
		try {
			 fis = new FileInputStream(path); // read the file
			 xbook = new XSSFWorkbook(fis);
			 xsheet = xbook.getSheetAt(0);
			 fis.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public int getRowCount(String sheetname)  {

		

		int xrow = xsheet.getLastRowNum();
		
		return xrow;

	}
	public int getColumnCount(String sheetname,int rownum) throws IOException {

		

		int xcell = xsheet.getRow(rownum).getLastCellNum();
		
		return xcell;

	}

	public String getCellData(String sheetname,int rownum,int cellnum) throws IOException {

			
		XSSFRow row = xsheet.getRow(rownum);

		XSSFCell cell = row.getCell(cellnum);

		DataFormatter formate = new DataFormatter();// Datafarmator is class which returns only String value regardless of any value in cell

		String data;

		try{

			data = formate.formatCellValue(cell);
		}catch(Exception e) {

			data="";
		}


		xbook.close();
		fis.close();
		return data;

	}
}
