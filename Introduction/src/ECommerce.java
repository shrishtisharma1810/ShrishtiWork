import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ECommerce {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//Use of Implicit/global Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//Explicit Wait
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String[] itemsToBeAddedToCart= {"Cucumber","Tomato", "Capsicum", "Carrot"};
		
		//method call to add items to cart
		addItem(driver, itemsToBeAddedToCart);
		
		//click on cart button
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		//click on Proceed to Checkout button
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		//Add explicit wait to ensure text box is visible
		//By.cssSelector(".promoCode") is locator and driver.findElement(By.cssSelector(".promoCode")) is WebElement
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		
		//add promocode
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		
		//click on Apply button
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		//apply explicit wait again
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".promoInfo")));
		//Verify the promoinfo as Code applied and print it
		String promoInfo=driver.findElement(By.cssSelector(".promoInfo")).getText();
		System.out.println(promoInfo);
		Assert.assertEquals(promoInfo, "Code applied ..!");
		
		//click on place order button
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		//Verify label after clicking Place Order and print it
		String VerifyCountrylblafterorder=driver.findElement(By.xpath("//label[text()='Choose Country']")).getText();
		System.out.println(VerifyCountrylblafterorder);
		Assert.assertEquals(VerifyCountrylblafterorder, "Choose Country");
		
		//get dropdown locator
		WebElement selectCountrydropdown=driver.findElement(By.xpath("//select[@style='width: 200px;']"));
		Select selectCountry=new Select(selectCountrydropdown);
		
		//select India from dropdown
		selectCountry.selectByValue("India");
		
		//verify if india is selected and print it
		System.out.println(selectCountry.getFirstSelectedOption().getText());
		Assert.assertEquals(selectCountry.getFirstSelectedOption().getText(), "India");
		
		//click on checkbox to agree
		driver.findElement(By.cssSelector(".chkAgree")).click();
		
		//verify if checkbox is selected
		Assert.assertEquals(driver.findElement(By.cssSelector(".chkAgree")).isSelected(), true);
		
		//click on proceed button
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		//verify and print if user is redirected to home page
		String verifyHomepage=driver.findElement(By.cssSelector(".brand.greenLogo")).getText();
		System.out.println(verifyHomepage);
		Assert.assertEquals(verifyHomepage.contains("GREEN"), true);
		
		}
	public static void addItem(WebDriver driver, String[] itemsToBeAddedToCart)
	{
		//Get all products into prod_list
		List<WebElement> prod_list=driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		
		for(int i=0;i<prod_list.size();i++)
		{
			//String prod_name=prod_list.get(i).getText();
			//Here the issue is prod name is getting value like "Cucumber -1 kg" but we want only Cucumber 
			//so here we use string functions
			String[] prod_name_current=prod_list.get(i).getText().split("-");
			//prod_name_current[0]: Cucumber 
			//prof_name-Current[1]: 1 kg
			String itemName=prod_name_current[0].trim();
			//will trim all leading or trailing spaces
			
			
			//Here we are converting array to array list
			List<String> itemsNeeded=Arrays.asList(itemsToBeAddedToCart);
			//this works if single item is to be added to cart
			/*if(prod_name.contains("Cucumber"))
			{
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				break;
			}*/
			int j=0;
			//this works if multiple items are to be added to cart
			if(itemsNeeded.contains(itemName))
			{
				//even though we are using driver.findElements methods we are inside block and using index to click only on particular button
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				j++;
				
				//this check is needed to avoid unnecessary iterations.
				//If all itesm are added to card then no need to go through all 30 items
				if(j==itemsToBeAddedToCart.length)
					break;
			}

	}

}
}
