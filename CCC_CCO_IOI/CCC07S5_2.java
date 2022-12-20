package second;

import java.io.*;
import java.util.*;

public class CCC07S5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int T = readInt();
		
		for (int z=0; z<T; z++) {
			int N = readInt();
			int K = readInt();
			int W = readInt();
			int[] pins = new int[N+1];
			int[] psa = new int[N+1];
			int[][] dp = new int[2][N+1];
			for (int i=1; i<=N; i++) {
				pins[i] = readInt();
				psa[i] = pins[i] + psa[i-1];
			}
			
			for (int i=1; i<=K; i++) {
				for (int j=1; j<=N; j++) {
					if (j <= W) {
						dp[1][j] = psa[j];
						continue;
					}
					
					dp[1][j] = Math.max(dp[1][j-1], dp[0][j-W] + psa[j] - psa[j-W]);
					
				}
				
				for (int j=1; j<=N; j++) {
					dp[0][j] = dp[1][j];
					dp[1][j] = 0;
				}
//				for (int j=1; j<=N; j++) {
//					if (j<=W) {
//						dp[i][j] = psa[j];
//					}
//					else {
//						dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-W] + psa[j] - psa[j-W]);
//					}
//				}
			}
			
			System.out.println(dp[0][N]);
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
 
	static String read() {
		while (st == null || !st.hasMoreTokens()) {
			try { st = new StringTokenizer(br.readLine()); 
			} catch (IOException e) {}
		}
		return st.nextToken();
	}
	static int readInt() {
		return Integer.parseInt(read());
	}
}
