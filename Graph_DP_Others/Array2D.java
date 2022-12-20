package second;
import java.util.Scanner;
public class Array2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] A = new char[3][2];

		A[0][0] = 'A';
		A[0][1] = 'B';
		A[1][0] = 'C';
		A[1][1] = 'D';
		A[2][0] = 'E';
		A[2][1] = 'F';

		for (int row=0; row<3; row++){
			for (int col=0; col<2; col++){
				System.out.print(A[row][col]);
			}
			System.out.println();
		}
		
		
		char[][] B = new char[2][4];
		
		B[0][0] = 'A';
		B[0][1] = 'B';
		B[0][2] = 'C';
		B[0][3] = 'D';
		
		B[1][0] = 'E';
		B[1][1] = 'F';
		B[1][2] = 'G';
		B[1][3] = 'H';
		
		for (int row=0; row<2; row++){
			for (int col=0; col<4; col++){
				System.out.print(B[row][col]);
			}
			System.out.println();
		}
		
		
	}

}
