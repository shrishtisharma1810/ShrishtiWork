import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.emulation.Emulation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class setGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		 	ChromeOptions options = new ChromeOptions();
		 	double latitude = 40.0;
	        double longitude = 3.0;
	        double accuracy = 1.0;
		 	 // Set the geolocation options
	        options.addArguments("--disable-notifications"); // Disable notifications (optional)
	        options.addArguments("--lang=fr"); // Set the desired language (optional)
	        options.addArguments("--use-fake-ui-for-media-stream"); // Simulate user media (optional)
	        options.addArguments("--use-fake-device-for-media-stream"); // Simulate user media (optional)
	        options.addArguments("--geolocation=" + latitude + "," + longitude + "," + accuracy); // Set the geolocation
	        /*Map<String, Object> prefs = new HashMap<>();
	        prefs.put("profile.default_content_setting_values.notifications", 2); // Disable notifications
	        prefs.put("intl.accept_languages", "fr"); // Set the desired language code here
	        options.setExperimentalOption("prefs", prefs);*/

	        ChromeDriver driver = new ChromeDriver(options);
	        DevTools devTools = driver.getDevTools();
	        devTools.createSession();

	        

	        devTools.send(Emulation.setGeolocationOverride(Optional.of(latitude), Optional.of(longitude), Optional.of(accuracy)));
		//ChromeDriver driver=new ChromeDriver();
		///DevTools devTools=driver.getDevTools();
		//devTools.createSession();
		
		
		//double latitude = 40.0;
       // double longitude = 3.0;
       // double accuracy = 1.0;

        //devTools.send(Emulation.setGeolocationOverride(Optional.of(latitude), Optional.of(longitude), Optional.of(accuracy)));
       // Emulation.SetGeolocationOverrideCommand setGeolocationOverrideCommand =
       //         new Emulation.SetGeolocationOverrideCommand(Optional.of(latitude), Optional.of(longitude), Optional.of(accuracy));
        
        
       
        //devTools.send(setGeolocationOverrideCommand);
		/*Map<String, Object> geoLocation=new HashMap<String, Object>();
		geoLocation.put("latitude", Optional.of(40.0));
		geoLocation.put("longitude",Optional.of(3.0));
		geoLocation.put("accuracy",Optional.of(1.0));
		
		 //devTools.send(Emulation.setGeolocationOverride(geoLocation));
		driver.executeCdpCommand("Emulation.setGeolocationOverride", geoLocation);*/
			
		driver.get("http://google.com");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		
		driver.findElement(By.name("q")).sendKeys("toy",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String title=driver.findElement(By.id("glow-ingress-line1")).getText();
		System.out.println(title);
		

	}

}
