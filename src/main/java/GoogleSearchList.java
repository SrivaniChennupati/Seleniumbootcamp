import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchList {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		BrowserUtil bu = new BrowserUtil();
		
	    driver = bu.initDriver("chrome");
	    
	    bu.launchURL("https://www.google.co.in/");
	    
	    ElementUtil eu = new ElementUtil(driver);
	    
	    
	    
	    driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation Testing");
	    
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    List<WebElement> optionslist = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']/span"));
	    
	   for(WebElement e: optionslist) {
		   
		   String text = e.getText();
		   
		   System.out.println(text);
		   
		   if (text.equals("automation testing jobs")) {
			   
			   e.click();
			   break;
		   }
	   }
		

	}
	
	public static void googleseatchlist (By SearchLocator, String SeachKey, By Suggestionlistlocator, String value ) {
		
		
	}

}
