package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JoeyAndBiology {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int M = readInt();
		String X = read();
		String Y = read();
		int[][] dp = new int[N+1][M+1];
		
		for (int i=0; i<=N; i++) {
			for (int j=0; j<=M; j++) {
				if (i == 0) {
					dp[i][j] = (int)Math.ceil((double)j/3);
				}
				else if (j == 0) {
					dp[i][j] = (int)Math.ceil((double)i/3);
				}
				else if (X.charAt(i-1) == Y.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
					if (i >= 2) {
						dp[i][j] = Math.min(dp[i][j], dp[i-2][j] + 1);
					}
					if (j >= 2) {
						dp[i][j] = Math.min(dp[i][j], dp[i][j-2] + 1);
					}
					if (i >= 3) {
						dp[i][j] = Math.min(dp[i][j], dp[i-3][j] + 1);
					}
					if (j >= 3) {
						dp[i][j] = Math.min(dp[i][j], dp[i][j-3] + 1);
					}
//					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-2][j], Math.min(dp[i-3][j], Math.min(dp[i][j-1], Math.min(dp[i][j-2], Math.min(dp[i][j-3], dp[i-1][j-1]))))));
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
