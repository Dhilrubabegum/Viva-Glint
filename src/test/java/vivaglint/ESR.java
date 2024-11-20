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

	@Test
	public void Tc_01() throws IOException {

		ExtentTest test = extentReport.createTest("Tc_01");
		test.log(Status.PASS, "Title: " + esr.ESRTitle());
		esr.ESRTitle();
		Assert.assertEquals("Executive Summary Report", esr.ESRTitle());
		test.addScreenCaptureFromPath(Screenshot("Tc_01"));
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
		esr.defaultSection();
		esr.Screenshot("Tc_010");

	}

	@Test
	public void Tc_11() throws IOException, InterruptedException {
		esr.surveyoverview();
		esr.Screenshot("Tc_011");
	}

	@Test
	public void Tc_12() throws IOException, InterruptedException {
		esr.Historyhoverover();
		esr.Screenshot("Tc_012");
	}

	@Test
	public void Tc_13() throws IOException, InterruptedException {
		esr.Historysection();
		esr.Screenshot("Tc_013");
	}

	@Test
	public void Tc_14() throws IOException, InterruptedException {
		esr.scores();
		esr.Screenshot("Tc_014");
	}

	@Test
	public void Tc_15() throws IOException, InterruptedException {
		esr.Question();
		esr.Screenshot("Tc_015");
	}

	@Test
	public void Tc_16() throws IOException, InterruptedException {
		esr.Manager();
		esr.Screenshot("Tc_016");
	}

	@Test
	public void Tc_17() throws IOException, InterruptedException {
		esr.addsection2();
		esr.Screenshot("Tc_017");
	}

	@Test
	public void Tc_18() throws IOException, InterruptedException {
		esr.grouped();
		esr.Screenshot("Tc_018");
	}

	@Test
	public void Tc_19() throws IOException, InterruptedException {
		esr.ungrouped();
		esr.Screenshot("Tc_019");
	}

	@Test
	public void Tc_20() throws IOException, InterruptedException {
		esr.managergrouped();
		esr.Screenshot("Tc_020");
	}

	@Test
	public void Tc_21() throws IOException, InterruptedException {
		esr.managerungrouped();
		esr.Screenshot("Tc_021");
	}
	
	@Test
	public void Tc_22() throws IOException, InterruptedException {
		esr.SaveReport();
		esr.Screenshot("Tc_022");
}
	@Test
	public void Tc_23() throws IOException, InterruptedException {
		esr.filterthereport();
		esr.Screenshot("Tc_023");
}
	@Test
	public void Tc_24() throws IOException, InterruptedException {
		esr.Repondentscount();
		esr.Screenshot("Tc_024");
}
	@Test
	public void Tc_25() throws IOException, InterruptedException {
		esr.Benchmark();
		esr.Screenshot("Tc_025");
}
	@Test
	public void Tc_26() throws IOException, InterruptedException {
		esr.Removesection();
		esr.Screenshot("Tc_026");
}

}
