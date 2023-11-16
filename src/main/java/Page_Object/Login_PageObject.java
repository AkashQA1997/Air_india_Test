package Page_Object;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base_Class.Base_Class;

public class Login_PageObject extends Base_Class {
	
	@FindBy (xpath ="//a[text()=' Login']")
	WebElement Login_button;
	
	@FindBy (css = "#signInName")
	WebElement User_name;
	
	@FindBy (css = "input#password")
	WebElement Password;
	
	@FindBy (xpath ="//h2[text()='Account Summary']")
	WebElement Account_Summary;
	
	@FindBy (css ="div.error.pageLevel")
	WebElement Alert_Login;
	
	@FindBy (xpath ="//button[text()='Sign in']")
	WebElement Sign_in_button;
	
	
public Login_PageObject() {
		
		PageFactory.initElements(driver,this);
		
	}
	
	
	
public void Signin_Check(Map<String, String> map) throws InterruptedException 

      {
		
		Login_button.click();
        Set<String> All_Window_Handels=driver.getWindowHandles();
        ArrayList<String> List_Windows = new ArrayList<String>();
        List_Windows.addAll(All_Window_Handels);
        String Arr_Window [] = List_Windows.toArray(new String[List_Windows.size()]);
        System.out.println(Arr_Window [0]);
        System.out.println(Arr_Window [1]);
        driver.switchTo().window(Arr_Window [1]);
        
        if(map.get("valid").equals("Yes")) {
        	
            User_name.sendKeys(map.get("login_ID"));
            Password.sendKeys(map.get("password"));
            Sign_in_button.click();
            Thread.sleep(3000);
            boolean Acoount_Bolean =Account_Summary.isDisplayed();
            Assert.assertEquals(true, Acoount_Bolean);
            System.out.println("Test OK");
        	
        }
        Thread.sleep(2000);
        if(map.get("valid").equals("No")) {
        	
            User_name.sendKeys(map.get("login_ID"));
            Password.sendKeys(map.get("password"));
            Sign_in_button.click();
            Thread.sleep(3000);
            boolean Alert_Bolean =Alert_Login.isDisplayed();
            Assert.assertEquals(true, Alert_Bolean);
            
        	
        }
        
        

		
	  }
	
	

}
