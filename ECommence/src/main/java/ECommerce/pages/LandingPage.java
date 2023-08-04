package ECommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ECommerce.BaseComponents.AbstractComponentsTestBase;

public class LandingPage extends AbstractComponentsTestBase {
	
	WebDriver driver;
	//constructor
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//defining page objects or webelements/locators for landing page
	//driver.findElement(By.id("userEmail")).sendKeys("shrishti@gmail.com");
	@FindBy(id = "userEmail")
	WebElement Email;
	
	//driver.findElement(By.id("userPassword")).sendKeys("Ngs@1234");
	@FindBy(id = "userPassword")
	WebElement pwd;
	
	//driver.findElement(By.id("login")).click();
	@FindBy(id = "login")
	WebElement submitBtn;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMsg;
	
	public WebElement getErrorMessage() {
		waitForWebElementToAppear(errorMsg);
		errorMsg.getText();
		return errorMsg;
	}
	
	//This method will enter email, pwd, click on login button
	//since after login user goes to ProductCatalogue Page we are creating and returning productCataloguePage obj
	public ProductCatalog login(String uname, String password) {
		Email.sendKeys(uname);
		pwd.sendKeys(password);
		submitBtn.click();
		ProductCatalog productCatalog=new ProductCatalog(driver);
		return productCatalog;
	}
	
	//This method is used to goTo landing page
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

}
