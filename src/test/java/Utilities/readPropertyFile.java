package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class readPropertyFile {
	public static void main(String[] args) throws IOException {
		// give the location of the config file 
		FileReader fileReader = new FileReader("C:\\JavaLearning\\TestAutomationFramework\\src\\test\\resources\\ConfigFiles\\config.properties");
		Properties properties = new Properties();
		properties.load(fileReader);
		
		System.out.println(properties.getProperty("browser"));
		System.out.println(properties.getProperty("testurl"));
		
	}

}
