package glint;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Media;

public class Executivesummaryreport extends Base {

	public Executivesummaryreport(RemoteWebDriver driver) {
		this.driver = driver;

	}

	public String ESRTitle() {
		WebElement title = driver.findElement(By.xpath(properties.getProperty("ESRTitle.xpath")));
		String title1 = title.getText();
		Assert.assertEquals(title1, "Executive Summary Report");
		return title1;

	}

	public void changesurvey() throws InterruptedException {
		iwait();
		Thread.sleep(5000);
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
		iwait();
		driver.findElement(By.id(properties.getProperty("Addsection.id"))).click();
		iwait();
		driver.findElement(By.xpath(properties.getProperty("pulseresultsection.xpath"))).click();
		iwait();
		scrollintoElement(driver.findElement(By.xpath(properties.getProperty("addsectionheader.xpath"))));

	}

	public void ExportList() throws InterruptedException {
		// changesurvey();
		driver.findElement(By.xpath(properties.getProperty("Reportexportdropdown.xpath"))).click();
		iwait();
		iwait();
		List<WebElement> list = driver.findElements(By.xpath(properties.getProperty("dropdownlist")));
		System.out.println(list.size());
		for (WebElement webElement : list) {
			String name = webElement.getText();
			System.out.println(name);
			// Assert.assertEquals(name, false);
		}
	}

