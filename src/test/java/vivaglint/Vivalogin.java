package vivaglint;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import glint.Base;

public class Vivalogin extends Base implements ITestListener {
	protected Properties prop;

	ExtentSparkReporter spark;
	ExtentReports extentReport;
	ExtentTest test;

	@BeforeClass
	public void onStart(ITestContext context) {

		spark = new ExtentSparkReporter("ExtentReport.html");
		spark.config().setReportName("ESR-overview");
		spark.config().setTimeStampFormat("EEEE, MMMM dd, YYYY, hh:mm a '('zzz')'");
		extentReport = new ExtentReports();
		extentReport.attachReporter(spark);
		extentReport.setSystemInfo("Testername", "Dhilruba");
	}

	public void onTestSuccess(ITestResult result) {
		test = extentReport.createTest(result.getName());
		test.log(Status.PASS, "Test case passed is " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test = extentReport.createTest(result.getName());
		test.log(Status.FAIL, "Test case failed is " + result.getName());
		test.log(Status.FAIL, "Cause is " + result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		test = extentReport.createTest(result.getName());
		test.log(Status.SKIP, "Test case Skipped is " + result.getName());
	}

	@AfterClass
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

	@BeforeTest
	public void setup() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("Data.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://app.vgqa.glint.cloud-dev.microsoft/session/auth");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

//	@AfterTest
//	public void quit() {
//		driver.quit();
//	}

}
