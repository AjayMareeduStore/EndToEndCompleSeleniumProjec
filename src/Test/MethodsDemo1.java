package Test;

public class MethodsDemo1 {

	public static void main(String[] args) {
		
		MethodsDemo1 data = new MethodsDemo1();
		data.GetData();
		System.out.println(data.GetData1());
		GetData2();

  

	}
	
	
	public void GetData() {  // Non Static no return type method
		
		
		System.out.println("Ajay Mareedu");
	}
	
public String GetData1() { // non static return type method
		
		
		System.out.println("Ajay Mareedu");
		return "Ajay";
	}
public static void GetData2() { //static non return type method
	
	
	System.out.println("Ajay Mareedu");
}

}
