package TestComponents;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent= ExtentReporterNG.getReprotObject();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	@Override		
    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub				
       test.log(Status.PASS,"Test Passed") ;		
    }	
	
	@Override		
    public void onFinish(ITestContext result) {					
        // TODO Auto-generated method stub				
        	extent.flush();
    }		

    @Override		
    public void onStart(ITestContext result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub	
    	
    	extentTest.get().fail(result.getThrowable());
    	
    	try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String filePath=null;
    	try {
			filePath=getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
    				
    }		

    @Override		
    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub	
    	
        	test= extent.createTest(result.getMethod().getMethodName());
        	extentTest.set(test);//captures unique thread id
}
}
