package testBase_1;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	
	public static ExtentReports extents;
	public static ExtentTest test;
	
	static
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extents=new ExtentReports(System.getProperty("user.dir")+"//reports//test_"+formater.format(cal.getTime())+".htm",false);
		
	}
	
	void getReports(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
			test.log(LogStatus.PASS,result.getName()+": Test got passed!");
		else if(result.getStatus()==ITestResult.FAILURE)
			test.log(LogStatus.FAIL,result.getName()+": Test got failed! "+result.getThrowable());
		else if(result.getStatus()==ITestResult.SKIP)
			test.log(LogStatus.SKIP,result.getName()+": Test got skiped!"+result.getThrowable());
		else if(result.getStatus()==ITestResult.STARTED)
			test.log(LogStatus.INFO,result.getName()+": Test execution started!");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		getReports(result);
	}
	
	@BeforeMethod
	public void beforeMethod(Method result)
	{
		test=extents.startTest(result.getName());
		test.log(LogStatus.INFO,result.getName()+": Test Satarted!");
	}
	@AfterClass(alwaysRun=true)
	public void afterClass()
	{
		 extents.endTest(test);
		extents.flush(); 
		
	}

}
