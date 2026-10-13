package com.orangehrm.listeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

public class ExtentListener implements ITestListener {
    private static final ExtentReports REPORT = createReport();
    private static final ThreadLocal<ExtentTest> TEST = new ThreadLocal<>();

    private static ExtentReports createReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/extent-report.html");
        spark.config().setDocumentTitle("OrangeHRM Automation Report");
        spark.config().setReportName("Employee Lifecycle E2E");
        ExtentReports reports = new ExtentReports();
        reports.attachReporter(spark);
        reports.setSystemInfo("Framework", "Selenium + TestNG + POM");
        reports.setSystemInfo("Language", "Java 17");
        return reports;
    }
    @Override public void onTestStart(ITestResult result) { TEST.set(REPORT.createTest(result.getMethod().getMethodName())); }
    @Override public void onTestSuccess(ITestResult result) { TEST.get().pass("Test passed"); }
    @Override public void onTestFailure(ITestResult result) { TEST.get().fail(result.getThrowable()); }
    @Override public void onTestSkipped(ITestResult result) { TEST.get().skip("Test skipped"); }
    @Override public void onFinish(ITestContext context) { REPORT.flush(); }
}
