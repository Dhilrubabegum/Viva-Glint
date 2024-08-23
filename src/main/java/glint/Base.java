package glint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Base {
	public WebDriver driver;
	public Properties props;
	public WebDriverWait wait;

	public Base() {
		props = new Properties();
		try {
			props.load(new FileInputStream("Vivalocators.properties"));
		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void type(WebElement element, String data) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(data);
	}

	public String Screenshot(String name) throws IOException {
		TakesScreenshot ss = ((TakesScreenshot) driver);
		File source = ss.getScreenshotAs(OutputType.FILE);

		File Destination = new File("C:\\Users\\dbegum01\\OneDrive - dentsu\\Pictures\\Automation\\" + name + ".png");
		FileHandler.copy(source, Destination);
		return Destination.getAbsolutePath();
	}

	public void scrollintoElement(WebElement Scroll) {

		WebElement Scrollelement = Scroll;
		JavascriptExecutor Exe = (JavascriptExecutor) driver;
		Exe.executeScript("arguments[0].scrollIntoView(true);", Scrollelement);

	}

	public void iwait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void login() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.vgqa.glint.cloud-dev.microsoft/session/auth");
		iwait();
		iwait();
		driver.findElement(By.id("LoginPage.email.id")).sendKeys("qatester@glintinc.com");
//driver.findElement(By.xpath	  
	}

}
