package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class VM7WC16P4Gold {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int D = readInt();
		int I = readInt();
		int R = readInt();
		String S1 = read();
		String S2 = read();
		
		int[][] dp = new int[S1.length()+1][S2.length()+1];
		
		for (int i=0; i<=S1.length(); i++) {
			for (int j=0; j<=S2.length(); j++) {
				if (i == 0) {
					dp[i][j] = j*I;
				}
				else if (j == 0) {
					dp[i][j] = i*D;
				}
				else if (S1.charAt(i-1) == S2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.min(dp[i-1][j] + D, Math.min(dp[i][j-1] + I, dp[i-1][j-1] + R));
				}
			}
		}
		
		System.out.println(dp[S1.length()][S2.length()]);
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
