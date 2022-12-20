package second;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumCost2DMatrixDynamicProgramming2 {
	
	static int[][] Cost, minCost;
	static int m, n;
	static int[] path = new int[4];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		m = SC.nextInt();
		n = SC.nextInt();
		int r = SC.nextInt();
		int c = SC.nextInt();
		Cost = new int[m][n];
		minCost = new int[m][n];
		
		for (int row=0; row<m; row++) {
			for (int col=0; col<n; col++) {
				Cost[row][col] = SC.nextInt();
			}
		}
		
		for (int i=0; i<m; i++) {
			Arrays.fill(minCost[i], -1);
		}
		
		minCost[0][0] = Cost[0][0];
		
		System.out.println(shortestPath(r, c));
		
		for (int row=0; row<m; row++) {
			for (int col=0; col<n; col++) {
				System.out.print(minCost[row][col] + " ");
			}
			System.out.println();
		}
	}

	public static int shortestPath (int r, int c) {
		Arrays.fill(path, -1);
		r = r - 1;
		c = c - 1;
		if (r == 0 && c == 0) {
			return Cost[0][0];
		}
		else if (r < 0 || r >= m || c < 0 || c >= n) {
			return Integer.MAX_VALUE;
		}

		if (r-1 >= 0 && minCost[r-1][c] != -1) {
			path[0] = minCost[r-1][c];
		}
		else {
			path[0] = shortestPath(r-1, c);
		}
		
		if (c-1 >= 0 && minCost[r][c-1] != -1) {
			path[1] = minCost[r][c-1];
		}
		else {
			path[1] = shortestPath(r, c-1);
		}
		
		if (r+1 < m && minCost[r+1][c] != -1) {
			path[2] = minCost[r+1][c];
		}
		else {
			path[2] = shortestPath(r+1, c);
		}
		
		if (c+1 < n && minCost[r][c+1] != -1) {
			path[3] = minCost[r][c+1];
		}
		else {
			path[3] = shortestPath(r, c+1);
		}
		
//		for (int i=0; i<4; i++) {
//			if (path[i] != -1) {
//				continue;
//			}
//			
//			if (i == 0) {
//				path[i] = shortestPath(r-1, c);
//			}
//			else if (i == 2) {
//				path[i] = shortestPath(r, c-1);
//			}
//			else if (i == 3) {
//				path[i] = shortestPath(r+1, c);
//			}
//			else {
//				path[i] = shortestPath(r, c+1);
//			}
//		}
		
		minCost[r][c] = small(path[0], path[1], path[2], path[3]) + Cost[r][c];
		
		return minCost[r][c];
	}
	
	public static int small (int a, int b, int c, int d) {
		int[] temp = {a, b, c, d};
		Arrays.sort(temp);
		return temp[0];
	}
}
