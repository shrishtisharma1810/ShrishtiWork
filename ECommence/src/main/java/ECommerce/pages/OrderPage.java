package ECommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ECommerce.BaseComponents.AbstractComponentsTestBase;

public class OrderPage extends AbstractComponentsTestBase {
	WebDriver driver;
	
	//constructor
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	//Here we are defining page objects/webelemst/locators for cartPage
	@FindBy(css="tr td:nth-child(2)")
	List<WebElement> productNames;
	
	
	//This method is used to check if the product that is passed as argument is found in cart or not
	//so it returns boolean value
	public Boolean verifyOrderFound(String prodname) {
		Boolean flag=productNames.stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase(prodname));
		return flag;
	}
	
}


