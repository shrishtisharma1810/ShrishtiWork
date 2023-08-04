package ECommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ECommerce.BaseComponents.AbstractComponentsTestBase;

public class ConfirmationPage extends AbstractComponentsTestBase {
	WebDriver driver;	
	
	//constructor
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Here we are defining page objects/ webelements/locator for confirmation page
	@FindBy(css=".hero-primary ")
	WebElement msg;
	
	
	//This method is used to get and return the confirmation message
	public String getConfirmationMessage() {
		return msg.getText();
	}
	
	//driver.close()

}
