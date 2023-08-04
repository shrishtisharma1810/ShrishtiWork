import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowPopUp {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		//Syntax: "https://username:password@siteURL"
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();

	}

}
