package Base_Class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import Webevents.Webevent_Listners;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static WebDriver driver;
	public static Properties propFile;
	
	
	public void Intialization(String Browser) throws Throwable {
		    propFile = new Properties();
		
			FileInputStream file = new FileInputStream(".\\Config_File\\Config.properties");
			propFile.load(file);
	
		
		
		
		if(Browser.contentEquals("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		}else if (Browser.contentEquals("Firefox")) {
			  WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
	    }else System.out.println("Give Correct Browser Name");
		
		
		String URL = propFile.getProperty("URL");
		System.out.println(URL);
		System.out.println(Browser);
		EventFiringWebDriver E_driver = new EventFiringWebDriver(driver);
		Webevent_Listners events_Listner = new Webevent_Listners();
		E_driver.register(events_Listner);
		driver= E_driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(URL);
			
	
	}
	
	
	
	public void onTestfailure(String failed_Method) throws Throwable {
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File (".\\Failed_Screenshots\\"+failed_Method+".jpg" ));
		
	}




	
}
