package second;

import java.io.*;
import java.util.*;

public class SimonAndMarcy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int C = readInt();
		int M = readInt();
		int[] value = new int[C+1];
		int[] weight = new int[C+1];
		int[] dp = new int[M+1];
		
		for (int i=1; i<=C; i++) {
			value[i] = readInt();
			weight[i] = readInt();
		}
		
		for (int i=1; i<=C; i++) {
			for (int j=M; j>=weight[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
				
			}
		}
		
		System.out.println(dp[M]);
		
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
