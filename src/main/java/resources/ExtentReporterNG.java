package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public static ExtentReports getReprotObject() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter rep = new ExtentSparkReporter(path);
		rep.config().setReportName("Web Automation Results");
		rep.config().setDocumentTitle("Test Results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(rep);
		extent.setSystemInfo("Tester", "Pujitha");
		return extent;
	}

}
