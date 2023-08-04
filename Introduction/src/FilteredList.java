import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class FilteredList {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		// Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Enter rice in search field text box
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		//get all WEs from first column
		List<WebElement> l1=driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredList=l1.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		System.out.println(l1.size());
		System.out.println(filteredList.size());
		Assert.assertEquals(l1.size(),filteredList.size());

	}

}
