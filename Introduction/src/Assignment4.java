import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Set<String> allhandles=driver.getWindowHandles();
		Iterator<String> it=allhandles.iterator();
		String parenthandle=it.next();
		String childhandle=it.next();
		
		driver.switchTo().window(childhandle);
		System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());
		driver.switchTo().window(parenthandle);
		System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());
		

	}

}
