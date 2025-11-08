package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManagerUtility {

	    private static ExtentReports extent;

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            String reportPath = System.getProperty("user.dir") + "/reports/KeralaTourismReport.html";
	            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
	            spark.config().setReportName("Kerala Tourism Automation Report");
	            spark.config().setDocumentTitle("Test Results");

	            extent = new ExtentReports();
	            extent.attachReporter(spark);
	            extent.setSystemInfo("Tester", "Girish Kumar");
	            extent.setSystemInfo("Environment", "QA");
	        }
	        return extent;
	    }
	}

