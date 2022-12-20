package second;

import java.util.Arrays;
import java.util.Scanner;

public class CCC16S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		int Q = SC.nextInt();
		int N = SC.nextInt();
		int[] one = new int[N];
		int[] two = new int[N];
		int[] A = new int[N*2];
		int total = 0;
		
		for (int i=0; i<N; i++) {
			one[i] = SC.nextInt();
			A[i] = one[i];
		}
		for (int i=0; i<N; i++) {
			two[i] = SC.nextInt();
			A[i+N] = two[i];
		}
		Arrays.sort(one);
		Arrays.sort(two);
		Arrays.sort(A);
		
		if (Q == 1) {
			for (int i=0; i<N; i++) {
				total += Math.max(one[i], two[i]);
			}
		}
		else {
			for (int i=N; i<N*2; i++) {
				total += A[i];
			}
		}
		
		System.out.println(total);
	}

}
