package glint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
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
	protected RemoteWebDriver driver =null;
	public static WebDriverWait wait = null;
	protected Properties properties = null;

	public Base() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream("Vivalocators.properties"));
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

	public void type(WebElement element, String i) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(i);
	}

	public String Screenshot(String name) throws IOException {
		
		File source = driver.getScreenshotAs(OutputType.FILE);

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
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}


}
