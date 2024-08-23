package vivaglint;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
}
