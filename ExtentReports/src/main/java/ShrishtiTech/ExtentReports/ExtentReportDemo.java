package ShrishtiTech.ExtentReports;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	ExtentReports extent;
	//In this test we are configuring extent reports using two classes ExtentSparkReporter and ExtentReport
	@BeforeTest
	public void config() {
		//Creation of path variable where test reports will be saved
		String path=System.getProperty("user.dir")+"\\Reports\\index.html";
		//Creation of reporter object
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		//Setting report name
		reporter.config().setReportName("ECommerce Web Automation");
		//Setting document title
		reporter.config().setDocumentTitle("ECommerce Reports");
		//Creation of main Extent report obj
		extent=new ExtentReports();
		//Passing reporter obj to extent report
		extent.attachReporter(reporter);
		//setting system info, anything can be passed as args
		extent.setSystemInfo("TL","Neha Sharma");
	}
	@Test
	public void TestClassForExtentReport() {
		//linking test to extent report by creating a test
		extent.createTest("Initial Extent Report Demo Test");
		//This step is used to get a test obj
		//ExtentTest test=extent.createTest("Initial Extent Report Demo Test");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();
		//this step is used to explicitly fail the test
		//test.fail("Results did not match");
		extent.flush();
	}

}
