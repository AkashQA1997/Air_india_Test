package Utils_Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestName_Excel {
	
	
	public static  List<Map<String, String>> Data(String Sheet_Name) throws IOException  {

		FileInputStream Excelfile = null;
		try {
			Excelfile = new FileInputStream(".\\Excel_Data\\Test_run.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//@SuppressWarnings("resource")
		XSSFWorkbook workBook = new XSSFWorkbook(Excelfile);

		XSSFSheet sheet = workBook.getSheet(Sheet_Name);
		List <Map<String,String>> list = new ArrayList<>();;
		Map<String, String> map = null;

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			map = new HashMap<>();
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				map.put(sheet.getRow(0).getCell(k).toString(), sheet.getRow(i+1).getCell(k).toString());
				
			}
			list.add(map);

		}
		return list;
		
	}
	
	

}
