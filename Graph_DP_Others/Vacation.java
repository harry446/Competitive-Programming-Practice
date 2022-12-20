package second;

import java.io.*;
import java.util.*;

public class Vacation {

	static int N;
	static int[][] points;
	static int[][] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		points = new int[N][3];
		dp = new int[N][3];
		
		for (int row=0; row<N; row++) {
			for (int col=0; col<3; col++) {
				points[row][col] = readInt();
			}
		}
		
		System.out.println(find(0, -1));
		
	}
	
	public static int find (int n, int x) {
		if (n == N) {
			return 0;
		}
		
		if (x == 0 && dp[n][x] != 0) {
			return dp[n][x];
		}
		if (x == 1 && dp[n][x] != 0) {
			return dp[n][x];
		}
		if (x == 2 && dp[n][x] != 0) {
			return dp[n][x];
		}
		
		int a = Integer.MIN_VALUE;
		int b = Integer.MIN_VALUE;
		int c = Integer.MIN_VALUE;
		
		if (x == 0) {
			b = find(n+1, 1) + points[n][1];
			c = find(n+1, 2) + points[n][2];
		}
		else if (x == 1) {
			a = find(n+1, 0) + points[n][0];
			c = find(n+1, 2) + points[n][2];
		}
		else if (x == 2) {
			a = find(n+1, 0) + points[n][0];
			b = find(n+1, 1) + points[n][1];
		}
		else {
			a = find(n+1, 0) + points[n][0];
			b = find(n+1, 1) + points[n][1];
			c = find(n+1, 2) + points[n][2];
		}
		
		if (a == Integer.MIN_VALUE) {
			dp[n][0] = Math.max(b, c);
		}
		else if (b == Integer.MIN_VALUE) {
			dp[n][1] = Math.max(a, c);
		}
		else if (c == Integer.MIN_VALUE) {
			dp[n][2] = Math.max(a, b);
		}
		
		int d = Math.max(c, Math.max(a, b));
		return d;
		
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
