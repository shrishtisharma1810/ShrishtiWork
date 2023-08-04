package ECommerce.tests;

import java.io.IOException;
import java.util.ArrayList;

public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		dataDrivenUsingExcel data=new dataDrivenUsingExcel();
		ArrayList a=data.getData("SignUp");
		System.out.println(a.get(0));
		System.out.println(a.get(1));
		System.out.println(a.get(2));
		System.out.println(a.get(3));
	}

}
