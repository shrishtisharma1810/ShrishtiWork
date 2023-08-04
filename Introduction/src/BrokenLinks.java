import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		// Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		  //broken URL

        //Step 1 - IS to get all urls tied up to the links using Selenium

        // Java methods will call URL's and gets you the status code

        //if status code >400 then that url is not working-> link which tied to url is broken

        //a[href*="soapui"]'

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        SoftAssert s=new SoftAssert();

		List<WebElement> links=driver.findElements(By.cssSelector(".gf-li a"));
		System.out.println("total no of links on the page: "+links.size());
		
		for(WebElement link:links) {
			String url=link.getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode=conn.getResponseCode();
			System.out.println(responseCode);
			s.assertTrue(responseCode<400,"The link with text "+link.getText()+" is broken with status code "+responseCode);
						
		}
		s.assertAll();

	}

}
