import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandling {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		
	  WebDriverManager.chromedriver().setup();
	  
      driver = new ChromeDriver();
	  
	  driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
	  
	  
	   driver.findElement(By.id("datepicker")).click();
	   
	   
	}
	
	
	public  static void selectDateAndyear(String ExpectedMonthYear, String day) {
		
		
		if(Integer.parseInt(day)>31) {
			
			
		}
		
		if (ExpectedMonthYear.contains("Febrauary")&& Integer.parseInt(day)>28) {
			
			
		}
		
		 String ActualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			
		  
		   while (!ActualMonthYear.equals(ExpectedMonthYear)) {
			   
			   driver.findElement(By.xpath("//span[text()='Next']")).click();
			   
			   ActualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			     
			   
			  
			   
		   }
		   
		   selectDate(day);
	        
		}
		
	
	
	public static void selectDate(String day) {
		
		
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
	}

}
