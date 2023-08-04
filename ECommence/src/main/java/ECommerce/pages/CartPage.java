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

public class CartPage extends AbstractComponentsTestBase {
	WebDriver driver;
	
	//constructor
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	//Here we are defining page objects/webelemst/locators for cartPage
	@FindBy(css=".cartSection h3")
	List<WebElement> cartItems;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutBtn;
	
	//This method is used to check if the product that is passed as argument is found in cart or not
	//so it returns boolean value
	public Boolean verifyProductFound(String prodname) {
		Boolean flag=cartItems.stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase(prodname));
		return flag;
	}
	
	//this method is used to click on checkout button
	public CheckOutPage goToCheckOut() {
		try {
			checkoutBtn.click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", checkoutBtn);
		  }
		CheckOutPage checkOutPage=new CheckOutPage(driver);
		return checkOutPage;
	}
	


	}


