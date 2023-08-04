import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//driver.findElement(By.cssSelector(".form-control.ng-pristine.ng-invalid.ng-touched")).sendKeys("Neha");
		driver.findElement(By.xpath("//input[@name='name'and @minlength='2']")).sendKeys("Neha");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("nehaabc");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement Genderdropdown=driver.findElement(By.id("exampleFormControlSelect1"));
		Select Gender=new Select(Genderdropdown);
		Gender.selectByVisibleText("Female");
		driver.findElement(By.cssSelector("input[value='option1']")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("10/18/1983");
		driver.findElement(By.xpath("//input[contains(@class,'btn-success')]")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
			

	}

}
