import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//Using By.id("idvalue")
		driver.findElement(By.id("inputUsername")).sendKeys("Neha");
		
		//Using By.name("namevalue")
		driver.findElement(By.name("inputPassword")).sendKeys("Neha123");
		
		//Using By.classname("classnamevalue") any one value can be used if there are spaces in classname
		driver.findElement(By.className("signInBtn")).click();
		
		//Using By.cssSelector("tagname.classnamevalue") with classname
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//Using By.linkText("link text value")
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(1000);
		
		//Using By.xpath("//tagname[@attribute='attributevalue']))
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Neha");
		
		//Using By.cssSelector("tagname[attribute='attributevalue']))
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("neha123@gmail.com");
		
		//Using By.xpath("//tagname[@attribute='attributevalue'][index])) indexing is used when there are multiple elements matching
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		//Using By.cssSelector("tagname[@attribute='attributevalue']):nth-child(index))
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("neha@gmail.com");
		
		//Using By.xpath("//tagname/childattribute[index]"))
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9595033809");
		
		//Using By.cssSelector("tagname childattribute1 childattribute2:nth-child(index)"))
		driver.findElement(By.cssSelector("form div button:nth-child(2)")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		
		//Using By.cssSelector("#idvalue") here we are omitting tagname before #
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Neha");
		
		//Using By.cssSelector("tagname[attribute *='partialvalue') here we are writing * to indicate regular expression
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("#chkboxOne")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		//driver.close();

	}

}
