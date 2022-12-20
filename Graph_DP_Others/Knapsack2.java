package second;

import java.io.*;
import java.util.*;

public class Knapsack2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int W = readInt();
		int[] v = new int[N+1];
		int[] w = new int[N+1];
		long[] dp = new long[100001];
		
		for (int i=1; i<=N; i++) {
			w[i] = readInt();
			v[i] = readInt();
		}
		
		Arrays.fill(dp, 0x3f3f3f3f);
		dp[0] = 0;
		for (int i=1; i<=N; i++) {
			for (int j=100000; j>=v[i]; j--) {
				dp[j] = Math.min(dp[j], dp[j-v[i]] + w[i]);	//based on min weight at specific value, not max value at specific weight
			}
		}
		
		for (int i=100000; i>=0; i--) {
			if (dp[i] <= W) {
				System.out.println(i);
				break;
			}
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
