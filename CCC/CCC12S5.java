package second;

import java.io.*;
import java.util.*;

public class CCC12S5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int R = readInt();
		int C = readInt();
		int K = readInt();
		int[][] dp = new int[R+1][C+1];
		
		for (int i=0; i<K; i++) {
			dp[readInt()][readInt()] = -1;
		}
		
		dp[1][0] = 1;
		for (int i=1; i<=R; i++) {
			for (int j=1; j<=C; j++) {
				if (dp[i][j] == -1) {
					continue;
				}
				dp[i][j] = Math.max(0, dp[i-1][j]) + Math.max(0, dp[i][j-1]);
			}
		}
		
		
		System.out.println(dp[R][C]);
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
