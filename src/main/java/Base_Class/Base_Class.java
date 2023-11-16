package Base_Class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestNGMethod;

import Webevents.Webevent_Listners;


public class Base_Class {

	public static WebDriver driver;
	public static Properties propFile;
	//public static RemoteWebDriver driver = null;


	// Anguler project locators

	//ByAngular.model(“attribute value”);
	//ByAngular.binding(“attribute value”);
	//ByAngular.buttonText(“attribute value”);
	//ByAngular.exactBinding(“attribute value”);
	//ByAngular.exactRepeater(“attribute value”);
	//ByAngular.options(“attribute value”);
	//ByAngular.partialButtonText(“attribute value”);
	//ByAngular.repeater(“attribute value”);
	//ByAngular.exactRepeater(“attribute value”);



	//WebDriver driver=null;
	//NgWebDriverngDriver=null;
	//WebDriverManager.chromedriver().version("81.0.4044.138").setup();
	//driver = new ChromeDriver();
	//driver.get("http://juliemr.github.io/protractor-demo/");
	//ngDriver = new NgWebDriver((JavascriptExecutor) driver);
	//driver.findElement(ByAngular.model("first")).sendKeys("2");
	//driver.findElement(ByAngular.model("second")).sendKeys("2");
	//driver.findElement(ByAngular.buttonText ("Go!")).click();









	public void Intialization(String Browser) throws Throwable {
		propFile = new Properties();

		FileInputStream file = new FileInputStream(".\\Config_File\\Config.properties");
		propFile.load(file);




		if(Browser.contentEquals("Chrome")) {

			//WebDriverManager.chromedriver().setup();


			ChromeOptions options = new ChromeOptions();


			options.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(options);


			/*
			 * String username = "akashsaha17051997"; String access_key =
			 * "bH5WLyFH8NMO9ueGz4SkdvMtZcMvuzXeuyPvFCALYBNT0BdmrS";
			 * 
			 * 
			 * DesiredCapabilities capabilities = new DesiredCapabilities();
			 * capabilities.setCapability("browserName", "MicrosoftEdge");
			 * capabilities.setCapability("browserVersion", "119.0"); HashMap<String,
			 * Object> ltOptions = new HashMap<String, Object>(); ltOptions.put("username",
			 * "akashsaha17051997"); ltOptions.put("accessKey",
			 * "bH5WLyFH8NMO9ueGz4SkdvMtZcMvuzXeuyPvFCALYBNT0BdmrS");
			 * ltOptions.put("visual", true); ltOptions.put("video", true);
			 * ltOptions.put("platformName", "Windows 10"); ltOptions.put("resolution",
			 * "1920x1080"); ltOptions.put("build", "testNGDemo"); ltOptions.put("project",
			 * "test"); ltOptions.put("name", "Demo"); ltOptions.put("selenium_version",
			 * "3.141.59"); capabilities.setCapability("LT:Options", ltOptions); driver =
			 * new RemoteWebDriver (new URL ("https://" + username + ":" + access_key +
			 * "@hub.lambdatest.com/wd/hub"), capabilities);
			 */
		}else if (Browser.contentEquals("Firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else System.out.println("Give Correct Browser Name");


		String URL = propFile.getProperty("URL");
		System.out.println(URL);
		System.out.println(Browser);

		/*
		 * EventFiringWebDriver E_driver = new EventFiringWebDriver(driver);
		 * Webevent_Listners events_Listner = new Webevent_Listners();
		 * E_driver.register(events_Listner); driver= E_driver;
		 */

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(URL);


	}



	public static  String onTestfailure(String path) throws Throwable {

		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File DestinationFile = new File(".\\Failed_Screenshots\\"+path+".jpg" );
		String AbsoluteFile = DestinationFile.getAbsolutePath();
		FileUtils.copyFile(file, DestinationFile);

		return AbsoluteFile;
	}





}
