
public class JavaDataTypes {

	public static void main(String[] args) {
		int rollno=1;
		String name="Neha Sharma";
		double marks=99.99;
		char grade='A';
		System.out.println("Roll Number is:"+rollno);
		System.out.println("Name:"+name);
		System.out.println("Marks:"+marks);
		System.out.println("Grade:"+grade);
		
		/************Arrays************/
		int[] arr=new int[6];
		arr[0]=10;
		arr[1]=11;
		arr[2]=12;
		arr[3]=13;
		arr[4]=14;
		arr[5]=15;
		int[] arr1= {10,20,30,40,50,60,70,80,90,100};
		System.out.println("Third element of Array 1:"+arr[2]);
		System.out.println("Forth Element of Array 2:"+arr1[3]);
		
		/***********For Loop********************/
		// Print first array
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
		//Print second array
		for(int i=0;i<arr1.length;i++)
		{
			System.out.println(arr1[i]);
		}
		
		//Print String array Method 1
		String[] names= {"Neha","Shrishti","Deepak","Devyani"};
		for(int i=0;i<names.length;i++)
		{
			System.out.println(names[i]);
		}
		
		//Print String array Method 2
		for(String s:names)
		{
			System.out.println(s);
		}
		

	}

}
