package ECommerce.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ECommerce.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentReports extent=ExtentReporterNG.getReportobject();
	ExtentTest test;
	//This ThreadLocal is used to avoid overriding test obj when executing test in parallel
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	WebDriver driver;
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		//this is used to link test obj to become thread safe and avoid overriding i.e unique thread id is generated
		extentTest.set(test);
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS,"Test Passed");
		//test.log(Status.PASS,"Test Passed");
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		//test.fail(result.getThrowable());
		try {
		driver=(WebDriver) result.getTestClass().getRealClass().getField("driver")
				.get(result.getInstance());
		}catch(Exception e) {
			e.printStackTrace();
		}
		String filePath= null;
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		//code to take and attach screenshot for failed method
		try {
			 filePath=getScreenshot(result.getMethod().getMethodName(),driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
		//test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}

}
