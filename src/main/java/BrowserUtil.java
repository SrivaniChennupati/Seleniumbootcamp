import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	public WebDriver driver;

	/**
	 * 
	 * @param browser
	 * @return
	 */
	
	
	public WebDriver initDriver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			//System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Drivers\\\\chromedriver.exe");

			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {

			//System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\Drivers\\\\geckodriver.exe");

			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
		}

		else {

			System.out.println("please pass the correct browser" + browser);
		}

		return driver;

	}

	public void launchURL(String url) {

		if (url == null || url.isEmpty()) {

			System.out.println("URL is incorrect");
		}

		driver.get(url);

		return;

	}
	
	public String getPageTitle() {
		
	 return  driver.getTitle();
	}
	
	public String getPageURL() {
		
		
		return driver.getCurrentUrl();
	}
	
	
	
	
	
	

}
