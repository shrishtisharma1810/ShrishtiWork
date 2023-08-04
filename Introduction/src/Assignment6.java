import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://www.qaclickacademy.com/practice.php");
		//click on option 3 checkbox
		driver.findElement(By.id("checkBoxOption3")).click();
		//verify if checkbox is selected
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption3")).isSelected());
		//print the checkbox label
		System.out.println("Selected Checkbox Label is:"+driver.findElement(By.cssSelector("label[for='honda']")).getText());
		
		//extract checkboxlabel in var
		String checkboxlabel= driver.findElement(By.cssSelector("label[for='honda']")).getText();
		//locator for dropdownbox
		WebElement dropdownbox=driver.findElement(By.id("dropdown-class-example"));
		//pass checkboxlabel in dropdownbox
		dropdownbox.sendKeys(checkboxlabel);
		
		//locator for alerttxtbox
		WebElement alrttxtBox=driver.findElement(By.id("name"));
		//pass checkbox label in alertbox
		alrttxtBox.sendKeys(checkboxlabel);
		driver.findElement(By.id("alertbtn")).click();
		String alertText=driver.switchTo().alert().getText();
		System.out.println("Alert Message: "+alertText);
		String namefromAlertMsg=alertText.split(",")[0].split(" ")[1];
		System.out.println("Name from Alert Message Text: "+namefromAlertMsg);
		Assert.assertEquals(namefromAlertMsg, checkboxlabel);
		driver.switchTo().alert().accept();
		
		
		
		
		
		

	}

}
