package com.qa.opencart.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.RegisterAccountPage;

public class BaseTest {
	
	public  DriverFactory df;
	
	 public Properties prop;
	
	 public  WebDriver driver;
	 
	 public LoginPage lp;
	 
	 public MyAccountPage ap;
	 
	public RegisterAccountPage rap;
	
	
	@BeforeTest
	
	public void setUp() {
		
		df= new DriverFactory();
		
		 prop = df.initProp();
		
		 driver = df.initDriver(prop);
		 
		 lp = new LoginPage(driver);
		 
		 ap = new MyAccountPage(driver);
		
	}

}
