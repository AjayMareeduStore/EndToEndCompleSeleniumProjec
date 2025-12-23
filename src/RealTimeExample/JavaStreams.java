package RealTimeExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class JavaStreams {

	// Filter an array and get which has first letter as A and count those names
	// Change the name all into Uppercase
	// get only first value
	// merge two arrays
	// try to print all the names in sorted way
	// print unique numbers avoiding duplicates
	// get only first value after the sorting and removing duplicates
	// get only 3 value after sorting

	@Test
	public static void javaStreams1() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Ajay");
		names.add("Mareedu");
		names.add("Arun");
		names.add("Harshi");
		names.add("Durga");
		names.add("Lakshmi");

		// Filter an array and get which has first letter as A and count those names

		// Need to convert the list into stream
		// Give a intermidiate method using lamda expression
		// .count is an termial operation

		// Intermidiate opeation doesnt work if there is no terminal operation
		// whereas terminal opearion can only work as per the intermiditiate operation
		// returns true
		long value = names.stream().filter(s -> s.startsWith("A")).count();
		//System.out.println(value);

	}

	public static void javastreams2() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Ajay");
		names.add("Mareedu");
		names.add("Arun");
		names.add("Harshi");
		names.add("Durga");
		names.add("Lakshmi");

		List<String> newList = Arrays.asList("Sharan", "Rahesh","Ramu", "Ramu", "Laxman", "Kishore", "Durga");
		
		
		//limiting the output
		newList.stream().filter(s->s.equalsIgnoreCase("Ramu")).limit(2).forEach(s->System.out.println(s));

		// for each is a terminal operation to print the result
		//Stream.of("Ajay", "Mareedu", "Aruna", "Kumar", "Kishore", "Durga").filter(s -> s.endsWith("a"))
			//	.forEach(s -> System.out.println(s));
		
	

		//merged two collection and changes the character to Uppercase
		Stream<String> merged = Stream.concat(newList.stream(), names.stream());
		//merged.filter(s->s.endsWith("i")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		
		//collect as a list after validating
		//merged.filter(s->s.contains("e")).collect(Collectors.toList()).forEach(s->System.out.println(s));
		
		//sorted and verified duplicate in the value
		
		Stream<Integer> values = Stream.of(1,2,4,4,5,5,3,6,6,6,8,8,7);
		//values.distinct().forEach(s->System.out.println(s));
		
		//values.distinct().sorted().forEach(s->System.out.println(s));
		
		
		
		
		

	}

	public static void main(String[] args) {

		javaStreams1();
		javastreams2();

	}

}
