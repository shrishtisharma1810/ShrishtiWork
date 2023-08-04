import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScopeOfDriver {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//1. find out no of links on the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. Now suppose we want to find no of links from particular section only lets say header/footer
		//First create WEbElement for that
		WebElement footer=driver.findElement(By.id("gf-BIG"));
		System.out.println("No of links in footer section-->"+footer.findElements(By.tagName("a")).size());
		
		//3. Now suppose we want to find out no of links from first section/column
		
		//since we already have footer webelement inside that element navigate to first column which is td[1]/ul
		WebElement columnFromFooter=footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		//and then find out no of links
		System.out.println("No of links in first column in footer section-->"+columnFromFooter.findElements(By.tagName("a")).size());
		
		//4. Next task is to click on each link and validate if its working by grabbing its title
		//Use optimized code
		for(int i=1;i<columnFromFooter.findElements(By.tagName("a")).size();i++)
		{
			//we know simple trick that if we press shift and enter from keyboard by going to any link that link will open in new tab
			String openInNewTab=Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnFromFooter.findElements(By.tagName("a")).get(i).sendKeys(openInNewTab);
			Thread.sleep(2000);
			
		}
		//now links are open in different windows
		Set<String> windowhandles=driver.getWindowHandles();
		Iterator<String> it=windowhandles.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
