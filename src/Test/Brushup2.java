package Test;

public class Brushup2 {

	public static void main(String[] args) {
		// String is an object
		
		// we have two types of strings - String literal and string new
	    // in string literal we cannot initiate a string with same data 
		// In string object if we create a string using new it can be possible 
		// In String literal no matter how many string you create if the content is same consider as one bj
		
		
		//String literal 
		
		//String A = "Ajay";
		//String A1 = "Ajay";
		
		//String new
		
		//String name = new String("Ajay");
		//String name1 = new String("Ajay");
		
		// Converting a string in to an array by 

		String username = "Ajay Mareedu Automation";
		String [] SplitedUsername = username.split("Mareedu"); // . split will be used to slit
		System.out.println(SplitedUsername[0]);
		System.out.println(SplitedUsername[1]);
		System.out.println(SplitedUsername[1].trim()); // trim is used to clear before and after spaces
		System.out.println(username.charAt(0)); //charAt is used to get only one character in the string
	
		
		// Iteration of string char
		
		for (int i=0; i<username.length();i++) {
			
			System.out.println(username.charAt(i));
		}
		
		// reverse string values
		
		for (int i=username.length()-1; i>=0;i--) {
			
			System.out.println(username.charAt(i));
		}
		
		
		
		
		
		
		
		
		
		
	

	}

}
