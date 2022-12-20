package second;

import java.util.Scanner;

public class CCC18S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int N = SC.nextInt();
		int[][] num = new int[N][N];
		int[][] temp = new int[N][N];
		boolean flag = true;
		
		for (int row=0; row<N; row++) {
			for (int col=0; col<N; col++) {
				num[row][col] = SC.nextInt();
				temp[row][col] = num[row][col];
			}
		}
		
		for (int i=0; i<3; i++) {
			//Checks the array
			for (int row=0; row<N; row++) {
				for (int col=0; col<N-1; col++) {
					if (num[row][col] >= num[row][col+1]) {
						flag = false;
					}
				}
			}
			for (int col=0; col<N; col++) {
				for (int row=0; row<N-1; row++) {
					if (num[row][col] >= num[row+1][col]) {
						flag = false;
					}
				}
			}
			if (flag) {
				for (int row=0; row<N; row++) {
					for (int col=0; col<N; col++) {
						System.out.print(num[row][col] + " ");
					}
					System.out.println();
				}
				return;
			}
			else {
				flag = true;
			}
			
			//rotates the array and sets temp to the new array
			for (int row=0; row<N; row++) {
				for (int col=0; col<N; col++) {
					num[row][col] = temp[N-1-col][row];
				}
			}
			for (int row=0; row<N; row++) {
				for (int col=0; col<N; col++) {
					temp[row][col] = num[row][col];
				}
			}
				
		} 
		
		for (int row=0; row<N; row++) {
			for (int col=0; col<N; col++) {
				System.out.print(num[row][col] + " ");
			}
			System.out.println();
		}

		
	}

}
