import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password=getPassword(driver);
		Thread.sleep(1000);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//Using By.id("idvalue")
		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");

		//Using By.name("namevalue")
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		
		//Using By.classname("classnamevalue") any one value can be used if there are spaces in classname
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		String welcomemsg=driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(welcomemsg,"You are successfully logged in.");
		String name="Rahul";
		Assert.assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Hello "+name+ ",");		

	}
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		//Using By.cssSelector("tagname childattribute1 childattribute2:nth-child(index)"))
		driver.findElement(By.cssSelector("form div button:nth-child(2)")).click();
		String pwdtxt=driver.findElement(By.cssSelector("form p")).getText();
		String[] pwdtxt1=pwdtxt.split("'");
		String password=pwdtxt1[1].split("'")[0];
		return(password);
		
	}

}
