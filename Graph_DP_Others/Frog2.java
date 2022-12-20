package second;

import java.io.*;
import java.util.*;

public class Frog2 {

	static int N, K;
	static int[] height;
	static int[] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		K = readInt();
		height = new int[N+1];
		dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for (int i=1; i<=N; i++ ) {
			height[i] = readInt();
		}
		
		System.out.println(find(1));
	}
	
	public static int find (int x) {
		if (x == N) {
			return 0;
		}
		
		if (dp[x] != Integer.MAX_VALUE) {
			return dp[x];
		}
		
		int a = Integer.MAX_VALUE;
		for (int i=1; i<=K; i++) {
			if (x+i > N) {
				continue;
			}
			a = Math.min(a, find(x+i) + Math.abs(height[x] - height[x+i]));
		}
		
		return dp[x] = a;
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
