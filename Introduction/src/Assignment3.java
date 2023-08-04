import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//Explicit Wait
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//extract username from page in variable
		String username=driver.findElement(By.xpath("//i[text()='rahulshettyacademy']")).getText();
		//enter username
		driver.findElement(By.cssSelector("#username")).sendKeys(username);
		
		//extract password from page
		String pwd=driver.findElement(By.xpath("//i[text()='learning']")).getText();
		//enter password
		driver.findElement(By.cssSelector("#password")).sendKeys(pwd);
		
		//click User radio button
		driver.findElement(By.xpath("//span[text()=' User']")).click();
		
		//explicit wait until button is clickable
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#okayBtn")));
		
		//click on button
		driver.findElement(By.cssSelector("#okayBtn")).click();
		
		//dropdownbox locator
		WebElement dropdownbox=driver.findElement(By.xpath("//select[@class='form-control']"));
		//click on dropdown
		dropdownbox.click();
		Select dropdown=new Select(dropdownbox);
		//select consultant from dropdown
		dropdown.selectByIndex(2);
		
		//Assert and verify the correct option is selected from dropdown and print it
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Consultant");
		
		//click on checkbox to agree terms n conditions
		driver.findElement(By.cssSelector("#terms")).click();
		
		//click on sign in button
		driver.findElement(By.cssSelector("input[name='signin']")).click();
		
		//explicit wait until text is visible
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='ProtoCommerce Home']")));
		//print the text
		System.out.println(driver.findElement(By.xpath("//a[text()='ProtoCommerce Home']")).getText());
		
		//extract all items
		List<WebElement> totalitems=driver.findElements(By.cssSelector(".card.h-100"));
		
		//using for loop click on all items
		for(int i=0; i<totalitems.size();i++)
		{
			driver.findElements(By.cssSelector(".btn.btn-info")).get(i).click();
		}
		//click on checkout button
		driver.findElement(By.cssSelector(".nav-item.active")).click();
		//again click on checkout button
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		//Verify checkout by printing text
		System.out.println("Verify checkout page"+driver.findElement(By.xpath("//label[text()='Please choose your delivery location. ']")));
		//Enter country in textbox
		driver.findElement(By.cssSelector("#country")).sendKeys("INDIA");
		//explicit wait till countryname is visible
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#country")));
		//click on country name
		driver.findElement(By.xpath("//a[text()='India']")).click();
		//click agree checkbox
		driver.findElement(By.cssSelector("label[for='checkbox2']")).click();
		//click purchase button
		driver.findElement(By.xpath("//input[@value='Purchase']")).click();
		//extract success message and print it
		String orderSuccessmsg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		System.out.println(orderSuccessmsg);
		
	}

}
