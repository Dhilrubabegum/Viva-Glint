package vivaglint;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import glint.Executivesummaryreport;
import glint.Login;

public class ESR extends Vivalogin {
	Login login;
	Executivesummaryreport esr;

	@BeforeClass
	void setObject() {
		login = new Login(driver);
		esr = new Executivesummaryreport(driver);

		login.login(prop.getProperty("email"), prop.getProperty("clientid"), prop.getProperty("password"));
		login.survey(prop.getProperty("survey"));
	}

	@Test(priority = 1)
	public void Tc_01() throws IOException {

		ExtentTest test = extentReport.createTest("Tc_01");
		test.log(Status.PASS, "Title: " + esr.ESRTitle());
		esr.ESRTitle();
		Assert.assertEquals("Executive Summary Report", esr.ESRTitle());
		test.addScreenCaptureFromPath(Screenshot("Tc_01"));
	}

	@Test(priority = 8)
	void Tc_02() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_02");
		test.log(Status.PASS, "user can able to change survey");
		esr.changesurvey();
		test.addScreenCaptureFromPath(Screenshot("Tc_02"));
	}

	@Test(priority = 19)
	public void Tc_03() throws IOException, InterruptedException {
		iwait();

		ExtentTest test = extentReport.createTest("Tc_03");
		test.log(Status.PASS, "More option is visible");
		esr.Moreoption();
		test.addScreenCaptureFromPath(Screenshot("Tc_03"));

	}

	@Test(priority = 20)
	public void Tc_04() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_04");
		test.log(Status.PASS, "Section is added");
		esr.Addsection();
		test.addScreenCaptureFromPath(Screenshot("Tc_04"));

	}

	@Test(priority = 25)
	public void Tc_05() throws InterruptedException, IOException {
		ExtentTest test = extentReport.createTest("Tc_05");
		test.log(Status.PASS, "List of Export and share is visible");
		esr.ExportList();
		test.addScreenCaptureFromPath(Screenshot("Tc_05"));

	}

	@Test(priority = 10)
	public void Tc_06() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_06");
		test.log(Status.PASS, "Exported to ppt");
		esr.Exportppt();
		test.addScreenCaptureFromPath(Screenshot("Tc_06"));

	}

	@Test(priority = 11)
	public void Tc_07() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_07");
		test.log(Status.PASS, "Exported to pdf");
		esr.Exportpdf();
		test.addScreenCaptureFromPath(Screenshot("Tc_07"));

	}

	@Test(priority = 12)
	public void Tc_08() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_08");
		test.log(Status.PASS, "Exported to Images");
		esr.Exportimages();
		test.addScreenCaptureFromPath(Screenshot("Tc_08"));

	}

	@Test(priority = 13)
	public void Tc_09() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_09");
		test.log(Status.PASS, "Exported to CSV");
		esr.Exportcsv();
		test.addScreenCaptureFromPath(Screenshot("Tc_09"));

	}

	@Test(priority = 9)
	public void Tc_10() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_10");
		test.log(Status.PASS, "Default section is displaying");
		esr.defaultSection();
		test.addScreenCaptureFromPath(Screenshot("Tc_10"));

	}

	@Test(priority = 14)
	public void Tc_11() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_11");
		test.log(Status.PASS, "Survey overview section is displaying");
		esr.surveyoverview();
		test.addScreenCaptureFromPath(Screenshot("Tc_11"));

	}

	@Test(priority = 15)
	public void Tc_12() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_12");
		test.log(Status.PASS, "History section is displaying");
		esr.Historysection();
		test.addScreenCaptureFromPath(Screenshot("Tc_12"));

	}

	@Test(priority = 16)
	public void Tc_13() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_13");
		test.log(Status.PASS, "Score section is displaying");
		esr.scores();
		test.addScreenCaptureFromPath(Screenshot("Tc_13"));

	}

	@Test(priority = 6)
	public void Tc_14() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_14");
		test.log(Status.PASS, "Question section is displaying");
		esr.Question();
		test.addScreenCaptureFromPath(Screenshot("Tc_14"));

	}

	@Test(priority = 18)
	public void Tc_15() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_15");
		test.log(Status.PASS, "Manager section is displaying");
		esr.Manager();
		test.addScreenCaptureFromPath(Screenshot("Tc_15"));

	}

	@Test(priority = 7)
	public void Tc_16() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_16");
		test.log(Status.PASS, "+Addsection in the bottom of the page is displaying");
		esr.addsection2();
		test.addScreenCaptureFromPath(Screenshot("Tc_16"));

	}

	@Test(priority = 3)
	public void Tc_17() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_17");
		test.log(Status.PASS, "Grouped checkbox for Scoresection is displaying");
		esr.grouped();
		test.addScreenCaptureFromPath(Screenshot("Tc_17"));

	}

	@Test(priority = 4)
	public void Tc_18() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_18");
		test.log(Status.PASS, "UnGrouped checkbox for Scoresection is displaying");
		esr.ungrouped();
		test.addScreenCaptureFromPath(Screenshot("Tc_18"));

	}

	@Test(priority = 5)
	public void Tc_19() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_19");
		test.log(Status.PASS, "Grouped checkbox for Managersection is displaying");
		esr.managergrouped();
		test.addScreenCaptureFromPath(Screenshot("Tc_18"));

	}

	@Test(priority = 6)
	public void Tc_20() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_20");
		test.log(Status.PASS, "UnGrouped checkbox for Managersection is displaying");
		esr.managerungrouped();
		test.addScreenCaptureFromPath(Screenshot("Tc_20"));

	}

	@Test(priority = 22)
	public void Tc_21() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_21");
		test.log(Status.PASS, "Report is saved");
		esr.SaveReport();
		test.addScreenCaptureFromPath(Screenshot("Tc_21"));

	}

	@Test(priority = 21)
	public void Tc_22() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_22");
		test.log(Status.PASS, "Filter is working");
		esr.filterthereport();
		test.addScreenCaptureFromPath(Screenshot("Tc_22"));

	}

	@Test(priority = 2)
	public void Tc_23() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_23");
		test.log(Status.PASS, "Respondentscount is showing");
		esr.Repondentscount();
		test.addScreenCaptureFromPath(Screenshot("Tc_23"));

	}

	@Test(priority = 23)
	public void Tc_24() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_24");
		test.log(Status.PASS, "Benchmark is showing");
		esr.Benchmark();
		test.addScreenCaptureFromPath(Screenshot("Tc_24"));

	}

	@Test(priority = 25)
	public void Tc_25() throws IOException, InterruptedException {
		ExtentTest test = extentReport.createTest("Tc_25");
		test.log(Status.PASS, "User can able to Remove section");
		esr.Removesection();
		test.addScreenCaptureFromPath(Screenshot("Tc_25"));

	}

}
