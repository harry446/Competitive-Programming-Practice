package second;

import java.util.*;

public class IOI00P1Palindrome {
	
	static String S;
	static int[][] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner SC = new Scanner (System.in);
		int N = SC.nextInt();
		S = SC.next();
		
		dp = new int[2][N+1];
		String S1 = "";
		for (int i=0; i<N; i++) {
			S1 += S.charAt(N-i-1);
		}
		

		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (S.charAt(i-1) == S1.charAt(j-1)) {
					dp[1][j] = dp[0][j-1] + 1;
				}
				else {
					dp[1][j] = Math.max(dp[0][j], dp[1][j-1]);
				}
			}
			
			for (int j=1; j<=N; j++) {
				dp[0][j] = dp[1][j];
				dp[1][j] = 0;
			}
		}
		
		System.out.println(N - dp[0][N]);
		SC.close();
		
	}
	
//	public static int ifPalindrome (int low, int high) {
//		if (low >= high) {
//			return 0;
//		}
//		
//		if (dp[low][high] != -1) {
//			return dp[low][high];
//		}
//		
//		if (S.charAt(low) == S.charAt(high)) {
//			return ifPalindrome(low+1, high-1);
//		}
//		
//		int x = ifPalindrome(low+1, high) + 1;
//		int y = ifPalindrome(low, high-1) + 1;
//		
//		return dp[low][high] = Math.min(x, y);
//	}

}
