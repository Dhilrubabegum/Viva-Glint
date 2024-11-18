package vivaglint;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

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

	@Test
	public void Tc_01() throws IOException {
		esr.ESRTitle();
		esr.Screenshot("Tc_01");
		ExtentTest test = extentReport.createTest("ESR title");
		test.info("Title of the page");
	}

	@Test
	public void Tc_02() throws IOException, InterruptedException {
		esr.changesurvey();
		esr.Screenshot("Tc_02");
	}

	@Test
	public void Tc_03() throws IOException, InterruptedException {
		esr.Moreoption();
		esr.Screenshot("Tc_03");
	}

	@Test
	public void Tc_04() throws IOException, InterruptedException {
		esr.Addsection();
		esr.Screenshot("Tc_04");
	}

	@Test
	public void Tc_05() throws InterruptedException {
		esr.ExportList();
	}

	@Test
	public void Tc_06() throws IOException, InterruptedException {
		esr.Exportppt();
		esr.Screenshot("Tc_06");
	}

	@Test
	public void Tc_07() throws IOException, InterruptedException {
		esr.Exportpdf();
		esr.Screenshot("Tc_07");
	}

	@Test
	public void Tc_08() throws IOException, InterruptedException {
		esr.Exportimages();
		esr.Screenshot("Tc_08");
	}

	@Test
	public void Tc_09() throws IOException, InterruptedException {
		esr.Exportcsv();
		esr.Screenshot("Tc_09");
	}

	@Test
	public void Tc_10() throws IOException, InterruptedException {
		esr.Exportppt();
		esr.Screenshot("Tc_010");
	}

	@Test
	public void Tc_11() throws IOException, InterruptedException {
		esr.defaultSection();
		esr.Screenshot("Tc_010");

	}

	@Test
	public void Tc_12() throws IOException, InterruptedException {
		esr.surveyoverview();
		esr.Screenshot("Tc_012");
	}

	@Test
	public void Tc_13() throws IOException, InterruptedException {
		esr.Historyhoverover();
		esr.Screenshot("Tc_013");
	}

	@Test
	public void Tc_14() throws IOException, InterruptedException {
		esr.Historysection();
		esr.Screenshot("Tc_014");
	}

	@Test
	public void Tc_15() throws IOException, InterruptedException {
		esr.scores();
		esr.Screenshot("Tc_015");
	}

	@Test
	public void Tc_16() throws IOException, InterruptedException {
		esr.Question();
		esr.Screenshot("Tc_016");
	}

	@Test
	public void Tc_17() throws IOException, InterruptedException {
		esr.Manager();
		esr.Screenshot("Tc_017");
	}
}
