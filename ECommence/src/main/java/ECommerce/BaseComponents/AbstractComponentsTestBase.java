package ECommerce.BaseComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ECommerce.pages.CartPage;
import ECommerce.pages.OrderPage;

public class AbstractComponentsTestBase {
	WebDriver driver;
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	//constructor
	public AbstractComponentsTestBase(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//this method will click on cart button and since after clicking user goes to cartPage, we are creating and return cartPage object
	public CartPage goTocartPage() throws InterruptedException {
		cartHeader.click();
		Thread.sleep(2000);
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrderPage() {
		orderHeader.click();
		OrderPage orderPage=new OrderPage(driver);
		return orderPage;
	}
	
	
	//Defining reusable methods for webdriver wait 
	public void waitForVisibilityOfAllElements(By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
	}
	public void waitForElementToAppear(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void waitForWebElementToAppear(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
}
