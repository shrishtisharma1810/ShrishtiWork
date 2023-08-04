package TestNGFramework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class basic {
	@BeforeTest
	public void prerequisite()
	{
		System.out.println("I will be executed before any other test in this module/test folder gets executed");
	}
	@AfterTest
	public void lastexecution()
	{
		System.out.println("I will be executed after all other test in this module/test folder gets executed, mostly used for cleanup");
	}
	@Test
	public void first()
	{
		System.out.println("first");
	}
	@Parameters({"URLBasic"})
	@Test(groups= {"Smoke"})
	public void second(String url)
	{
		System.out.println("second");
		System.out.println(url);
	}
}
