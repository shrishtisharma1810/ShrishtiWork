package ECommerce.resources;

import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public static ExtentReports getReportobject() {
			//Creation of path variable where test reports will be saved
			String path=System.getProperty("user.dir")+"\\Reports\\index.html";
			//Creation of reporter object
			ExtentSparkReporter reporter=new ExtentSparkReporter(path);
			//Setting report name
			reporter.config().setReportName("ECommerce Web Automation");
			//Setting document title
			reporter.config().setDocumentTitle("ECommerce Reports");
			//Creation of main Extent report obj
			ExtentReports extent=new ExtentReports();
			//Passing reporter obj to extent report
			extent.attachReporter(reporter);
			//setting system info, anything can be passed as args
			extent.setSystemInfo("TL","Neha Sharma");
			return extent;
		}
}
