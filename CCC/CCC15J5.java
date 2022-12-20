package second;

import java.util.*;

public class CCC15J5 {

//	static int[][] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		if (N == K) {
			System.out.println(1);
			return;
		}
		
		int[][] dp2 = new int[N+1][K+1];
		
		for (int i=1; i<=K; i++) {
			dp2[0][i] = 1;
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=K; j++) {
				dp2[i][j] = dp2[i][j-1];
				if (i-j >= 0) {
					dp2[i][j] += dp2[i-j][j];
				}
			}
		}

		
		System.out.println(dp2[N-K][K]);
		
//		dp = new int[N+1][K+1];
//		
//		find(N, K);
//
//		System.out.println(dp[N-K][K]);
		
	}
	
//	public static int find (int n, int k) {
//		if (n < 0) {
//			return 0;
//		}
//		
//		if (k == 0 && n != 0) {
//			return dp[n][k] = 0;
//		}
//		
//		if (k != 0 && n == 0) {
//			return dp[n][k] = 1;
//		}
//		
//		if (dp[n][k] != 0) {
//			return dp[n][k];
//		}
//		
//		return dp[n][k] = find(n, k-1) + find(n-k, k);
//	}

}
