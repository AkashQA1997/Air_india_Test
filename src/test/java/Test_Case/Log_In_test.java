package Test_Case;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import Base_Class.Base_Class;
import Page_Object.Login_PageObject;
import Utils_Excel.Excel_Data;

public class Log_In_test extends Base_Class {
	public Login_PageObject Login_object;
	private String Status = "failed";


	@Parameters("Browser")	
	@BeforeMethod
	public void Intial_Sign_In_test(String Browser) throws Throwable {
		Intialization(Browser);
		Login_object = new Login_PageObject();



	}

	@Test(priority =1, dataProvider = "LoginData")

	public void TC_1_Login_Test(String Login_ID, String Password, String Valid ) throws InterruptedException {
		Login_object.Signin_Check( Login_ID, Password , Valid );
		//Status = "passed";

	}
	@Test(priority =2, dataProvider = "LoginData")
	public void TC_2_Login_Test(String Login_ID, String Password, String Valid ) throws InterruptedException {
		Login_object.Signin_Check( Login_ID, Password , Valid );
		//Status = "passed";

	}

	@DataProvider (name = "LoginData")
	public Object[][] XlsData() throws Throwable {

		Object data[][] = Excel_Data.Excel_Read("Login_sheet");
		return data;

	}


	@AfterMethod
	public void TearDown() {
		//((JavascriptExecutor) driver).executeScript("lambda-status=" + Status);

		driver.quit();
	}



}


