package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IOI94P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int[] dp = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			for (int j=i; j>=1; j--) {
				int a = readInt();
				dp[j] = Math.max(dp[j-1] + a, dp[j] + a);
			}
		}
		
		int max = -1;
		for (int i=1; i<=N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
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
