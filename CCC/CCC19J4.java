package second;

import java.util.Arrays;
import java.util.Scanner;

public class CCC19J4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		String S = SC.next();
		
		int[][] A = new int[2][2];  //original
		int[][] B = new int[2][2];  //one horizontal
		int[][] C = new int[2][2];  //one vertical
		int[][] D = new int[2][2];  //one horizontal, one vertical
		
		A[0][0] = 1;
		A[0][1] = 2;
		A[1][0] = 3;
		A[1][1] = 4;
		
		B[0][0] = 3;
		B[0][1] = 4;
		B[1][0] = 1;
		B[1][1] = 2;
		
		C[0][0] = 2;
		C[0][1] = 1;
		C[1][0] = 4;
		C[1][1] = 3;
		
		D[0][0] = 4;
		D[0][1] = 3;
		D[1][0] = 2;
		D[1][1] = 1;
		
		
		int Hcount = 0;
		int Vcount = 0;
		for (int i=0; i<S.length(); i++) {
			if (S.charAt(i) == 'H') {
				Hcount++;
			}
			else if (S.charAt(i) == 'V' ) {
				Vcount++;
			}
		}

		if (Hcount%2 == 0 && Vcount%2 == 0) {
			for (int row=0; row<2; row++) {
				for (int col=0; col<2; col++) {
					System.out.print(A[row][col] + " ");
				}
				System.out.println();
			}
		}
		else if (Hcount%2 != 0 && Vcount%2 == 0) {
			for (int row=0; row<2; row++) {
				for (int col=0; col<2; col++) {
					System.out.print(B[row][col] + " ");
				}
				System.out.println();
			}
		}
		else if (Hcount%2 == 0 && Vcount%2 != 0) {
			for (int row=0; row<2; row++) {
				for (int col=0; col<2; col++) {
					System.out.print(C[row][col] + " ");
				}
				System.out.println();
			}
		}
		else if (Hcount%2 != 0 && Vcount%2 != 0) {
			for (int row=0; row<2; row++) {
				for (int col=0; col<2; col++) {
					System.out.print(D[row][col] + " ");
				}
				System.out.println();
			}
		}
	}

}
