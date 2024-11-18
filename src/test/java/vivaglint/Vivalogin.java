package vivaglint;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import glint.Base;

public class Vivalogin extends Base {
	protected Properties prop;

	ExtentSparkReporter spark;
	ExtentReports extentReport;
//	ExtentTest test ;

	@BeforeClass
	public void ExtentReports() {

		spark = new ExtentSparkReporter("ExtentReport.html");
		extentReport = new ExtentReports();

		spark.config().setDocumentTitle("ESR Report");
		spark.config().setReportName("ESR-overview");
		spark.config().setTimeStampFormat("EEEE, MMMM dd, YYYY, hh:mm a '('zzz')'");
		extentReport.attachReporter(spark);
	}

	@AfterClass
	public void generateReports() {
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
