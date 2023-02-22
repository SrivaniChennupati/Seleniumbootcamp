import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTable {
	
	static WebDriver driver;

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
  getTableData(3);
	}
	
	public static void getTableData(int coloumnumber) {
		
		String beforexpath = "//table[@id='customers']/tbody/tr[";
		
		String afterxpath = "]/td["+coloumnumber+"]";
		
	 List<WebElement> list = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		
	     
	     for (int row=2;row<=list.size();row++) {
	    	 
	    	 String Completexpath = beforexpath+row+afterxpath;
	    	 
	    	 String text = driver.findElement(By.xpath(Completexpath)).getText();
	    	 
	    	   System.out.println(text);
	    	 
	     }
	}

}
