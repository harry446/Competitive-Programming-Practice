package second;

import java.io.*;
import java.util.*;

public class DMOPC13Contest3P5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int M = readInt();
		int U = readInt();
		int R = readInt();
		int[] value = new int[R+1];
		int[] food = new int[R+1];
		int[] time = new int[R+1];
		int[][] dp = new int[M+1][U+1];
//		int[][][] dp = new int[2][M+1][U+1];
		
		for (int i=1; i<=R; i++) {
			value[i] = readInt();
			time[i] = readInt();
			food[i] = readInt();
		}
		
		for (int i=1; i<=R; i++) {
			for (int j=M; j>=time[i]; j--) {
				for (int k=U; k>=food[i]; k--) {
					dp[j][k] = Math.max(dp[j][k], dp[j-time[i]][k-food[i]] + value[i]);
				}
			}
//			for (int j=0; j<=M; j++) {
////				if (j < time[i]) {
////					dp[1][j] = dp[0][j];
////					continue;
////				}
//				for (int k=0; k<=U; k++) {
//					if (j < time[i] || k < food[i]) {
//						dp[1][j][k] = dp[0][j][k];
//						continue;
//					}
//					dp[1][j][k] = Math.max(dp[0][j][k], dp[0][j-time[i]][k-food[i]] + value[i]);
//				}
//			}
//			
//			for (int j=0; j<=M; j++) {
//				for (int k=0; k<=U; k++) {
//					dp[0][j][k] = dp[1][j][k];
//					dp[1][j][k] = 0;
//				}
//			}
		}
		
		System.out.println(dp[M][U]);
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
