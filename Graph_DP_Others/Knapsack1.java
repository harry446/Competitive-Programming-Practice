package second;

import java.io.*;
import java.util.*;

public class Knapsack1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int W = readInt();
		int[] value = new int[N+1];
		int[] weight = new int[N+1];
//		long[][] dp = new long[N+1][W+1];
		long[] dp = new long[W+1];
		
		for (int i=1; i<=N; i++) {
			weight[i] = readInt();
			value[i] = readInt();
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=W; j>=weight[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
			}
			
		}
		
		System.out.println(dp[W]);
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
//	static long readLong() {
//		return Long.parseLong(read());
//	}
//	static double readDouble() {
//		return Double.parseDouble(read());
//	}
}
