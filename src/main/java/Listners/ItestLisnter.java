package Listners;



import org.testng.ITestListener;
import org.testng.ITestResult;

import Base_Class.Base_Class;





public class ItestLisnter extends Base_Class implements ITestListener{

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			onTestfailure(result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	  
	



		
	}




	


