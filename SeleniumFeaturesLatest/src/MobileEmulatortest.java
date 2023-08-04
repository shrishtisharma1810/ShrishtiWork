import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.emulation.Emulation;

public class MobileEmulatortest {

	public static void main(String[] args) throws InterruptedException {
		//Create Chromium driver object
		ChromeDriver driver=new ChromeDriver();
		
		//Create devTools obj to send built in selenium commands for CDP
		DevTools devTools=driver.getDevTools();
		
		//Create a session
		devTools.createSession();
		
		//Initiate dev tools session to send commands from selenium
		//Here we are using Emulation Domain
		//setDeviceMetricsOverride is a method which can be used to toggle web view to mobile view
		devTools.send(Emulation.setDeviceMetricsOverride(600,1000,55,true,Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Library")).click();
		driver.close();
		
	}

}
