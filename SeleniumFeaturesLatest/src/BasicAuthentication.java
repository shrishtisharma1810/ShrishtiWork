import java.net.URI;
import java.time.Duration;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthentication {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		//creating uriPredicate obj with condition if hostname contains httpbin.org
		Predicate<URI> uriPredicate=uri->uri.getHost().contains("httpbin.org");
		
		//checking if driver has authentication, then register with username and password as foo and bar
		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo","bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");

	}

}
