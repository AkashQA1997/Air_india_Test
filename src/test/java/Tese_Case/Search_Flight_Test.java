package Tese_Case;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base_Class.Base_Class;
import Page_Object.Search_flight_PageObject;

public class Search_Flight_Test extends Base_Class {
	
	public Search_flight_PageObject SearchFlight;
	
@Parameters("Browser")	
@BeforeMethod
 public void initial(String Browser) throws Throwable {
	Intialization("Chrome");
	SearchFlight = new Search_flight_PageObject();
	
	
}

@Test
 public void Tc_1() {
	SearchFlight.Search_Flight();
	
	
}



	

}
