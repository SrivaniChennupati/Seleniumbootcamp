package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	public Properties prop;
	
	public static String highlight ;
	
	public OptionsManager optionsmanager;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(Properties prop) {
		
		optionsmanager = new OptionsManager(prop);
		
		highlight  =prop.getProperty("highlight");
		
		String browser = prop.getProperty("browser");
		
		
		
		System.out.println(browser);

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			//driver = new ChromeDriver(optionsmanager.getChromeOptions());
			
			tldriver.set(new ChromeDriver(optionsmanager.getChromeOptions()));
		}

		else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		}

		else {

			System.out.println("Please pass the correct browser" + browser);

		}

		getDriver().manage().window().maximize();

		getDriver().get(prop.getProperty("url"));

		//return driver;
		
		return getDriver();

	}
	
	
	public WebDriver getDriver() {
		
		return tldriver.get();
	}
	
	public Properties initProp() {

		prop = new Properties();
		
		FileInputStream ip = null;
		
		String env = System.getProperty("env");
		
		if(env==null) {

		try {
			 ip = new FileInputStream("./src/test/resources/Config/configuration.properties");
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		else {
			
			System.out.println("Running on enviroment"+env);
			
			switch(env.toLowerCase()) {
			
			case "qa":
				
				 try {
					ip = new FileInputStream("./src/test/resources/Config/configuration.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			case "dev":
				try {
					ip = new FileInputStream("./src/test/resources/Config/configuration.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
				default :
					
					System.out.println("Please pass the correct env");
					break;
				
			}
			
		}
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}
	
	public String getScreenshot() {
		
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
	
	   File destination = new File(path);
	   
	   try {
		FileUtils.copyFile(src, destination);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   return path;
	
	}
	
	

}
