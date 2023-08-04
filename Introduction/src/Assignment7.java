import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		// Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://www.qaclickacademy.com/practice.php");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		WebElement tableProduct=driver.findElement(By.cssSelector(".table-display"));
		System.out.println("No of Rows: "+tableProduct.findElements(By.tagName("tr")).size());
		System.out.println("No of Columns: "+tableProduct.findElements(By.cssSelector(".table-display tr th")).size());
		System.out.println("Instructor value from Row 2: "+tableProduct.findElement(By.cssSelector(".table-display tr:nth-child(3) td:nth-child(1)")).getText());
		System.out.println("Course value from Row 2: "+tableProduct.findElement(By.cssSelector(".table-display tr:nth-child(3) td:nth-child(2)")).getText());
		System.out.println("Price value from Row 2: "+tableProduct.findElement(By.cssSelector(".table-display tr:nth-child(3) td:nth-child(3)")).getText());
		
	}

}
