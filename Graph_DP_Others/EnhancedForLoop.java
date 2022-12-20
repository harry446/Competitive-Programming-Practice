package second;

import java.util.Scanner;

public class EnhancedForLoop {

	public static void main (String[] arg) {
		
		Scanner SC = new Scanner (System.in);
		
		int[] A = new int[5];
		
		for (int i=0; i<5; i++) {
			A[i] = SC.nextInt();
		}
		 
		int total = 0;
		for (int i: A) {        //store the value of each index of the array in the int. 'i'
			total += i;         //add them into total;
		}
		
		System.out.println(total);
		
		
		//String
		String[] B = new String[2];
		
		for (int i=0; i<2; i++) {
			B[i] = SC.next();
		}
		
		String S = "";
		for (String i: B) {
			S += i + ". ";
			System.out.println(i);
		}
		
		System.out.println(S);
		
		
	}
}
