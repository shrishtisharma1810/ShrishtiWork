import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarGeneric {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		// Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://www.path2usa.com/travel-companions");

		WebElement calendar = driver.findElement(By.id("form-field-travel_comp_date"));

		// Bring WebElement within the Viewport (user's visible area of web page)
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", calendar);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.elementToBeClickable(calendar));

		calendar.click();

		while (!driver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText().contains("June"))

		{

			Thread.sleep(2000);

			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();

		}

		int count = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();

		for (int i = 0; i < count; i++)

		{

			Thread.sleep(2000);

			String text = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();

			if (text.equalsIgnoreCase("26"))

			{

				driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();

				System.out.println("The select day is:" + text);

				break;

			}

		}

		String date = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).getAttribute("value");

		System.out.println("The select date is:" + date);

	}

}
