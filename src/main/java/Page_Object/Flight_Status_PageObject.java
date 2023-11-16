package Page_Object;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base_Class.Base_Class;

public class Flight_Status_PageObject extends Base_Class {
	
	@FindBy(xpath = "//a[text()=' Flight-Status']")
	WebElement Flight_Status;
	
	@FindBy(xpath = "//input[@placeholder='Flight Number*: eg 101']")
	WebElement Flight_number;
	
	@FindBy(xpath = "//input[@placeholder='From Date*']")
	WebElement From_date;
	
	@FindBy(id = "btnFlightStatus")
	WebElement Submit_Button;
	
	@FindBy(css = "div.ui-datepicker-title")
	WebElement Month_Date;
	
	@FindBy(xpath = "//a[@data-handler='next']")
	WebElement Next_Month_Button;
	
	@FindBy(xpath = "//h1[contains(text(),'Flight Status')]")
	WebElement Flight_Status_Header;
	
	@FindBy(xpath = "//span[contains(text(),'The flight is not operational.')]")
	WebElement Error_Message;
	
	
	
	
public Flight_Status_PageObject() {
	PageFactory.initElements(driver, this);
		
}
	

public void Fligh_Status_Check(Map<String, String> map) {
	
	Flight_Status.click();
	From_date.click();
	if(Valid.contains("Yes")) {
	while(true) {
	 String Present_MM_YY = Month_Date.getText();	
	if(Present_MM_YY.contains(From_MMYY)) {		
	 break;
	}else {
     Next_Month_Button.click();		
	 }	
	}

	List<WebElement> Date_ListY = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//child::td/a"));
	
	for(WebElement Date_ElementY : Date_ListY) {
		
		String DatesY = Date_ElementY.getText();
		if(DatesY.equals(From_Date)) {
			Date_ElementY.click();
          }
	 }
	
	
	Flight_number.sendKeys(Flight_Number);
	Submit_Button.click();
	driver.findElement(By.xpath("//span[contains(text(),'Click to verify')]")).click();
	boolean FlightStst1 = Flight_Status_Header.isDisplayed();
	Assert.assertEquals(true, FlightStst1);
	
	
	
	}
	
	
	if(Valid.contains("No")) {
	while(true) {
	 String Present_MM_YY = Month_Date.getText();	
	if(Present_MM_YY.contains(From_MMYY)) {		
	 break;
	}else {
     Next_Month_Button.click();		
	 }	
	}

	List<WebElement> Date_ListN = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//child::td/a"));
	
	for(WebElement Date_ElementN : Date_ListN) {
		
		String DatesN = Date_ElementN.getText();
		if(DatesN.equals(From_Date)) {
			Date_ElementN.click();
          }
	 }
	
	
	Flight_number.sendKeys(Flight_Number);
	Submit_Button.click();
	driver.findElement(By.xpath("//span[contains(text(),'Click to verify')]")).click();
	boolean FlightStst2 = Error_Message.isDisplayed();
	Assert.assertEquals(true, FlightStst2);
	
	
	
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	

}
