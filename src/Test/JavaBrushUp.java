package Test;

public class JavaBrushUp {

	public static void main(String[] args) {


	  // Variables in Java
		
		/*int Mynum = 5;
		String Name = "Ajay";
		char cha = 'a';
		double F = 0.1;
		boolean myname = true;*/
		
		//arrays
		
		int [] arr= new int [5];
		
		arr[1] = 5;
		arr[4] = 2;
		
	    int [] arr2 =  {1,2,3,4,5};
	   
	    
	    
	    
	    // For Loop and enhanced for loop
	    
	    for(int i=0; i<arr2.length; i++ ) {
	    	
	    	
	    	//System.out.println(arr2[i]);
	    }
	    
	    //enhanced for loop 
	    
	    for (int i: arr2) {
	    	System.out.println(i);
	    }
	    
	    String [] name = {"ajay", "ramu", "krishna"};
	    
	    for(String i : name) {
	    	
	    if (i =="ramu") 
	    
	    {
	    
	    	System.out.println(i);
	    
	    }
	    }
	    
	    

	}

}
