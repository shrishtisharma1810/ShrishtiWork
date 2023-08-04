import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.ConnectionType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NetworkSpeed {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		
		//enable network
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		//emulate network  conditions with arguments offline->true indicates no internet, false indicates internet is on
		//latency->no of requests
		//downloadThroughput->no of downloads
		//uploadThroughput->no of uploads
		//connectionType->type of internet connection( none, cellular2g, cellular3g, cellular4g, bluetooth, ethernet, wifi, wimax, other)
		//Network.emulateNetworkConditions(Boolean offline, Number latency, Number downloadThroughput, Number uploadThroughput, Optional<ConnectionType> connectionType)
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));
		
		//this listener is written to display error msg page loading is failed
		devTools.addListener(Network.loadingFailed(), loaderfailed->{
			System.out.println(loaderfailed.getErrorText());
		});
		long startTime=System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
//		driver.get("http://google.com");
//		driver.manage().window().maximize();
//		driver.findElement(By.name("q")).sendKeys("toy",Keys.ENTER);
//		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
//		String title=driver.findElement(By.id("glow-ingress-line1")).getText();
//		System.out.println(title);
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}

}
