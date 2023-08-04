package JavaConcepts;

import org.testng.annotations.Test;

public class Child extends Parent {
	@Test
	public void child() {
		ParameterizedConstructorDemo pc=new ParameterizedConstructorDemo(5);
		//int a=2;
		parent();
		System.out.println(pc.increment());
		System.out.println(pc.decrement());
		//Now suppose we have created another utility class for multiplication
		//one way is to use it just like increment/decrement as follows
		//ParameterizedConstructorDemoSuper pc1=new ParameterizedConstructorDemoSuper(2);
		//But what if we need to call it without creating new object
		//System.out.println(pc1.multiplyTwo());
		//System.out.println(pc1.multiplyThree());
		System.out.println(pc.multiplyTwo());
		System.out.println(pc.multiplyThree());
		
	}
	
}
