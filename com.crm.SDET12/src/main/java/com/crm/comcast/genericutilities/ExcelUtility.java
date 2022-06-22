package com.crm.comcast.genericutilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *it is used to fetch the data from the Excel Sheet 
 * @author indir
 *
 */
public class ExcelUtility {
	public String getExcelUtility(String sheet,int row,int i) throws Throwable {
		FileInputStream Fsteam = new FileInputStream(IpathConstants.excelpath);
		Workbook book = WorkbookFactory.create(Fsteam);
		Sheet sheet1 = book.getSheet(sheet);
		Row row1 = sheet1.getRow(row);
		Cell cell1 = row1.getCell(i);
		DataFormatter data=new DataFormatter();
	    String value = data.formatCellValue(cell1);
		return value;
	}
	/**
	 * It is used write the data in too the excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param value
	 * @throws Throwable
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetname,int rownum,int cellnum,String data) throws IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet2 = book.getSheet(sheetname);
		Row row2 = sheet2.getRow(rownum);
		Cell cell2 = row2.createCell(cellnum);
		cell2.setCellValue(data);
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\Excel\\Contact1.xlsx	");
		book.write(fout);
	

	}
}
