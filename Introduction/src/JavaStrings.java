
public class JavaStrings {

	public static void main(String[] args) {
		//These are String literals, created without new keyword, if value is same will point to same location
		String s="Hello Neha";
		String s1="Hello Neha";
		//Note if no of string objects are created with same value, only one memory allocation is made by java
		//and all objects will point to it.
		String s2=new String("Welcome Neha");
		String s3=new String("Welcome Neha");
		//These are String objects created using new keyword, even if value is same it creates separate object and memory for both s2 and s3
		String s4=new String("Rahul Shetty Academy !!!!!");
		
		//Spilt string considering space as delimiter
		String[] s5=s4.split(" ");
		for(int i=0;i<s5.length;i++)
			System.out.println(s5[i]);
		
		//Spilt string considering Shetty as delimiter and remove/trim the leading space before Academy
				String[] s6=s4.split("Shetty");
				System.out.println(s6[0]);
				System.out.println(s6[1].trim());

		//Print all elements of string character by character
		for(int i=0; i<s2.length();i++)
			System.out.println(s2.charAt(i));
		
		//Print all elements of string character by character in reverse order
		for(int i=s2.length()-1;i>=0; i--)
			System.out.println(s2.charAt(i));
	}

}
