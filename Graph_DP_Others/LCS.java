package second;

import java.io.*;
import java.util.*;

public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int M = readInt();
		int[] a = new int[N+1];
		int[] b = new int[M+1];
		int[][] dp = new int[N+1][M+1];
		
		for (int i=1; i<=N; i++) {
			a[i] = readInt();
		}
		for (int i=1; i<=M; i++) {
			b[i] = readInt();
		}
		
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=M; j++) {
				if (a[i] == b[j]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[N][M]);
		
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
