package second;

import java.util.Arrays;
import java.util.Scanner;

public class CCC17S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int N = SC.nextInt();
		int[] A = new int[N];
		
		for (int i=0; i<N; i++) {
			A[i] = SC.nextInt();
		}	
		Arrays.sort(A);

		if (N%2 == 0) {
			for (int i=N/2; i<N; i++) {
				System.out.print(A[N-i-1] + " ");
				System.out.print(A[i] + " ");
			}
		}
		else {
			System.out.print(A[N/2] + " ");
			for (int i=N/2; i<N-1; i++) {
				System.out.print(A[i+1] + " ");
				System.out.print(A[N-i-2] + " ");
			}
		}
		
	}

}
