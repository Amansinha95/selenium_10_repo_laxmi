package com.qspiders.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @author Rajlaxmi
 */
public class ExcelUtility {
	/**
	 * This method will read String data from Excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param columnIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
public String getStringDataFromExcel(String sheetName,int rowIndex,int columnIndex) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./src/test/resource/TestData/TestScript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	return wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getStringCellValue();
}
/**
 * This method will read Number data from Excel file
 * @param sheetName
 * @param rowIndex
 * @param columnIndex
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public double getNumberDataFromExcel(String sheetName,int rowIndex,int columnIndex) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./src/test/resource/TestData/TestScript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	return wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getNumericCellValue();
}
/**
 * This method will read Boolean data from Excel file
 * @param sheetName
 * @param rowIndex
 * @param columnIndex
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public boolean getBooleanDataFromExcel(String sheetName,int rowIndex,int columnIndex) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./src/test/resource/TestData/TestScript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	return wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getBooleanCellValue();
	
}
/**
 * This method will read Date and Time from Excel file
 * @param sheetName
 * @param rowIndex
 * @param columnIndex
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public LocalDateTime getLocalDateAndTimeFromExcel(String sheetName,int rowIndex,int columnIndex) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./src/test/resource/TestData/TestScript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	return wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getLocalDateTimeCellValue();
}
}

