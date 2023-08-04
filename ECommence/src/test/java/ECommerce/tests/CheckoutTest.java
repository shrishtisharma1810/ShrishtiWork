package ECommerce.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ECommerce.TestComponents.BaseTest;
import ECommerce.pages.CartPage;
import ECommerce.pages.CheckOutPage;
import ECommerce.pages.ConfirmationPage;
import ECommerce.pages.LandingPage;
import ECommerce.pages.OrderPage;
import ECommerce.pages.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutTest extends BaseTest{
	//String prodname="ADIDAS ORIGINAL";
	String prodname="ZARA COAT 3";
	
			@Test(dataProvider = "getData", groups = {"loginTest"})
			//public void EcommerceE2E(String Email, String password, String prodname) throws IOException, InterruptedException
			public void EcommerceE2E(HashMap<String, String> input) throws IOException, InterruptedException
			{
				
				/*WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				*/
				//String prodname1="ADIDAS ORIGINAL";
				//String prodname2="ZARA COAT 3";
				
				
				//this is not required as we have added Beforemethod for launchapplication in testbase
				//LandingPage landingPage=launchapplication();
				//enter email, pwd as paassed in argument and login
				//ProductCatalog productCatalog=landingPage.login(Email,password);
				ProductCatalog productCatalog=landingPage.login(input.get("Email"),input.get("password"));
							
				//get productlist
				List<WebElement> prodlist=productCatalog.getProductList();
				
				//add 2 products to cart
				//productCatalog.addToCart(prodname);
				productCatalog.addToCart(input.get("prodname"));
				Thread.sleep(2000);
				//productCatalog.addToCart(prodname2);
				
				//gotocart page
				CartPage cartPage=productCatalog.goTocartPage();
				
				//check if product is found in cart
				//Boolean flag=cartPage.verifyProductFound(prodname);
				Boolean flag=cartPage.verifyProductFound(input.get("prodname"));
				Assert.assertTrue(flag);
				
				//click on checkout and gotocheckoutpage
				CheckOutPage checkOutPage=cartPage.goToCheckOut();
				
				//enter country and submit order
				checkOutPage.selectCountry("India");
				ConfirmationPage confirmationPage=checkOutPage.submitOrder();
				
				//confirm order success with confirmation msg
				String confirmMsg= confirmationPage.getConfirmationMessage();
						
				Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			
			}
			@Test(dependsOnMethods = {"EcommerceE2E"})
			public void OrderHistory() throws InterruptedException {
				
				ProductCatalog productCatalog=landingPage.login("shrishti@gmail.com","Ngs@1234");
				OrderPage orderPage=productCatalog.goToOrderPage();	
				Thread.sleep(2000);
				Assert.assertTrue(orderPage.verifyOrderFound(prodname));
				
			}
			
			// One way to use data provider is to use it as below.This is basic simpe way useful when there are very few inputs
			/*
			@DataProvider
			public Object[][] getData() {
				return  new Object[][] {{"shrishti@gmail.com","Ngs@1234","ADIDAS ORIGINAL"},{"shetty@gmail.com","Iamking@000","ZARA COAT 3"}};
				
				
			}
			*/
			
			//Another way is to use HashMap as below. useful when more no of inputs
			/*
			@DataProvider
			public Object[][] getData() throws IOException {
				
				HashMap<String, String> map=new HashMap<String, String>();
				map.put("Email","shrishti@gmail.com");
				map.put("password","Ngs@1234");
				map.put("prodname","ADIDAS ORIGINAL");
				
				HashMap<String, String> map1=new HashMap<String, String>();
				map1.put("Email","shetty@gmail.com");
				map1.put("password","Iamking@000");
				map1.put("prodname","ZARA COAT 3");
			}
			*/				
			
			//third way is to pass inputs from a json file
			
			@DataProvider
			public Object[][] getData() throws IOException {
				
				List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\ECommerce\\data\\loginData.json");
				return new Object[][] {{data.get(0)},{data.get(1)}};
								
				
			}
			
		
	}


