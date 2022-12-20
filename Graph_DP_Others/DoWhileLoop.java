package second;

public class DoWhileLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int count = 0;
		
		do {                                 //not much difference from "While Loop"
			System.out.println(count);
			count++;                
		}while (count<10);
		
		
		
		//however
		
		int count2 = 15;
		
		do {                                       //This will at least run once, because it will execute the code before
			System.out.println(count2 + " 2");     //Checking whether the argument is true or not
			count++;                               //Useful when you want the code to at least run once.
		}while (count<10);
		
		
	}

}
