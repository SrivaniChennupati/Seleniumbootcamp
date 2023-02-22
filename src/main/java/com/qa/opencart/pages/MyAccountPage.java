package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class MyAccountPage {
	
	
	private WebDriver driver;
	
	private ElementUtil eu;
	
	private By Search = By.name("search");
	
	private By Logoutlink = By.xpath("//aside[@id='column-right']//a[text()='Logout']");
	
	
	
	public MyAccountPage(WebDriver driver) {
		
		this.driver = driver;
		
		eu = new ElementUtil(driver);
	}
	
	
	

}