	public void Exportppt() throws InterruptedException {
		// changesurvey();
		driver.findElement(By.xpath(properties.getProperty("Reportexportdropdown.xpath"))).click();
		iwait();
		iwait();
		driver.findElement(By.id(properties.getProperty("Exporttoppt.id"))).click();
		iwait();
		driver.findElement(By.xpath(properties.getProperty("exportpptexport.xpath"))).click();

		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());
			}

		}
		driver.switchTo().window(parent);

	}

	public void Exportpdf() throws InterruptedException {
		// changesurvey();
		driver.findElement(By.xpath(properties.getProperty("Reportexportdropdown.xpath"))).click();
		iwait();
		iwait();
		driver.findElement(By.id(properties.getProperty("Exporttopdf.id"))).click();
		iwait();
		driver.findElement(By.xpath(properties.getProperty("exportpdfgeneratepdf.xpath"))).click();
		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

			}

		}
		driver.switchTo().window(parent);
	}

	public void Exportimages() throws InterruptedException {
		// changesurvey();
		driver.findElement(By.xpath(properties.getProperty("Reportexportdropdown.xpath"))).click();
		iwait();
		iwait();
		driver.findElement(By.id(properties.getProperty("Exporttoimage.id"))).click();
		iwait();

		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

			}

		}
		driver.switchTo().window(parent);
	}

	public void Exportcsv() throws InterruptedException {
		// changesurvey();
		iwait();
		driver.findElement(By.xpath(properties.getProperty("Reportexportdropdown.xpath"))).click();
		iwait();
		iwait();
		driver.findElement(By.id(properties.getProperty("Exporttocsv.id"))).click();
		iwait();
		iwait();
		iwait();
		driver.findElement(By.xpath("//button[@class='btnCta glintButton']")).click();
		iwait();
		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				// driver.close();
			}

		}
		driver.switchTo().window(parent);
	}

	public void defaultSection() throws InterruptedException {
		// changesurvey();
		iwait();
		iwait();
		List<WebElement> Sectionnames = driver
				.findElements(By.xpath(properties.getProperty("defaultsectiontex.xpath")));
		int countofsection = Sectionnames.size();
		System.out.println(countofsection);
		for (WebElement ele : Sectionnames) {
			String name = ele.getText();
			System.out.println(name);
		}
	}

	public void surveyoverview() throws InterruptedException {
		// changesurvey();
		List<WebElement> Sectionnames = driver.findElements(By.xpath(properties.getProperty("surveyoveview.xpath")));
		int countofsection = Sectionnames.size();
		System.out.println(countofsection);
		for (WebElement ele : Sectionnames) {
			String name = ele.getText();
			System.out.println(name);
		}
	}

	public void Historysection() throws InterruptedException {
		// changesurvey();
		List<WebElement> Sectionnames = driver.findElements(By.xpath(properties.getProperty("historysection.xpath")));
		int countofsection = Sectionnames.size();
		System.out.println(countofsection);
		for (WebElement ele : Sectionnames) {
			String name = ele.getText();
			Assert.assertEquals("History", name);
			System.out.println(name);
		}
	}

	public void scores() throws InterruptedException {
		// changesurvey();
		List<WebElement> Sectionnames = driver.findElements(By.xpath(properties.getProperty("scores.xpath")));
		int countofsection = Sectionnames.size();
		System.out.println(countofsection);
		for (WebElement ele : Sectionnames) {
			String name = ele.getText();
			Assert.assertEquals("Scores", name);
			System.out.println(name);
		}
	}

	public void Question() throws InterruptedException {
		List<WebElement> Sectionnames = driver.findElements(By.xpath("(//p[@class='vg-layout-header-title'])[3]"));
		int countofsection = Sectionnames.size();
		System.out.println(countofsection);
		for (WebElement ele : Sectionnames) {
			String name = ele.getText();
			Assert.assertEquals("", name);
			System.out.println(name);
		}
	}

	public void Manager() throws InterruptedException {
		// changesurvey();
		iwait();
		List<WebElement> e = driver.findElements(By.xpath("(//select[@class='ng-star-inserted'])[13]"));

		System.out.println(e.size());
		for (WebElement webElement : e) {
			String name = webElement.getText();
			System.out.println(name);
		}

	}

	public void addsection2() {
		iwait();
		WebElement as = driver.findElement(By.xpath("//button[@data-id='addSectionButton']"));
		as.getText();
		System.out.println(as);

	}

	public void grouped() {
		iwait();
		WebElement g = driver.findElement(By.xpath("(//input[@class='ng-untouched ng-pristine ng-valid'])[1]"));
		iwait();
		g.isSelected();

	}

	public void ungrouped() {
		iwait();
		WebElement g = driver.findElement(By.xpath("(//input[@class='ng-untouched ng-pristine ng-valid'])[2]"));
		iwait();
		g.isSelected();
		iwait();
		Assert.assertEquals(false, false);

	}

	public void managergrouped() {
		iwait();
		WebElement g = driver.findElement(By.xpath("(//input[@class='ng-untouched ng-pristine ng-valid'])[1]"));
		iwait();
		g.isSelected();

	}

	public void managerungrouped() {
		WebElement g = driver.findElement(By.xpath("(//input[@class='ng-untouched ng-pristine ng-valid'])[2]"));
		iwait();
		g.isSelected();
		iwait();
		Assert.assertEquals(false, false);
	}

	public void SaveReport() throws InterruptedException {
		iwait();
		driver.findElement(By.xpath(properties.getProperty("Reportexportdropdown.xpath"))).click();
		iwait();
		driver.findElement(By.id("option4")).click();
		iwait();
		WebElement pagetext = driver.findElement(By.xpath("//label[text()=\"What do you want to name this report?\"]"));
		String s = pagetext.getText();
		Assert.assertEquals(s, "What do you want to name this report?");
		WebElement name = driver.findElement(By.id("saveDialogTitle"));
		name.clear();
		name.sendKeys("Executive Summary Report Automation Copy");
		iwait();
		driver.findElement(By.xpath("//button[@class=\"btnCta glintButton\"]")).click();
		iwait();
		Thread.sleep(2000);
		WebElement savedcopy = driver.findElement(By.xpath(" //h1[@class='reportTitle']"));
		String name1 = savedcopy.getText();
		iwait();
		Assert.assertEquals(name1, "Executive Summary Report Automation Copy");
		iwait();
		driver.findElement(By.xpath(properties.getProperty("Report.xpath"))).click();

		driver.findElement(By.xpath(properties.getProperty("ESR.xpath"))).click();
	}

	public void filterthereport() throws InterruptedException {
		iwait();
		driver.findElement(By.xpath(properties.getProperty("addfilter.xpath"))).click();
		Thread.sleep(3000);
		iwait();
		driver.findElement(By.xpath("//span[text()=\"Add Filters\"]")).click();
		iwait();
		driver.findElement(By.xpath("//div[text()=\"Gender\"]")).click();
		iwait();
		driver.findElement(By.xpath("//label[text()=\" FeMale \"]")).click();
		iwait();
		driver.findElement(By.xpath("//button[text()=\" Done \"]")).click();
		iwait();
		driver.findElement(By.xpath(properties.getProperty("closefilters.xpath"))).click();
		WebElement e = driver.findElement(By.xpath("//div[text()=\" Gender\"]"));
		String s = e.getText();
		Assert.assertEquals(s, "Gender:");
	}

	public void Repondentscount() {
		iwait();
		WebElement Rcount = driver.findElement(By.xpath("(//*[text()= \" 377 \"])[1]"));
		String c = Rcount.getText();
		Assert.assertEquals(c, "377");
	}

	public void Benchmark() {
		iwait();
		WebElement b = driver.findElement(By.xpath("//span[text()=\"Benchmark:\"]"));
		String s = b.getText();
		Assert.assertEquals(s, "Benchmark:");

	}

	public void Removesection() throws InterruptedException {
		iwait();
		driver.findElement(By.xpath(properties.getProperty("Reportexportdropdown.xpath"))).click();
		iwait();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='Scoresmenu']")).click();
		iwait();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@aria-label='Remove']")).click();
		iwait();
		WebElement e = driver.findElement(By.xpath("//p[text()=\"Questions\"]"));
		String s = e.getText();
		Assert.assertEquals(s, "Questions");
	}

}
