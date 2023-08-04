package ECommerce.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ECommerce.TestComponents.BaseTest;
import ECommerce.TestComponents.RetryTest;
import ECommerce.pages.CartPage;
import ECommerce.pages.CheckOutPage;
import ECommerce.pages.ConfirmationPage;
import ECommerce.pages.LandingPage;
import ECommerce.pages.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorMessageValidation extends BaseTest{
	
			@Test(groups = {"ErrorHandling"},retryAnalyzer = RetryTest.class)
			public void getErrorMessage() 
			{
				landingPage.login("shrishti@gmail.com","Ngs@1234");
				Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage().getText());
				
			}

			@Test
			public void productErrorValidation() throws InterruptedException {
				String prodname2="ZARA COAT 3";
				
				
				//this is not required as we have added Beforemethod for launchapplication in testbase
				//LandingPage landingPage=launchapplication();
				//enter email, pwd as paassed in argument and login
				ProductCatalog productCatalog=landingPage.login("shrishti@gmail.com","Ngs@1234");
							
				//get productlist
				List<WebElement> prodlist=productCatalog.getProductList();
				
				productCatalog.addToCart(prodname2);
				
				//gotocart page
				CartPage cartPage=productCatalog.goTocartPage();
				
				//check if product is found in cart
				Boolean flag=cartPage.verifyProductFound(prodname2);
				Assert.assertTrue(flag);
			}
	}


