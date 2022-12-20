package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Knapsack {

	static int[] value, weight;
	static int[][] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int C = readInt();
		
		value = new int[N+1];
		weight = new int[N+1];
		dp = new int[N+1][C+1];
		
		for (int i=1; i<=N; i++) {
			value[i] = readInt();
			weight[i] = readInt();
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=0; j<=C; j++) {
				if (j < weight[i]) {
					dp[i][j] = dp[i-1][j];
					continue;
				}
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
			}
		}
		
		System.out.println(dp[N][C]);
		
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
	static long readLong() {
		return Long.parseLong(read());
	}
	static double readDouble() {
		return Double.parseDouble(read());
	}
}
