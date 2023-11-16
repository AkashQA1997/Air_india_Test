package Test_Case;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base_Class.Base_Class;
import Page_Object.Flight_Status_PageObject;
import Utils_Excel.Excel_Data;

public class Flight_Status_Test extends Base_Class {
public static Flight_Status_PageObject FlightStatus_Obj;
public static Excel_Data FlightStatusXlx;

@Parameters("Browser")
@BeforeMethod
 public void Intialization_Flight_Status(String Browser) throws Throwable {
    		
	 Intialization(Browser);
	 FlightStatus_Obj = new Flight_Status_PageObject();
	 FlightStatusXlx = new Excel_Data();
	
 }

@DataProvider(name = "Fligh_Status_Data")

 public Object[] FlightStatusData() throws Throwable{
	Object obj[] =  Excel_Data.Excel_Read("Flight_Status");
	return obj;
}



@Test (priority = 1, dataProvider = "Fligh_Status_Data")
public void TC_1_Flight_Status_Test(Map<String, String> map) {
	
	FlightStatus_Obj.Fligh_Status_Check(map);
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
}
