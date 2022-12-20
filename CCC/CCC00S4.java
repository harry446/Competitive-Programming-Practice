package second;

import java.io.*;
import java.util.*;

public class CCC00S4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int dist = readInt();
		int clubNum = readInt();
		int[] clubs = new int[clubNum+1];
		int[] dp = new int[dist+1];
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0] = 0;
		
		for (int i=1; i<=clubNum; i++) {
			clubs[i] = readInt();
		}
		
		for (int i=1; i<=clubNum; i++) {
			int cur = clubs[i];
			for (int j=cur; j<=dist; j++) {
				dp[j] = Math.min(dp[j-cur]+1, dp[j]);
			}
		}
		
		if (dp[dist] == Integer.MAX_VALUE-1) {
			System.out.println("Roberta acknowledges defeat.");
		}
		else {
			System.out.println("Roberta wins in " +  dp[dist] + " strokes.");
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
