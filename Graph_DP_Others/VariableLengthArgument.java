package second;

import java.util.Scanner;

public class VariableLengthArgument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		

		System.out.println(AverageSum(SC.nextInt(), SC.nextInt())); 

		
		
		
	}
	
	public static int AverageSum (int... A) {       //enter as many arguements as I want
		
		int total = 0;
		for (int i:A) {
			total += i;
		}
		
		return total + (total/A.length);
		
	}

}
