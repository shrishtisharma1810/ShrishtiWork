package TestNGFramework;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic_1 {
	@Parameters({"URLBasic_1"})
	@Test(groups= {"Smoke"})
	public void third(String url)
	{
		System.out.println("third");
		System.out.println(url);
	}

}
