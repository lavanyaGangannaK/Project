package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsOfexceution {
	public static ExtentReports report;
	
	public static ExtentReports execreport()
	{
		ExtentSparkReporter sp = new ExtentSparkReporter(System.getProperty("user.dir")+"//reports/index.html");
		sp.config().setDocumentTitle("Testing report");
		sp.config().setReportName("Ecom App report");
		report = new ExtentReports();
		report.attachReporter(sp);
		report.setSystemInfo("Tester", "Lavanya G");
		return report;
		
	}

}
