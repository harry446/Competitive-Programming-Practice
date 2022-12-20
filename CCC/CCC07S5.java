package second;

import java.io.*;
import java.util.*;

public class CCC07S5 {

	static int[][] dp;
	static int[] nums, sum;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int t = readInt();
		
		for (int j=0; j<t; j++) {
			int n = readInt();
			int k = readInt();
			int w = readInt();
			
			dp = new int[k+1][n+1];
			nums = new int[n+1];
			sum = new int[n+1];
			
			for (int i=1; i<=n; i++) {
				nums[i] = readInt();
			}
			
			for (int i=n; i>n-w; i--) {
				sum[n] += nums[i];
			}
			for (int i=n-1; i>=w; i--) {
				sum[i] = sum[i+1] - nums[i+1] + nums[i-w+1];
			}
			for (int i=w-1; i>=1; i--) {
				sum[i] = sum[i+1] - nums[i+1];
			}
			
			for (int row=1; row<=k; row++) {
				for (int col=1; col<=w; col++) {
					dp[row][col] = sum[col];
				}
				for (int col=w+1; col<=n; col++) {
					dp[row][col] = Math.max(dp[row][col-1], sum[col] + dp[row-1][col-w]);
				}
			}
			
			System.out.println(dp[k][n]);
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
	static long readLong() {
		return Long.parseLong(read());
	}
	static double readDouble() {
		return Double.parseDouble(read());
	}
}
