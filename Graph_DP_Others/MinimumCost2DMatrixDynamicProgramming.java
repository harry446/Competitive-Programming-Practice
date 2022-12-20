package second;

import java.util.Scanner;

public class MinimumCost2DMatrixDynamicProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int m = SC.nextInt();
		int n = SC.nextInt();
		int r = SC.nextInt();
		int c = SC.nextInt();
		int[][] Cost = new int[m][n];
		int[][] minCost = new int[m][n];
		
		for (int row=0; row<m; row++) {
			for (int col=0; col<n; col++) {
				Cost[row][col] = SC.nextInt();
			}
		}
		
		minCost[0][0] = Cost[0][0];
		
		for (int i=1; i<m; i++) {
			minCost[0][i] = minCost[0][i-1] + Cost[0][i];
			minCost[i][0] = minCost[i-1][0] + Cost[i][0];
		}
		
		for (int row=1; row<m; row++) {
			for (int col=1; col<n; col++) {
				minCost[row][col] = Math.min(minCost[row-1][col], minCost[row][col-1]) + Cost[row][col];
				if (row == r-1 && col == c-1) {
					System.out.println(minCost[row][col]);
					return;
				}
			}
		}
	}
	

}
