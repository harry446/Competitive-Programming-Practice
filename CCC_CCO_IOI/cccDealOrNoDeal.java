package second;

import java.util.Scanner;

public class cccDealOrNoDeal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		       //B[0]  B[1] B[2]  B[3]   B[4]   B[5]   B[6]   B[7]    B[8]    B[9]
		int[] B = {100, 500, 1000, 5000, 10000, 25000, 50000, 100000, 500000, 1000000};
		
		Scanner SC = new Scanner(System.in);
		
		int n = SC.nextInt();
		//remove n briefcase
		//repeat n times
		for (int i=0; i<n; i++){
			int b = SC.nextInt();
			B[b-1] = 0;	
			
		}
		int total = 0;
		for (int i=0; i<B.length; i++){
			total = total + B[i];
			int a = total/(10-n);
			
		}
		
		
		
		
	}

}
