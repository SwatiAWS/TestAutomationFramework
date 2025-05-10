package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;

public class readXLSdata {
//	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		readXLSdata testdata = new readXLSdata();
//		testdata.getData("login2"); //give excel sheet name
// 	}
	//utility to get data, excelSheetName to get the test data excel sheet 
	//along with the tab where data is present
	@DataProvider(name="testDataTab")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		String excelSheetName=m.getName();
		//Get location of test data file, create instance of the file
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\testdata.XLSX");
		//Pass reference of the test data file, create input stream
		FileInputStream fis = new FileInputStream(file);
		//Read the workbook, and go to the sheet
		Workbook wb = WorkbookFactory.create(fis);
		//Read data from sheet
		Sheet sheetName = wb.getSheet(excelSheetName);
		//Get number of data rows and columns dynamically
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		//Get the column count by getting the cells that are there in the row
		Row rowCells = sheetName.getRow(0);
		int totalColumns = rowCells.getLastCellNum();
		System.out.println(totalColumns);
		//Format the data
		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRows][totalColumns];
		//nested loop for iterating through the row then through the columns
		//start from 2nd row as 1st row is title
		//column starts with 1st column
		for(int i=1; i<=totalRows; i++) {
			for(int j=0; j<totalColumns; j++) {
				testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
			}
		}
		return testData;
	}
}
