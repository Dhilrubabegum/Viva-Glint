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

	public void ESRTitle() {
		WebElement title = driver.findElement(By.xpath(properties.getProperty("ESRTitle.xpath")));
		String title1 = title.getText();
		// System.out.println(title1);
		Assert.assertEquals(title1, "Executive Summary Report");
//		ExtentTest test = extentReport.createTest("ESR title");
//		test.info("Title of the page");
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
		WebElement e = driver.findElement(By.xpath("//select[@id='glintDropdown_a6cb6f0a-2a24-4a30-a694-bbf254b67f2a']"));
		e.click();
		//System.out.println(e);
		iwait();
		iwait();
		//scrollintoElement(driver.findElement(By.xpath("//button[@class='disabled commentCountBtn']")));
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

//		WebElement tooltip1 = driver.findElement(By.xpath(" //div[text()=\" Score 47  Company_updated 47  Pulsed on Nov 13 \"]"));
//		Actions act = new Actions(driver);
//		act.moveToElement(tooltip1).build().perform();
//		act.moveToElement(tooltip1);
//		String TT1 = tooltip1.getText();
//		System.out.println(TT1);

	}
}
