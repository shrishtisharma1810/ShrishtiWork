import java.awt.RenderingHints.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class actionDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/");
		WebElement we=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		Actions a=new Actions(driver);
		
		//this will hover mouse over that element using moveToElement
		//right click using contextClick
		//build is used to build composite action 
		//perform is used to execute it
		a.moveToElement(we).contextClick().build().perform();
		
		//move to txtbox, then click on it, then enter bags in capitall letters and then select the entered text using doubleclick
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("bags").doubleClick().build().perform();
		
		

	}

}
