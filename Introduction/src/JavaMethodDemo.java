
public class JavaMethodDemo {

	public static void main(String[] args) {
		JavaMethodDemo obj=new JavaMethodDemo();
		obj.getData();
		String name=obj.getData1();
		System.out.println(name);
		getData2();

	}
public void getData()
{
	System.out.println("hello");
}

public String getData1()
{
	return("Neha");
}

//If modifier is static then there is no need to access method with object. directly we can give method name
public static void getData2()
{
	System.out.println("hello");
}
}
