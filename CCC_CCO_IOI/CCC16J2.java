package second;

import java.util.Scanner;

public class CCC16J2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int[][] A = new int [4][4];
		
		for (int row=0; row<4; row++){
			for (int col=0; col<4; col++){
				A[row][col] = SC.nextInt();
			}
		}
		
		boolean flag = true;
		int total = A[0][0] + A[0][1] + A[0][2] + A[0][3];
		
		for (int row=0; row<4; row++){
			int rowT = 0;
			int colT = 0;
			for (int col=0; col<4; col++){
				rowT = rowT + A[row][col];
				colT = colT + A[col][row];
			}
			if (total != colT || total !=rowT){
				flag = false;
				break;
			}
		}
		if (flag){
			System.out.println("magic");
		}
		else {
			System.out.println("not magic");
		}
		
		
		
		
		
		
	}

}
