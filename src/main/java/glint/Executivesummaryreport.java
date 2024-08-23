package glint;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Executivesummaryreport extends Base {

	public Executivesummaryreport(RemoteWebDriver driver) {
		this.driver = driver;

	}

	public void ESRTitle() {
		driver.findElement(By.xpath(properties.getProperty("ESRTitle.xpath")));
	}

	public void changesurvey() throws InterruptedException {
		driver.findElement(By.xpath(properties.getProperty("addfilter.xpath"))).click();
		Thread.sleep(5000);
		iwait();
		WebElement surveyselect = driver.findElement(By.xpath(properties.getProperty("Surveyselect.xpath")));
		iwait();
		surveyselect.click();
		Thread.sleep(5000);
		driver.findElement(By.id(properties.getProperty("survey2.id"))).click();
		Thread.sleep(5000);
		iwait();
		WebElement sur = driver.findElement(By.xpath(properties.getProperty("Surveyselect.xpath")));
		iwait();
		sur.click();
		Thread.sleep(5000);
		driver.findElement(By.id(properties.getProperty("survey1.id"))).click();

		driver.findElement(By.xpath(properties.getProperty("closefilters.xpath"))).click();

	}

	public void Moreoption() throws InterruptedException {
		changesurvey();
		iwait();
		driver.findElement(By.xpath(properties.getProperty("More.xpath"))).click();
		iwait();
		iwait();
		String As = driver.findElement(By.id(properties.getProperty("Addsection.id"))).getText();
		Assert.assertEquals(As, "Add section");
		String sc = driver.findElement(By.id(properties.getProperty("searchcomments.id"))).getText();
		Assert.assertEquals(sc, "Search Comments");

	}
	public void Addsection() throws InterruptedException {
		Moreoption();
		driver.findElement(By.id(properties.getProperty("Addsection.id"))).click();
		iwait();
		driver.findElement(By.xpath(properties.getProperty("pulseresultsection.xpath"))).click();
		iwait();
		scrollintoElement(driver.findElement(By.xpath(properties.getProperty("addsectionheader.xpath"))));
		
	}
}
