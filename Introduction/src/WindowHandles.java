import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> allhandles=driver.getWindowHandles();
		Iterator<String> it=allhandles.iterator();
		String parentwindowid=it.next();
		String childwindowid=it.next();
		driver.switchTo().window(childwindowid);
		String email=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at ")[1].split(" ")[0];
		driver.switchTo().window(parentwindowid);
		driver.findElement(By.id("username")).sendKeys(email);
	}

}
