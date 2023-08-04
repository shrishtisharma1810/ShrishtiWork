package JavaConcepts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Parent {
	@Test
	public void parent() {
		System.out.println("I am Parent class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am Before Method defined in parent class");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("I am After Method defined in parent class");
	}
}
