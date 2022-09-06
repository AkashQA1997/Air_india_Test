package Test_Case;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base_Class.Base_Class;
import Page_Object.Login_PageObject;
import Page_Object.Sign_up_now_PageObject;
import Utils_Excel.Excel_Data;

public class Sign_up_now_Test extends Base_Class {
	
	public static Sign_up_now_PageObject SignUp_Obj;
	public static Login_PageObject Login_Obj;
	
	
@Parameters("Browser")	
@BeforeMethod
   public void Initialization_SignUp(String Browser) throws Throwable {
	  Intialization(Browser);
	  SignUp_Obj = new Sign_up_now_PageObject();
	  Login_Obj = new Login_PageObject();
	
}
	
@DataProvider(name = "SignUp_Data")
   
   public Object[][] SignUp_Data() throws Throwable{
	
	  Object data[][] = Excel_Data.Excel_Read("Sign_Up_Data");
	  return data;
			
	
}
	

@Test(priority = 1, dataProvider = "SignUp_Data")
   public void SingUp_Email_Test(String Email,String New_Password,String Confirm_Password,String Given_Name,
		   String Surname,String Day,String Month,String Year,String Valid) throws InterruptedException {
	 
	  SignUp_Obj.EmailVerify_Field(Email, New_Password, Confirm_Password, Given_Name, Surname, Day, Month, Year, Valid);
	
	
	
	
}

@Test(priority = 2, dataProvider = "SignUp_Data")


   public void SingUp_Password_Test(String Email,String New_Password,String Confirm_Password,String Given_Name,
		   String Surname,String Day,String Month,String Year,String Valid) throws InterruptedException {
	 
	  SignUp_Obj.PasswordVerify_Field(Email, New_Password, Confirm_Password, Given_Name, Surname, Day, Month, Year, Valid);
	

}



@AfterMethod 
    public void 
       tearDwon() {
       driver.quit(); 
}
 
 

	

}
