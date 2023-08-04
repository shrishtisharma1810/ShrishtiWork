import java.time.Duration;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v113.network.model.Request;
import org.openqa.selenium.devtools.v113.network.model.Response;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NetworkLogActivity {

	public static void main(String[] args) throws InterruptedException {
		//Create Chromium driver object
		ChromeDriver driver=new ChromeDriver();
				
		//Create devTools obj to send built in selenium commands for CDP
		DevTools devTools=driver.getDevTools();
				
		//Create a session
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		Set<String> requestUrls = new HashSet<>();
        Set<String> responseUrls = new HashSet<>();
        		
		devTools.addListener(Network.requestWillBeSent(), request->
		{
			Request req=request.getRequest();
			requestUrls.add(req.getUrl());
			//System.out.println("Request URL: "+ req.getUrl());
		});
		
		devTools.addListener(Network.responseReceived(), response->
		{
			Response res=response.getResponse();
			responseUrls.add(res.getUrl());
			if(res.getStatus().toString().startsWith("4")) {
				
				System.out.println("Response URL: "+ res.getUrl() +"is failing with Status Code: "+ res.getStatus());
				
			}
			
		});
		driver.get("http://localhost:3000/password");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id(":r1:")).sendKeys("neha@gmail.com");
		driver.findElement(By.cssSelector("[type='submit']")).click();
		// Wait for the network events to be processed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(Network.loadingFinished());
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(org.openqa.selenium.WebDriver webDriver) {
                return requestUrls.equals(responseUrls);
            }
        });
        driver.quit();
		
	}

}
