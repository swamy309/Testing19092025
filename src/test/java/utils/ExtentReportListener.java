package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import tests.LoginTest;

public class ExtentReportListener implements ITestListener {

	private ExtentReports extent;
	private ExtentTest test;
	WebDriver driver;

	public void onStart(ITestContext context) {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/reports/ExtentReport.html");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Selenium Automation Report");
		sparkReporter.config().setDocumentTitle("Automation Report");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Author", "Swamy dandu");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		test.info("Test Started: " + result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {

		test.pass("Test passed");

		WebDriver driver = LoginTest.driver; // 👈 get driver instance

		String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getMethod().getMethodName());

		test.addScreenCaptureFromPath(screenshotPath, "Screenshot on Pass");
		test.info("Screenshot captured on test pass.");
	}

	public void onTestFailure(ITestResult result) {

		test.fail(result.getThrowable());

		WebDriver driver = LoginTest.driver;

		String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(screenshotPath, "Screenshot on Failure");
		test.warning("Screenshot captured on test failure.");
	}

	public void onTestSkipped(ITestResult result) {
		test.skip("Test skipped");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
