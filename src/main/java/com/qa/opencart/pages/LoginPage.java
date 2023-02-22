package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	
	private  ElementUtil eu;
	
	private By Username = By.name("email");
	
	private By  Password = By.name("password");
	
	private By clickbutton = By.xpath("//button[text()='Login']");
	
	private By Registerlink = By.xpath("//aside[@id='column-right']//a[text()='Register']");
	
	
	
  public LoginPage(WebDriver driver) {
	  
	  this.driver = driver;
	 eu = new ElementUtil(driver);
	  
	  
  }
  
  
   public MyAccountPage doLogin(String username, String password) {
	   
	    eu.doSendKeys(Username, username);
	    
	    eu.doSendKeys(Password, password);
	    
	   WebElement click = driver.findElement(clickbutton);
	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    
	    js.executeScript("arguments[0].click();" ,click);
	   
	   return new MyAccountPage(driver);
   }

   
   public RegisterAccountPage clickOnRegisterPage() {
	   
	     eu.doClick(Registerlink);
	     
	     return new RegisterAccountPage(driver);
	   
   }
}
