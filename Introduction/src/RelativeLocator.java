import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocator {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		// Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameTextBox=driver.findElement(By.xpath("//input[@name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameTextBox)).getText());
		WebElement dobBox=driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dobBox)).click();
		WebElement employmentstatus=driver.findElement(By.cssSelector("[for='exampleFormControlRadio1']"));
		driver.findElement(with(By.tagName("input")).toRightOf(employmentstatus)).click();
		WebElement checkBoxtxt=driver.findElement(By.cssSelector(".form-check-label"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxtxt)).click();

	}

}
