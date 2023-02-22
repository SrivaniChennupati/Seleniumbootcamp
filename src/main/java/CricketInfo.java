import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketInfo {
	
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
        driver = new ChromeDriver();
        
        driver.get("https://www.espncricinfo.com/series/west-indies-in-zimbabwe-2022-23-1350678/zimbabwe-vs-west-indies-1st-test-1350681/live-cricket-score");
        
         driver.manage().window().maximize();
         
         List<String> scoreList = getScoreList("Tagenarine Chanderpaul");
         
         System.out.println(scoreList);
   	
	}
	
	public static List<String> getScoreList(String Batsmanname) {
		
		List<String> actualscorelist = new ArrayList<String>();
		
		
		String scorexpath = "//span[text()='"+Batsmanname+"']/ancestor::td/following-sibling::td" ;
		
		List<WebElement> scorelist = driver.findElements(By.xpath(scorexpath));
		
		for (WebElement e : scorelist) {
			
			String text = e.getText();
			
			actualscorelist.add(text);
			
			
			
		}
		
		return actualscorelist;
	}

}
