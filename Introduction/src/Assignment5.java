import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Assignment5 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		System.out.println("No of framesets-->"+driver.findElements(By.tagName("frameset")).size());
		Actions a=new Actions(driver);
		
		//move to first frameset. Note frameset is not a frame
		a.moveToElement(driver.findElement(By.xpath("//frameset[@frameborder='1']"))).build().perform();
		
		//switch to top frame inside first frameset
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		
		//move to second frameset
		a.moveToElement(driver.findElement(By.name("frameset-middle"))).build().perform();
		
		//switch to middle frame inside that
		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		//print the MIDDLE text
		System.out.println(driver.findElement(By.cssSelector("#content")).getText());
			

	}

}
