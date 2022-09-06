package Page_Object;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base_Class.Base_Class;

public class Sign_up_now_PageObject extends Base_Class {
	
	
	@FindBy (xpath ="//a[text()=' Login']")
	WebElement Login_button;
	
	@FindBy (css ="a#createAccount")
	WebElement Sign_up_now_button;
	
	@FindBy (xpath ="//button[text()='Send verification code']")
	WebElement SendVerification_button;
	
	@FindBy (css ="input#email")
	WebElement Email_Address_Field;
	
	@FindBy (css ="input#newPassword")
	WebElement New_Password_Field;
	
	@FindBy (css ="input#reenterPassword")
	WebElement Confirm_New_Password_Field;
	
	@FindBy (css ="input#givenName")
	WebElement Given_Name_Field;
	
	@FindBy (css ="input#surname")
	WebElement Surname_Field;
	
	@FindBy (css ="#extension_birthdate_day")
	WebElement Day_List;
	
	@FindBy (css ="#extension_birthdate_month")
	WebElement Month_List;
	
	@FindBy (css ="#extension_birthdate_year")
	WebElement Year_List;
	
	@FindBy (xpath ="//button[text()='Create']")
	WebElement Create_Button;
	
	@FindBy (xpath ="//button[@id='cancel']")
	WebElement Cancel_Button;
	
	@FindBy (xpath ="//div[contains(text(),'Verification code has been ')]")
	WebElement Verification_Message;
	
	@FindBy (xpath ="//div[contains(text(),'enter a valid email address.')]")
	WebElement Valid_Email_Alert;
	
	@FindBy (css ="div#passwordEntryMismatch")
	WebElement PW_DonotMatch;
	
	@FindBy (xpath ="//div[contains(text(),'Lowercase characters, uppercase characters, digits (0-9)')]")
	WebElement Carecter_Symbols_Alerts;
	
	@FindBy (xpath ="//div[contains(text(),'A required field is missing')]")
	WebElement Required_field_Alert;
	
	
	
	
	public Sign_up_now_PageObject() {
		
		PageFactory.initElements(driver, this);
	}
			
	
	
	public void EmailVerify_Field(String Email,String New_Password,String Confirm_Password,String Given_Name,
			   String Surname,String Day,String Month,String Year,String Valid) throws InterruptedException {
		Login_button.click();
		//Sign_up_now_button.click();
		Set<String> Signup_Window_Handels=driver.getWindowHandles();
        ArrayList<String> List_Windows = new ArrayList<String>();
        List_Windows.addAll(Signup_Window_Handels);
        String Signup_Window [] = List_Windows.toArray(new String[List_Windows.size()]);
        System.out.println(Signup_Window [0]);
        System.out.println(Signup_Window [1]);
		driver.switchTo().window(Signup_Window[1]);
		Thread.sleep(2000);
		Sign_up_now_button.click();
		
		
		if(Valid.contains("Yes")) {
			Email_Address_Field.sendKeys(Email);
			SendVerification_button.click();
			Thread.sleep(2000);
			boolean VerificationMessage = Verification_Message.isDisplayed();
			Assert.assertEquals(true, VerificationMessage);
			
		}else if(Valid.contains("No")) {
			Email_Address_Field.sendKeys(Email);
			SendVerification_button.click();
			Thread.sleep(2000);
			boolean Valid_Alert = Valid_Email_Alert.isDisplayed();
			Assert.assertEquals(true, Valid_Alert);
			
			
			
		}
}
	public void PasswordVerify_Field(String Email,String New_Password,String Confirm_Password,String Given_Name,
				   String Surname,String Day,String Month,String Year,String Valid) throws InterruptedException {
		
		    Login_button.click();
		//Sign_up_now_button.click();
		    Set<String> Signup_Window_Handels=driver.getWindowHandles();
            ArrayList<String> List_Windows = new ArrayList<String>();
            List_Windows.addAll(Signup_Window_Handels);
            String Signup_Window [] = List_Windows.toArray(new String[List_Windows.size()]);
            System.out.println(Signup_Window [0]);
            System.out.println(Signup_Window [1]);
		    driver.switchTo().window(Signup_Window[1]);
		    Thread.sleep(2000);
		    Sign_up_now_button.click();
		    
			
		if(Valid.contains("Not_Same")) { New_Password_Field.sendKeys(New_Password);
			Confirm_New_Password_Field.sendKeys(Confirm_Password); 
			Create_Button.click();
			boolean Pw_Not_Match = PW_DonotMatch.isDisplayed(); 
			Assert.assertEquals(true,
			Pw_Not_Match);
			  
	  } else if(Valid.contains("Yes")) 
	       {
			New_Password_Field.sendKeys(New_Password);
			Confirm_New_Password_Field.sendKeys(Confirm_Password);
			Create_Button.click();
			boolean Required_Field_Missing = Required_field_Alert.isDisplayed();
			Assert.assertEquals(true, Required_Field_Missing);
	  }else if(Valid.contains("No")) 
	       {
			New_Password_Field.sendKeys(New_Password);
			Confirm_New_Password_Field.sendKeys(Confirm_Password); 
			Create_Button.click();
			boolean Pw_Not_Match = Carecter_Symbols_Alerts.isDisplayed();
			Assert.assertEquals(true, Pw_Not_Match);
			  
		   }
			 
	
}
	
	
	
	
	
}
