import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarosuelHandling {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		
		driver.get("https://www.amazon.com/");
		
		driver.manage().window().maximize();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	   String itemsxpath = "//h2[text()='Amazon Live | Shop livestreams']/parent::div/parent::div/following::div[@data-id='scrollCarouselSlider']//div[@data-id='TileTitle']";
		
	   String nextbuttonxpath = "//a[@data-id='carouselControlFeedNext']";
	   
		
	   List<WebElement> elements = driver.findElements(By.xpath(itemsxpath));
	   
	   Set<String> eleset = new LinkedHashSet<String>();
	   
	   while(!driver.findElement(By.xpath(nextbuttonxpath)).getAttribute("class").contains("carousel_feedDisable")){
		   
		for(WebElement e : elements) {
			
			String text = e.getText();
			
			if (!text.isEmpty()) {
			
			eleset.add(text);
		}
		}
		
		 driver.findElement(By.xpath(nextbuttonxpath)).click();
		 
		 elements = driver.findElements(By.xpath(itemsxpath));
		   
	   }
	   
	   for(String e : eleset) {
		   
		   System.out.println(e);
	   }
	   
	}

}
