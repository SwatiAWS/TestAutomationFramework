package Base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class BaseTest {
	
	public static WebDriver driver;
	
	//Property reading functionality
	public static Properties properties = new Properties();
	public static Properties locators = new Properties();
	
	public static FileReader fileReader;
	public static FileReader fileReaderLocators;
	
	
	//Set up method based on which driver - chrome firefox
	@BeforeMethod
	public void setUp() throws IOException {
		if(driver==null) {
			//System.out.println(System.getProperty("user.dir"));
			//FileReader fileReader = new FileReader	("C:\\JavaLearning\\TestAutomationFramework\\src\\test\\resources\\ConfigFiles\\config.properties");
			fileReader = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\ConfigFiles\\config.properties");
			fileReaderLocators = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\ConfigFiles\\locators.properties");
			
			properties.load(fileReader);
			locators.load(fileReaderLocators);
		}
		if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {//This will get the value of key browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
			driver.get(properties.getProperty("testurl")); 
		}
		else if(properties.getProperty("browser").equalsIgnoreCase("firefox")) {//This will get the value of key browser
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
			driver.get(properties.getProperty("testurl")); 
		}
		
		
	}
	
	//tear down method, close the browser, application
	@AfterSuite
	public void tearDown() {
		driver.close();
		System.out.println("TEar Down method");
	}
	

}
