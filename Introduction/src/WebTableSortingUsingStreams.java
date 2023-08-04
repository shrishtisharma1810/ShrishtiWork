import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class WebTableSortingUsingStreams {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		// Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//Click on Veg/fruitname column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//get all WEs from first column
		List<WebElement> l1=driver.findElements(By.xpath("//tr/td[1]"));
		
		//get all WEs in original list
		List<String> original=l1.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//Then sort and get all WEs in sorted
		List<String> sorted=original.stream().sorted().collect(Collectors.toList());
		
		//use assertion to check if both are same
		Assert.assertTrue(original.equals(sorted));
		
		List<String> price;
		//from first column where WE have value Beans get the price
		//we can use custom function for this
		//List<String> price=l1.stream().filter(s->s.getText().contains("Beans")).map(s->getPrice(s))
		//		.collect(Collectors.toList());
		
		//Rice is not present on first page so if we run this we wont see any output as nothing will be passed to map, 
		//nothing will be returned in price and so nothing will be printed
		do {
		List<WebElement> l2=driver.findElements(By.xpath("//tr/td[1]"));
		price=l2.stream().filter(s->s.getText().contains("Rice")).map(s->getPrice(s))
				.collect(Collectors.toList());
		//if not found on first page then price.size will be 0, so click on next
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(price.size()<1);
		
		//print the price
		//This works fine if value is present on first page itself. but if there is pagination then we have to use loop 
		price.forEach(s->System.out.println(s));
		
	}
  public static String getPrice(WebElement s)
  {
	  String priceValue=s.findElement(By.xpath("following-sibling::td")).getText();
	  return priceValue;
	  
  }
}
