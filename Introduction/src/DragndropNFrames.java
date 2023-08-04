import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragndropNFrames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		WebElement frame=driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(frame);
		WebElement dragableobj=driver.findElement(By.cssSelector("#draggable"));
		WebElement dropablebleobj=driver.findElement(By.cssSelector("#droppable"));
		Actions a=new Actions(driver);
		a.dragAndDrop(dragableobj, dropablebleobj).build().perform();
		driver.switchTo().defaultContent();
		

	}

}
