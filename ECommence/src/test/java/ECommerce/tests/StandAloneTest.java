package ECommerce.tests;
import java.time.Duration;
import org.testng.Assert;

import ECommerce.pages.LandingPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://rahulshettyacademy.com/client/");
			driver.findElement(By.id("userEmail")).sendKeys("shrishti@gmail.com");
			driver.findElement(By.id("userPassword")).sendKeys("Ngs@1234");
			driver.findElement(By.id("login")).click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
			List<WebElement> productsList=driver.findElements(By.cssSelector(".mb-3"));
			WebElement product1=productsList.stream().
					filter(prod->prod.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("adidas original")).findFirst().orElse(null);
			product1.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
			WebElement product2=productsList.stream().
					filter(prod->prod.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("ZARA COAT 3")).findFirst().orElse(null);
			
			product2.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
			
			driver.findElement(By.cssSelector("button[routerlink*=\"cart\"]")).click();
			
			List<WebElement> cartItems=driver.findElements(By.cssSelector(".cartSection h3"));
			Boolean flag=cartItems.stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase("ZARA COAT 3"));
			Assert.assertTrue(flag);
			WebElement checkoutBtn=driver.findElement(By.cssSelector(".totalRow button"));
			try {
				checkoutBtn.click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", checkoutBtn);
			  }

			//driver.findElement(By.cssSelector("[placeholder=\"Select Country\"]")).sendKeys("India");
			//or we can use Action class as shown below
			Actions a=new Actions(driver);
			a.sendKeys(driver.findElement(By.cssSelector("[placeholder=\"Select Country\"]")), "India").build().perform();
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results :nth-of-type(2)")));
			driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
			driver.findElement(By.cssSelector(".action__submit ")).click();
			String confirmMsg=driver.findElement(By.cssSelector(".hero-primary ")).getText();
			Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			//driver.close();

		}

	}



