import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PseudoElements {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://emicalculator.net/");
		
		List<WebElement> svglist = driver.findElements(By.xpath("//*[local-name()='svg' and contains(@class,'highcharts-root')]//*[name()='g' and contains(@class,' highcharts-column-series highcharts-tracker')]//*[name()='rect']"));
		
		Actions ac = new Actions(driver);
		for(WebElement e : svglist) {
			
		
			
			ac.moveToElement(e).build().perform();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String text = driver.findElement(By.xpath("//*[local-name()='svg' and contains(@class,'highcharts-root')]//*[name()='g' and contains(@class,'highcharts-label highcharts-tooltip highcharts-color-undefined')]//*[name()='text']")).getText();
			
		    System.out.println(text);
		
		}

	}

}
