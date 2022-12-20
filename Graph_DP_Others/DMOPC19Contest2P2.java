package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DMOPC19Contest2P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int M = readInt();
		int[][] dp = new int[N][M];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				int a = readInt();
				
				if (i == 0 && j != 0) {
					dp[i][j] = dp[i][j-1] + a;
				}
				else if (i != 0 && j == 0) {
					dp[i][j] = dp[i-1][j] + a;
				}
				else if (i == 0 && j == 0) {
					dp[i][j] = a;
				}
				else {
					dp[i][j] = Math.min(dp[i-1][j] + a, dp[i][j-1] + a);
				}
				
			}
		}
		
		System.out.println(dp[N-1][M-1]);
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
	static char readCharacter() {
		return read().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
	
}
