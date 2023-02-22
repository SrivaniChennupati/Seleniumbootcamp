package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class RegisterAccountPage {
	
	private WebDriver driver;
	
	private ElementUtil eu;
	
	private By Continue = By.xpath("//button[text()='Continue']");
	
	private By checkbox = By.xpath("//input[@name='agree']");
	
	private By firstname = By.name("firstname");
	
	private By lastname = By.name("lastname");
	
	private By email = By.name("email");
	
	private By password = By.name("password");
	
	public RegisterAccountPage(WebDriver driver) {
		
		this.driver = driver;
		
		eu = new ElementUtil(driver);
	}
	
	
    public void enterdatainReg() {
    	
    	enterdata("firstname", "srivani");
    	
    	enterdata("lastname","chennupati");
    	
    	enterdata("email" , "srivanichennupati@gmail.com");
    	
    	enterdata("password","Jesus@447");
    	
       
    	doclickcheckbox();
    	
    }
	
	
    public void doRegistration(String firstname,String lastname,String email,String password) {
    	
    	
    	eu.doSendKeys(this.firstname, firstname);
    	
    	eu.doSendKeys(this.lastname, lastname);
    	
    	
    	eu.doSendKeys(this.email, email);
    	
    	eu.doSendKeys(this.password, password);
    	
    	doclickcheckbox();
    	
    	doclickContinue();
    	
    	
    }
	
	
	
	public void enterdata(String inputtype,String value) {
	
		

		String xpath = "//input[@name='"+inputtype+"']" ;
		
	   driver.findElement(By.xpath(xpath)).sendKeys(value);
		
		
	}
	
public void doclickcheckbox() {
		
		WebElement agreement = driver.findElement(checkbox);
	JavascriptExecutor js = (JavascriptExecutor)driver;
    
    js.executeScript("arguments[0].click();" ,agreement);
	
	
	}
	
	public void doclickContinue() {
		
		//eu.doClick(Continue);
		
		WebElement Continuebutton = driver.findElement(Continue);
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    
	    js.executeScript("arguments[0].click();" ,Continuebutton);
	}
	
	
	
}
