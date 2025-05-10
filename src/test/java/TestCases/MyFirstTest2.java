package TestCases;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstTest2 extends BaseTest {

	@Test
	public static void loginTest() throws InterruptedException {
		
		driver.findElement(By.linkText(locators.getProperty("signIn_link"))).click(); //locators -- properties POM 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login_id']")));
		element.click();
		driver.findElement(By.xpath(locators.getProperty("email_Field"))).sendKeys("swati.g.s2023@gmail.com"); //test data
	//	driver.findElement(By.name("LOGIN_ID")).sendKeys("swati.g.s2023@gmail.com");
		
		driver.findElement(By.xpath(locators.getProperty("next_Button"))).click();
		
//		WebDriverWait waitPass = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement elementPass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
//		elementPass.click();
//		driver.findElement(By.xpath(locators.getProperty("password_Field"))).sendKeys("TestAutomation");
//		driver.findElement(By.xpath(locators.getProperty("login_nextButton"))).click();
		Thread.sleep(4000);
		 
	}

}
