package second;

import java.io.*;
import java.util.*;

public class Grid1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int H = readInt();
		int W = readInt();
		int[][] dp = new int[H+1][W+1];
		
		dp[1][0] = 1;
		for (int i=1; i<=H; i++) {
			String S = read();
			for (int j=1; j<=W; j++) {
				if (S.charAt(j-1) == '#') {
					dp[i][j] = -1;
					continue;
				}
				
				if (dp[i-1][j] != -1) {
					dp[i][j] += dp[i-1][j] % 1000000007;
				}
				if (dp[i][j-1] != -1) {
					dp[i][j] += dp[i][j-1] % 1000000007;
				}
				
			}
		}
		
		System.out.println(dp[H][W] % 1000000007);
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
	static char readCharacter () {
		return read().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
