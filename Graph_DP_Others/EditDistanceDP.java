package second;

import java.util.Scanner;

public class EditDistanceDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		String X = sc.next();
		String Y = sc.next();
		
		int[][] dp = new int[X.length()+1][Y.length()+1];	//let dp[i][j] = minimum number of steps required to transform 
															//a prefix of X of length i to a prefix of Y of length j.
		
		for (int i=0; i<=X.length(); i++) {
			for (int j=0; j<=Y.length(); j++) {
				if (i == 0) {
					dp[i][j] = j;
				}
				else if (j == 0) {
					dp[i][j] = i;
				}
				else if (X.charAt(i-1) == Y.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
				}
			}
		}
		
		System.out.println(dp[X.length()][Y.length()]);
	}

}
