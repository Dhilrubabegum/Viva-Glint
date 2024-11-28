package glint;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login<WebDriver> extends Base {
	public Login(RemoteWebDriver driver){
		this.driver = driver;
		}
		
	public void login(String email,String clientid,String password){
		type(driver.findElement(By.id(properties.getProperty("LoginPage.email.id"))),email);
		driver.findElement(By.className(properties.getProperty("LoginPage.Continue1.ClassName"))).click();
		
		type(driver.findElement(By.id(properties.getProperty("LoginPage.clientid.id"))),clientid);
        driver.findElement(By.xpath(properties.getProperty("LoginPage.Continue2.xpath"))).click();
        
        type(driver.findElement(By.id(properties.getProperty("LoginPage.password.id"))),password);
		driver.findElement(By.xpath(properties.getProperty("LoginPage.submit.xpath"))).click();
		driver.findElement(By.xpath(properties.getProperty("Report.xpath"))).click();
		}
	
	public void survey(String survey) {
		type(driver.findElement(By.xpath(properties.getProperty("search.xpath"))),survey);
        driver.findElement(By.xpath(properties.getProperty("survey.xpath"))).click();
		driver.findElement(By.xpath(properties.getProperty("ESR.xpath"))).click();
	}
	
	public void survey1(String survey1) {
		type(driver.findElement(By.xpath(properties.getProperty("search.xpath"))),survey1);
        driver.findElement(By.xpath(properties.getProperty("survey1.xpath"))).click();
        iwait();
        iwait();
        driver.findElement(By.xpath(properties.getProperty("ESR.xpath"))).click();
	}
}
