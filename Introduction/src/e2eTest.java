import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class e2eTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(1000);
		//click on One Way Radio button
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
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
		
		System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("style"));
		
		//click on Round Trip radio button
		driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_rbtnl_Trip_1\"]")).click();
		
		//still the radio button of One Way is returning true even though it is not selected so its not enabled
		//System.out.println(driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_rbtnl_Trip_0\"]")).isEnabled());

		//in such cases we need to observe the DOm carefully to check what is changing
		//here the Return date date picker is getting highlighted and dehighlighted on switching radio buttons 
		//and its opacity is changing from 0.5 to 1
		
		//check the return date style attribute again
		System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("style"));
		if(driver.findElement(By.cssSelector("#Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("Is disabled");
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
		
		//System.out.println(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		//instead of this step we can use assertion
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='IndArm']")).click();
		//System.out.println(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		//System.out.println("No of checkboxes on the page:"+ driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);
		Thread.sleep(1000);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for(int i=0;i<4;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.cssSelector("input[name='ctl00$mainContent$btn_FindFlights']")).click();
		
		
}

	}


