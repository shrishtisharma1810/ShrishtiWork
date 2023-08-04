package ECommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import ECommerce.BaseComponents.AbstractComponentsTestBase;

public class CheckOutPage extends AbstractComponentsTestBase {
	WebDriver driver;
	//constructor
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Here we are defining page objects/ webelements/locator for CheckOutPage
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectOption;
	
	@FindBy(css="[placeholder=\"Select Country\"]")
	WebElement selectCountryBox;
	
	@FindBy(css=".action__submit ")
	WebElement submitBtn;
	
	By countryOptions=By.cssSelector(".ta-results :nth-of-type(2)");
	//driver.findElement(By.cssSelector("[placeholder=\"Select Country\"]")).sendKeys("India");
	//or we can use Action class as shown below
	
	//This method is used to enter country
	public void selectCountry(String countryName) {
		Actions a=new Actions(driver);
		a.sendKeys(selectCountryBox, countryName).build().perform();
		waitForVisibilityOfAllElements(countryOptions);
		selectOption.click();
	}
	
	//This method is used to click on submit button
	//since user is taken to confirmation page after that we are creating and returning confirmation page obj
	public ConfirmationPage submitOrder() {
		submitBtn.click();
		ConfirmationPage confirmationPage=new ConfirmationPage(driver);
		return confirmationPage;
				
	}
	
}
