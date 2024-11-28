package glint;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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

	public void FilterList() throws InterruptedException {
		iwait();
		driver.findElement(By.xpath(properties.getProperty("addfilter.xpath"))).click();
		Thread.sleep(3000);
		iwait();
		driver.findElement(By.xpath("//span[text()=\"Add Filters\"]")).click();
		iwait();
		List<WebElement> L = driver.findElements(By.xpath("//li[@class='item ng-star-inserted']//div"));

		String[] Expected = { "Bank A.No", "Birth Date", "Birth Month", "Birth Year", "End Date", "Father's Name",
				"Gender", "Govt ID No", "H3", "H4", "HireYear", "Job Role", "Location", "Location Hierarchy", "Manager",
				"Marital Status", "Mother's Name", "Salary Bank Name", "Start Date", "Team Hierarchy", "attribute 100",
				"attribute 19", "attribute 21", "attribute 22", "attribute 23", "attribute 24", "attribute 25",
				"attribute 26", "attribute 27", "attribute 28", "attribute 29", "attribute 30", "attribute 31",
				"attribute 32", "attribute 33", "attribute 34", "attribute 35", "attribute 36", "attribute 37",
				"attribute 38", "attribute 39", "attribute 40", "attribute 41", "attribute 42", "attribute 43",
				"attribute 44", "attribute 45", "attribute 46", "attribute 47", "attribute 48", "attribute 49",
				"attribute 51", "attribute 52", "attribute 53", "attribute 54", "attribute 55", "attribute 56",
				"attribute 57", "attribute 58", "attribute 59", "attribute 60", "attribute 61", "attribute 62",
				"attribute 63", "attribute 64", "attribute 65", "attribute 66", "attribute 67", "attribute 68",
				"attribute 69", "attribute 70", "attribute 71", "attribute 72", "attribute 73", "attribute 74",
				"attribute 75", "attribute 76", "attribute 77", "attribute 78", "attribute 79", "attribute 80",
				"attribute 81", "attribute 82", "attribute 83", "attribute 84", "attribute 85", "attribute 86",
				"attribute 87", "attribute 88", "attribute 89", "attribute 90", "attribute 91", "attribute 92",
				"attribute 93", "attribute 94", "attribute 95", "attribute 96", "attribute 97", "attribute 98",
				"attribute 99" };

		List list1 = new ArrayList(Arrays.asList(Expected));
		list1.add(Expected);
		int size = list1.size() - 1;
		List list2 = new ArrayList();
		for (WebElement exp1 : L) {
			String a = exp1.getText();
			list2.add(a);
		}
		int size1 = list2.size();
		Assert.assertEquals(size, size1);
	}

	public void Settings() throws InterruptedException {
		iwait();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		WebElement title = driver.findElement(By.xpath("//span[text()=\"Scores\"]"));

		wait.until(ExpectedConditions.visibilityOf(title));

		driver.findElement(By.xpath("//button[@data-id='reportSettingsButton']")).click();
		iwait();
		WebElement title1 = driver.findElement(By.xpath("//div[@id='slideyHeaderContent_SECTION_EDIT_SLIDEY']//h1"));
		wait.until(ExpectedConditions.visibilityOfAllElements(title1));
		String t = title1.getText();
		Assert.assertEquals(t, "Report Settings");

	}

	public void Done() throws InterruptedException {
		iwait();
		Settings();
		WebElement d = driver.findElement(By.xpath("//button[text()=\" Done \"]"));
		Assert.assertFalse(d.isEnabled());
	}

	public void RSClose() throws InterruptedException {
		iwait();
		Settings();
		driver.findElement(By.xpath("//button[@class='btnIcon slideyClose glintButton']")).click();
		WebElement title = driver.findElement(By.xpath(properties.getProperty("ESRTitle.xpath")));
		String title1 = title.getText();
		Assert.assertEquals(title1, "Executive Summary Report");
	}

	public void BenchmarkSelection() throws InterruptedException {
		Settings();
		driver.findElement(By.xpath("//label[text()=' Global 2020 (December) ']")).click();
		WebElement d = driver.findElement(By.xpath("//button[text()=\" Done \"]"));
		Assert.assertTrue(d.isEnabled());
		driver.findElement(By.xpath("//button[text()=\" Done \"]")).click();
		WebElement name = driver.findElement(By.xpath("//button[text()=' Global 2020 (December) ']"));
		String s = name.getText();
		Assert.assertEquals(s, "Global 2020 (December)");

	}
}
