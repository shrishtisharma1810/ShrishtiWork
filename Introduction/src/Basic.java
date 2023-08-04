import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic {

	public static void main(String[] args) {
		/*******Chrome Driver********************************************************/
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver1 = new ChromeDriver(options);
		driver1.get("https://rahulshettyacademy.com/");
		System.out.println(driver1.getTitle());
		//driver.close();
		
		/*********************Firefox Driver**************************************/
		//System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver-v0.32.2-win64\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver2 = new FirefoxDriver();
		driver2.get("https://rahulshettyacademy.com/");
		System.out.println(driver2.getTitle());
		//driver.close();
		
		
		/*********************Edge Driver**************************************/
		//System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver-v0.32.2-win64\\geckodriver.exe");
		WebDriverManager.edgedriver().setup();
		WebDriver driver3 = new EdgeDriver();
		driver3.get("https://rahulshettyacademy.com/");
		System.out.println(driver3.getTitle());
		driver1.close();
		driver2.close();
		driver3.close();

	}

}
