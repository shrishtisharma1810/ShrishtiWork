import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewWindowOrTab {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		// Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//This will open a new Tab
		driver.switchTo().newWindow(WindowType.TAB);
		
		//This can be used to open in new window
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentWinId=it.next();
		String childWinId=it.next();
		
		//switch to child window
		driver.switchTo().window(childWinId);
		//open this link in child window
		driver.get("https://rahulshettyacademy.com/");
		//get coursename in course
		String course=driver.findElements(By.cssSelector("a[href*=\"https://courses.rahulshettyacademy.com/p/\"]")).get(1).getText();
		//switch to parent window
		driver.switchTo().window(parentWinId);
		//enter first course name in name field
		WebElement name=driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(course);
		
		//Screenshot of page

		File file=name.getScreenshotAs(OutputType.FILE);
		
		//copy screenshot in file logo.png

		FileUtils.copyFile(file, new File("logo.png"));

		//Get Height & Width of a WebElement

		System.out.println(name.getRect().getDimension().getHeight());

		System.out.println(name.getRect().getDimension().getWidth());
		
		

	}

}
