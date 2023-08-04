package ECommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ECommerce.BaseComponents.AbstractComponentsTestBase;

public class ProductCatalog extends AbstractComponentsTestBase{
	WebDriver driver;
	//Constructor
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Here we are defining page objects/webelements/locators for ProductCAtaloguePage
		//WebElements
		@FindBy(css=".mb-3")
		List<WebElement> productsList;
		
		@FindBy(css=".ng-animating")
		WebElement spinner;
		
		//By Locators
		By product=By.cssSelector(".mb-3");
		By addToCartBtn=By.cssSelector(".card-body button:last-of-type");
		By toastMsg=By.cssSelector("#toast-container");
		
		//This method is used to get and return  productList
		public List<WebElement> getProductList()
		{
			waitForElementToAppear(product);
			return productsList;
			
		}
		
		//This method is used to find a particular product and return it
		public WebElement getProdName(String prodname) {
			
			WebElement product1=getProductList().stream().
					filter(prod->prod.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(prodname)).findFirst().orElse(null);
			return product1;
		}
		
		//This method is used to add particular product which is passed as argument to  cart
		public void addToCart(String prodname) throws InterruptedException
		{
			WebElement productname=getProdName(prodname);
			productname.findElement(addToCartBtn).click();
			waitForElementToAppear(toastMsg);
			waitForElementToDisappear(spinner);
		}
}
