package Utils_Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Data {
	
	
	public static Object[][] Excel_Read(String Sheet_name) throws Throwable {
		
	FileInputStream  Excelfile = new FileInputStream(".\\Excel_Data\\Air_India_Data.xlsx");
	Workbook workbook = new XSSFWorkbook(Excelfile);
	Sheet sheet = workbook.getSheet(Sheet_name);
	
	Object data [][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for (int i=0;i<sheet.getLastRowNum();i++) {
		
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
			
			data[i][k] = sheet.getRow(i+1).getCell(k).toString();
		}
	}
	
	return data;
	
	
	}
	
	
	
	
	
	

}
