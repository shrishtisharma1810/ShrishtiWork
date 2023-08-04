import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class HandleInsecureSSLConnections {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//this step will bypass the insecure connection page and go to actual website even if it is not secure
		//make sure you pass arg to true
		options.setAcceptInsecureCerts(true);
		
		// Add the WebDriver proxy capability.

		Proxy proxy = new Proxy();

		proxy.setHttpProxy("myhttpproxy:3337");

		options.setCapability("proxy", proxy);
		
		//start chrome maximized
		options.addArguments("start-maximized");
		
		//disable pop up blocking
		options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		
		//Set default download dir
		
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", "/directory/path");

		options.setExperimentalOption("prefs", prefs);

		// Add a ChromeDriver-specific extension.

		options.addExtensions(new File("/path/to/extension.crx"));
		
		//FirefoxOptions, EdgeOptions,etc will also work same way as for Chrome
		WebDriver driver = new ChromeDriver(options);

		// Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//used to delete allcookies
		driver.manage().deleteAllCookies();
		
		//delete specific cookie
		driver.manage().deleteCookieNamed("cookiename");
		//useful in situation for eg u delte cookie for sessionkey and then verify if user is loggedoutand redirected to logic screen
		

		driver.get("https://expired.badssl.com/");

	}

}
