package Listners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import Utils_Excel.TestName_Excel;

public class MethodIntercept implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		List<Map<String, String>> list = null;
		try {
			list = TestName_Excel.Data("Login_test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<IMethodInstance> result = new ArrayList<>();
		for(int i=0; i<methods.size(); i++) {
			for(int j=0; j<list.size(); j++) {
				
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("Test_Name"))) {
					if(list.get(j).get("Execute").equalsIgnoreCase("Yes")) {
						
						result.add(methods.get(i));
					}
					
					
				}
				 
				
				
				
				
			}

	}
	
	return result;
	
	
	}
}
