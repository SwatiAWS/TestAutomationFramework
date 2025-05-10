package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstTestCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriver browser on which to execute the script like Chrome.
		//WebDriver manager will download the driver for us//
		WebDriverManager.chromedriver().setup();// move it to base
		
		//Create object of type Chrome Driver
		WebDriver driver = new ChromeDriver(); //base
		
		driver.get("https://www.zoho.com/"); // config or properties file
		driver.findElement(By.linkText("Sign In")).click(); //locators -- properties POM 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login_id']")));
		element.click();
		driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("swati.g.s2023@gmail.com"); //test data
	//	driver.findElement(By.name("LOGIN_ID")).sendKeys("swati.g.s2023@gmail.com");
		
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
		
		WebDriverWait waitPass = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elementPass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
		elementPass.click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("TestAutomation");
		driver.findElement(By.xpath("//button[@id='nextbtn']//span[contains(text(),'Sign in')]")).click();
		
		 
	}

}
