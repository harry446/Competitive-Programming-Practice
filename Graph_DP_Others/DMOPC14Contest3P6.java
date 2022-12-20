package second;

import java.io.*;
import java.util.*;

public class DMOPC14Contest3P6 {

	public static class Quality {
		int poor, average, good;
		
		public Quality (int poor, int average, int good) {
			this.poor = poor;
			this.average = average;
			this.good = good;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int T = readInt();
		Quality[] P = new Quality[N+1];
		Quality[] V = new Quality[N+1];
		long[] dp = new long[T+1];
		
		for (int i=1; i<=N; i++) {
			int p1 = readInt();
			int v1 = readInt();
			int p2 = readInt();
			int v2 = readInt();
			int p3 = readInt();
			int v3 = readInt();
			P[i] = new Quality(p1, p2, p3);
			V[i] = new Quality(v1, v2, v3);
		}
		
		
		for (int i=1; i<=N; i++) {
			for (int j=T; j>=Math.min(Math.min(P[i].poor, P[i].average), P[i].good); j--) {
				
				if (j >= P[i].poor) {
					dp[j] = Math.max(dp[j], dp[j-P[i].poor] + V[i].poor);
				}
				if (j >= P[i].average) {
					dp[j] = Math.max(dp[j], dp[j-P[i].average] + V[i].average);
				}
				if (j >= P[i].good) {
					dp[j] = Math.max(dp[j], dp[j-P[i].good] + V[i].good);
				}
			}
		}

		System.out.println(dp[T]);
		
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

}
