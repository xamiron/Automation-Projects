package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager{
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = "reports/extentReport2.html";
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

    public static ExtentTest createTest(String testName, String description) {
        return getInstance().createTest(testName, description);
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}

