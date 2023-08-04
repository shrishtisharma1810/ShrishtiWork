package TestNGFramework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic_2 {
	@BeforeClass
	public void BeforeClass1()
	{
		System.out.println("I am executed before any test in this java class");
	}
	@AfterClass
	public void AfterClass1()
	{
		System.out.println("I am executed after any test in this java class");
	}
	@BeforeTest
	public void BeforeTest1()
	{
		System.out.println("I am executed before every test in the module");
	}
	@AfterTest
	public void AfterTest1()
	{
		System.out.println("I am executed after all tests in the module");
	}
	@BeforeSuite
	public void BeforeSuite1()
	{
		System.out.println("I am executed before all test in the suite");
	}
	@AfterSuite
	public void AfterSuite1()
	{
		System.out.println("I am executed after all test in the suite");
	}
	@BeforeMethod
	public void BeforeMethod1()
	{
		System.out.println("I am executed before all methods in the test in this module, i am applicable at java class level");
	}
	@AfterMethod
	public void AfterMethod1()
	{
		System.out.println("I am executed after all methods in the test in this module, i am applicable at java class level");
	}
	
	@Test
	public void forth()
	{
		System.out.println("forth");
		
	}

	@Test(timeOut = 5000)
	public void fifth()
	{
		System.out.println("fifth");
	}
	@Test
	public void sixth()
	{
		System.out.println("sixth");
	}
	@Parameters({"URL"})
	@Test
	public void seventh(String url)
	{
		System.out.println("seventh");
		System.out.println(url);
	}
	@Test(dependsOnMethods = {"sixth","seventh"})
	public void eight()
	{
		System.out.println("eight");
	}
	
	@Test(dataProvider = "getData")
			
	public void ninth(String uname, String pwd)
	{
		System.out.println("ninth");
		System.out.println(uname);
		System.out.println(pwd);
	}
	@Test(enabled=false)
	public void tenth()
	{
		System.out.println("tenth");
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="firstuname";
		obj[0][1]="firstpwd";
		
		obj[1][0]="seconduname";
		obj[1][1]="secondpwd";
		
		obj[2][0]="thirduname";
		obj[2][1]="thirdpwd";
		return obj;
		
	}
}
