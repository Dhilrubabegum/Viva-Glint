package glint;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

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
	public void Exportandshare() throws InterruptedException {
		changesurvey();
		driver.findElement(By.xpath(properties.getProperty("Reportexportdropdown.xpath"))).click();
		iwait();
		String ppt = driver.findElement(By.id(properties.getProperty("Exporttoppt.id"))).getText();
		iwait();
		Assert.assertEquals(ppt, "Export Report to PowerPoint");
		String pdf = driver.findElement(By.id(properties.getProperty("Exporttopdf.id"))).getText();
		Assert.assertEquals(pdf, "Export Report to PDF");
		String newpdf = driver.findElement(By.id(properties.getProperty("newExporttopdf.id"))).getText();
		Assert.assertEquals(newpdf, "(New) Export Report to PDF");
		String Img = driver.findElement(By.id(properties.getProperty("Exportstoimage.id"))).getText();
		Assert.assertEquals(Img, "Export Report to Images");
		String csv = driver.findElement(By.id(properties.getProperty("Exporttocsv.id"))).getText();
		Assert.assertEquals(csv, "Export Report to Spreadsheet");
		iwait();
		driver.findElement(By.id(properties.getProperty("Exporttoppt.id"))).click();
		
		String parent=driver.getWindowHandle();
		 
		Set<String>s=driver.getWindowHandles();
		 
		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();
		 
		while(I1.hasNext())
		{
		 
		String child_window=I1.next();
		 
		 
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		
		System.out.println(driver.switchTo().window(child_window).getTitle());
		 
		driver.close();
		}
		 
		}
		
		driver.switchTo().window(parent);
		driver.findElement(By.id(properties.getProperty("Exporttopdf.id"))).click();
	
		
	
	}
}

