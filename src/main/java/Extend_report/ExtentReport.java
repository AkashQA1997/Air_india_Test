package Extend_report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base_Class.Base_Class;

public class ExtentReport extends Base_Class implements ITestListener{

	public ExtentReports extent ;
	public ExtentSparkReporter spark ;
	public ExtentTest test;


	public void onTestStart(ITestResult result) {


		System.out.println("The test is starting"+ result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("The testcase got Passed" + result.getName());
		test = extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passed test case is"+ result.getName(), ExtentColor.RED));
	}

	public void onTestFailure(ITestResult result) {
		Throwable t = new RuntimeException("A runtime exception");
		System.out.println("The testcase got failed:-  " + result.getName());

		test = extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is"+ result.getName(), ExtentColor.RED));
		//test.fail(t);
		try {
			test.fail("test is failed", MediaEntityBuilder.createScreenCaptureFromPath(Base_Class.onTestfailure(result.getName())).build());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, t);


	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("The testcase got Skipped" + result.getName());
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped test case is"+ result.getName(), ExtentColor.ORANGE));
	}



	public void onStart(ITestContext context) {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Spark.html");
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Test demo");
		spark.config().setReportName("Test_Demo");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}



}
