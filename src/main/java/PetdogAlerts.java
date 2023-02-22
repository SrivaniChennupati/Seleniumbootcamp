import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PetdogAlerts {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
	   
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		
		driver.manage().window().maximize();
		
		 WebElement frame = driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]"));
		 
		// driver.switchTo().frame(frame);
		 
		 WebDriverWait wait = new WebDriverWait(driver,10);
		 
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		 
		 
		 List<WebElement> stateslist = driver.findElements(By.xpath("//*[local-name()='svg']//*[name()='g']//*[name()='g' and @class='region']"));
		
		System.out.println(stateslist.size());
		 
		 
		 Actions ac = new Actions(driver);
		 
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		
		 for(WebElement e :stateslist) {
			 
		 
			  String text = e.getAttribute("id");
			  
			  System.out.println(text);
			  
			  if (text.equals("maryland")) {
				  
				  
				  js.executeScript("arguments[0].scrollIntoView(true);", e);
				  
				  ac.moveToElement(e).click().build().perform();
				  
				//ac.moveToElement(e).click().build().perform();
				 
				 break;
			  }
		 }

	}

}
