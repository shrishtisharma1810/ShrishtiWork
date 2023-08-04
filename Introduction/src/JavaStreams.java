import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams {

	public static void main(String[] args) {
		/*
		ArrayList<String> names=new ArrayList<String>();
		names.add("Neha");
		names.add("Neelam");
		names.add("Nikita");
		names.add("Sadhana");
		names.add("Ganesh");
		int count=0;
		for(String name:names)
		{
			if(name.startsWith("N"))
				count++;
		}
		System.out.println("No os names starting with N are: "+count);
*/
	}
	@Test
	public void Count() {
		ArrayList<String> names=new ArrayList<String>();
		names.add("Neha");
		names.add("Neelam");
		names.add("Nikita");
		names.add("Sadhana");
		names.add("Ganesh");
		Long cnt=names.stream().filter(n->n.startsWith("N")).count();
		System.out.println(cnt);
		
		Long d=Stream.of("Neha","Neelam","Nikita","Sadhana","Ganesh").filter(n->n.startsWith("N")).count();
		System.out.println(d);
		
		Long e=Stream.of("Neha","Neelam","Nikita","Sadhana","Ganesh").filter(n->
		{
			n.startsWith("N");
			return false;
		}).count();
		System.out.println(e);
		
		//now suppose we want to print all elements from list where length>4 but without using for loop
		//we are applying filter two times and then out of all applicable names we are only printing first/1 name as limit is set to 1
		names.stream().filter(s->s.startsWith("N")).filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
	}
	@Test
	public void map()
	{
		ArrayList<String> names1=new ArrayList<String>();
		names1.add("Minu");
		names1.add("Maharshi");
		names1.add("Sunaina");
		
		Stream.of("Neha","Neelam","Nikita","Sadhana","Ganesh").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		System.out.println("\n");
		
		List<String>names=Arrays.asList("Neha","Neelam","Nikita","Sadhana","Ganesh");
		names.stream().filter(s->s.startsWith("N")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		System.out.println("\n");		
		
		//Merging two streams
		Stream<String> mergedStream=Stream.concat(names.stream(),names1.stream());
		//mergedStream.sorted().forEach(s->System.out.println(s));
		System.out.println("\n");
		
		boolean flag=mergedStream.anyMatch(s->s.equalsIgnoreCase("Sadhana"));
		Assert.assertTrue(flag);
	}
	@Test
	public void streamCollect()
	{
		//collect methos is used to convert stream back to list/ map/set etc
		List<String> ls=Stream.of("Neha","Neelam","Nikita","Sadhana","Ganesh").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
				.collect(Collectors.toList());
		
		System.out.println(ls.get(2));
		System.out.println("\n");
		
		//create Stream of integers, filter distinct/unique elements, sort them and then print the 4th index
		List<Integer> intlist=Stream.of(4,1,6,9,0,1,2,6,7,11,5,7,8,6).distinct().sorted().collect(Collectors.toList());
		//System.out.println(intlist.get(0));
		//System.out.println(intlist.get(1));
		//System.out.println(intlist.get(2));
		//System.out.println(intlist.get(3));
		System.out.println(intlist.get(4));
	}

}
