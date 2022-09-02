package Page_Object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Class.Base_Class;

public class Search_flight_PageObject extends Base_Class {
	
	
	@FindBy(xpath = "//input[@placeholder='From']" )
	WebElement From_Field;
	
	@FindBy(xpath = "//input[@placeholder='To']" )
	WebElement To_Field;
	
	
	
    public Search_flight_PageObject() {
     PageFactory.initElements(driver,this);
    	
    }
	
    
    
    public void Search_Flight() {
    	
    	From_Field.sendKeys("Kolkata");
    	
    	
    }
	

}
