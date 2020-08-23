package com.shopping.flipkart.testcases;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadExceldata {
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String xlFilePath;

	public ReadExceldata(String xlFilePath) throws Exception {
		this.xlFilePath = xlFilePath;
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();

	}

	public int getRowCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() + 1;
		return rowCount;
	}

	public int getColumnCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		return colCount;
	}

	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {

				BigDecimal val = new BigDecimal(cell.getNumericCellValue());

				String cellValue = String.valueOf(val);
				return cellValue;
			} else if (HSSFDateUtil.isCellDateFormatted(cell)) {
				DateFormat df = new SimpleDateFormat("dd/MM/yy");
				Date date = cell.getDateCellValue();
				String cellValue = df.format(date);
				return cellValue;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in Excel";
		}
	}

	public static void main(String args[]) throws Exception {
		FileInputStream fis = new FileInputStream("D:\\Selenium WebDriver\\AMLOCK\\Testdata.xlsx");

	}
}
