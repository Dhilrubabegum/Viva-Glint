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

public class Executivesummaryreport extends Base {

	public Executivesummaryreport(RemoteWebDriver driver) {
		this.driver = driver;

	}

	public String ESRTitle() {
		WebElement title = driver.findElement(By.xpath(properties.getProperty("ESRTitle.xpath")));
		String title1 = title.getText();
		// System.out.println(title1);
		Assert.assertEquals(title1, "Executive Summary Report");
//		ExtentTest test = extentReport.createTest("ESR title");
//		test.info("Title of the page");
		return title1;

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

	public void ExportList() throws InterruptedException {
		changesurvey();
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
		changesurvey();
		driver.findElement(By.xpath(properties.getProperty("Reportexportdropdown.xpath"))).click();
		iwait();
//		String ppt = driver.findElement(By.id(properties.getProperty("Exporttoppt.id"))).getText();
//		iwait();
//		Assert.assertEquals(ppt, "Export Report to PowerPoint");
//		String pdf = driver.findElement(By.id(properties.getProperty("Exporttopdf.id"))).getText();
//		Assert.assertEquals(pdf, "Export Report to PDF");
//		String Img = driver.findElement(By.id(properties.getProperty("Exportstoimage.id"))).getText();
//		Assert.assertEquals(Img, "Export Report to Images");
//		String csv = driver.findElement(By.id(properties.getProperty("Exporttocsv.id"))).getText();
//		Assert.assertEquals(csv, "Export Report to Spreadsheet");
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
		changesurvey();
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
		changesurvey();
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
		changesurvey();
		driver.findElement(By.xpath(properties.getProperty("Reportexportdropdown.xpath"))).click();
		iwait();
		iwait();
		driver.findElement(By.id(properties.getProperty("Exporttocsv.id"))).click();
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
		changesurvey();
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
		changesurvey();
		List<WebElement> Sectionnames = driver.findElements(By.xpath(properties.getProperty("surveyoveview.xpath")));
		int countofsection = Sectionnames.size();
		System.out.println(countofsection);
		for (WebElement ele : Sectionnames) {
			String name = ele.getText();
			System.out.println(name);
		}
	}

	public void Historysection() throws InterruptedException {
		changesurvey();
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
		changesurvey();
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
		changesurvey();
		List<WebElement> Sectionnames = driver.findElements(By.xpath(properties.getProperty("Questionsection.xpath")));
		int countofsection = Sectionnames.size();
		System.out.println(countofsection);
		for (WebElement ele : Sectionnames) {
			String name = ele.getText();
			Assert.assertEquals("", name);
			System.out.println(name);
		}
	}

	public void Manager() throws InterruptedException {
		changesurvey();
		iwait();
		WebElement e = driver
				.findElement(By.xpath("//select[@id='glintDropdown_a6cb6f0a-2a24-4a30-a694-bbf254b67f2a']"));
		e.click();
		// System.out.println(e);
		iwait();
		iwait();
		// scrollintoElement(driver.findElement(By.xpath("//button[@class='disabled
		// commentCountBtn']")));
//		iwait();
//		iwait();
//		Select dropdown = new Select(
//				driver.findElement(By.xpath("//select[@id='glintDropdown_a6cb6f0a-2a24-4a30-a694-bbf254b67f2a']")));
//		dropdown.selectByVisibleText("attribute 19");

	}

	public void Historyhoverover() throws InterruptedException {
		changesurvey();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath(" //p[text()=\"History\"]"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		WebElement e = driver.findElement(By.xpath("//*[@aria-label='Score 50 Company_updated 50 Pulsed on Nov 13']"));
		e.click();
		e.getText();

		WebElement tooltip1 = driver
				.findElement(By.xpath(" //div[text()=\" Score 47  Company_updated 47  Pulsed on Nov 13 \"]"));
		Actions act = new Actions(driver);
		act.moveToElement(tooltip1).build().perform();
		act.moveToElement(tooltip1);
		String TT1 = tooltip1.getText();
		System.out.println(TT1);

	}

	public void addsection2() {
		WebElement as = driver.findElement(By.xpath("//button[@data-id='addSectionButton']"));
		as.getText();
		System.out.println(as);
		// Assert.assertEquals(as, "Add section");
	}

	public void grouped() {
		iwait();
		WebElement g = driver.findElement(By.xpath("(//input[@class='ng-untouched ng-pristine ng-valid'])[1]"));
		iwait();
		g.isSelected();

	}

	public void ungrouped() {
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

	public void SaveReport() {
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
		WebElement savedcopy = driver.findElement(By.xpath(" //h1[@class='reportTitle']"));
		String name1 = savedcopy.getText();
		Assert.assertEquals(name1, "Executive Summary Report Automation Copy");
	}

	public void filterthereport() throws InterruptedException {
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
		WebElement Rcount = driver.findElement(By.xpath("(//*[text()= \" 377 \"])[1]"));
		String c = Rcount.getText();
		Assert.assertEquals(c, "377");
	}

	public void Benchmark() {
		WebElement b = driver.findElement(By.xpath("//div[@class='benchmarkDisplayContainer ng-star-inserted']"));
		String s = b.getText();
		Assert.assertEquals(s, "Benchmark:");
		WebElement name = driver.findElement(By.xpath("//button[text()=\" Company_updated \"]"));
		String n = b.getText();
		System.out.println(n);
	
		
	}
	public void Removesection() {
		iwait();
		iwait();
		driver.findElement(By.xpath("(//div[@class='vg-icon ng-star-inserted'])[20]")).click();
		iwait();
		driver.findElement(By.xpath("//option[text()=\"Remove\"]")).click();
		iwait();
		WebElement e=driver.findElement(By.xpath(properties.getProperty("scores.xpath")));
		String s=e.getText();
		Assert.assertEquals(s, false);
//		Select dropdown = new Select(
//				driver.findElement(By.xpath("(//div[@class='menuButton overflow glintButton'])[1]")));
//		dropdown.selectByVisibleText("Remove");
	}
}
