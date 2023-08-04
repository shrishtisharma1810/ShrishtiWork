import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(1000);
		
		//click on the from dropdown box
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		//click and select mumbai from dropdown
		driver.findElement(By.xpath("//a[@value=\"BOM\"]")).click();
		Thread.sleep(2000);
		
		//click to select Leh from the To dropdown. Here we are using indexing
		//findElement(By.xpath("(//a[@value=\"IXL\"])[2]")).click();
		
		//if we do not want to use indexing, use parent-child relationship xpathnas follows: //parentxpath //childxpath
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value=\"IXL\"]")).click();
		
		//select the current date from calendar
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

	}

}
