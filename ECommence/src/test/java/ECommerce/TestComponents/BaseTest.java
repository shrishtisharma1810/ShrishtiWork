package ECommerce.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ECommerce.pages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException {
		
	//load properties from properties file
	Properties prop=new Properties();
	//FileInputStream fis=new FileInputStream("C:\\Users\\shris\\Udemy\\ECommence\\src\\main\\java\\ECommerce\\Properties\\GlobalData.properties");
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ECommerce\\Properties\\GlobalData.properties");
	prop.load(fis);
	//String browserName=prop.getProperty("browser");
	//ternary operator
		//if property is passed through command then use that property otherwise use from properties file
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
	//to run tests in headed mode i.e browser will open everytime and u will see tests running
	/*
	if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	*/
	
    //to run tests in headless mode
	if(browserName.contains("chrome")) {
		ChromeOptions options=new ChromeOptions();		
		WebDriverManager.chromedriver().setup();
		if(browserName.contains("headless"))
		{
			options.addArguments("headless");			
		}
		driver=new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1440,900));
	}
	else if(browserName.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	else if(browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	return driver;

	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		//read json to string
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		//json string to hashmap using jackson databind
		 ObjectMapper objectMapper = new ObjectMapper();

	        
	    // Convert the JSON string to a HashMap
	     List<HashMap<String, String>> data = objectMapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});

	      
	    return data;
	}
	
	//This utility will be used to take screenshot and return the path where screenshot is saved
		public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dst=new File(System.getProperty("user.dir")+"\\Reports\\"+testCaseName+".png");
			FileUtils.copyFile(src, dst);
			return System.getProperty("user.dir")+" \\Reports\\ "+testCaseName+".png";
		}
		
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchapplication() throws IOException {
		driver=initializeDriver();
		//creating landing page obj
		landingPage=new LandingPage(driver);
		//goTo landing page
		landingPage.goTo();
		return landingPage;
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
	
}
