import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IfElse {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8,9,10};
		
		/****for loop to print no only if its multiple of 2********/
		for(int i=0; i<arr.length;i++)
		{
			if((arr[i]%2)==0)
			{
				System.out.println(arr[i]);
				break;
			}
			else
				System.out.println(arr[i]+ "is not multiple of 2");
		}
		ArrayList<String> al=new ArrayList<String>();
		al.add("Neha");
		al.add("Sadhana");
		al.remove(0);
		System.out.println(al.get(0));
		al.add("Shrishti");
		al.add("Thuna");
		al.add("Deepak");
		/***********Method 1 to print elements from array list**********/
		for(String s:al)
			System.out.println(s);
		
		/***********Method 2 to print elements from array list**********/
		for(int i=0; i<al.size();i++)
			System.out.println(al.get(i));
		
		/*******************Check if element is present in arraylist*************/
		System.out.println(al.contains("Shrishti"));
		
		/********Convert String array into array list if you want to check if element is present or not in string array***********/
		String[] names= {"Era", "Eha","Neha","Shrishti", "Prithvi","Prakriti","Purusha"};
		List<String> nameList=Arrays.asList(names);
		System.out.println(nameList.contains("Prithvi"));

	}

}
