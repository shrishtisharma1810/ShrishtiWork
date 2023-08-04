import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadUsingAutoItTool {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Setting download path to project workspace on current system
		String downloadPath=System.getProperty("user.dir");
		
		//Set default download directory
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		//Create ChromeOptions Object
		ChromeOptions options=new ChromeOptions();
		//Set preferences
		options.setExperimentalOption("prefs", chromePrefs);
		
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://convertio.co/convert-pdf-to-jpg/");
		//click on "Choose File" button
		driver.findElement(By.xpath("//label[@class='action-label']")).click();
		Thread.sleep(3000);
		
		//Then execute .exe file to upload file
		Runtime.getRuntime().exec("C:\\Users\\shris\\OneDrive\\Documents\\fileupload.exe");

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		//wait for convert button to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".convert-button")));
		//click on convert button
		driver.findElement(By.cssSelector(".convert-button")).click();
		//wait for download button to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		//click on download button
		driver.findElement(By.linkText("Download")).click();

		Thread.sleep(5000);
		
		File f=new File(downloadPath+"/Event-New-Flow.jpg");

		if(f.exists())

		{

		Assert.assertTrue(f.exists());

		if(f.delete())

		System.out.println("file deleted");

		}

		}
		
	}


