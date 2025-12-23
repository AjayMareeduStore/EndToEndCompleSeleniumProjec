package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Brush1 {

	public static void main(String[] args) {
		
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Ajay");
		list.add("Kiran");
		String name = list.get(1);
		System.out.println(name);
		
		//Imp Note- if it is an normal array - .length - In iterations
		// if it is an arraylist we need to use - .size - In iterations
		
		for (int i=0;i<list.size();i++) {
			
			System.out.println(name);
			
		}
		
		for (String val :list) {  //enhanced for loop 
			
			System.out.println(val);
		}
		
		//Retrieve values from array by converting and array in array list using "Arrays"
		
		
		String [] NewList = {"ajay", "ramu", "krishna"};
		List<String> convertedlist = Arrays.asList(NewList);
		System.out.println(convertedlist.contains("ajay"));
		
	
		
	 

	}

}
