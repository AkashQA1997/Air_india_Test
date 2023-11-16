package Utils_Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Data {


	public static Object[] Excel_Read(String Sheet_name) throws Throwable {

		


		FileInputStream Excelfile = null;
		try {
			Excelfile = new FileInputStream(".\\\\Excel_Data\\\\Air_India_Data.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//@SuppressWarnings("resource")
		XSSFWorkbook workBook = new XSSFWorkbook(Excelfile);

		XSSFSheet sheet = workBook.getSheet(Sheet_name);
		Object[] data = new Object[sheet.getLastRowNum()];
		Map<Object,Object> map;

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			map = new HashMap<>();
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				map.put(sheet.getRow(0).getCell(k).toString(), sheet.getRow(i+1).getCell(k).toString());
				data[i] = map;
			}

		}
		return data;
	}


}








