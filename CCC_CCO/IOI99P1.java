package second;

import java.io.*;
import java.util.*;

public class IOI99P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int F = readInt();
		int V = readInt();
		int[][] values = new int[F+1][V+1];
		int[][] dp = new int[F+1][V+1];
		
		for (int i=1; i<=F; i++) {
			for (int j=1; j<=V; j++) {
				values[i][j] = readInt();
			}
			Arrays.fill(dp[i], -0x3f3f3f3f);
//			dp[i][0] = -0x3f3f3f3f;
		}
		
		for (int i=1; i<=F; i++) {
			for (int j=i; j<=V; j++) {
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-1] + values[i][j]);
			}
		}
		System.out.println(dp[F][V]);
		
//		for (int row=0; row<=F; row++) {
//			for (int col=0; col<=V; col++) {
//				System.out.printf("%12d ", dp[row][col]);
//			}
//			System.out.println();
//		}
		
		int[] ans = new int[F];
		int index = 0;
		int value = dp[F][V];
		for (int row=F; row>=1; row--) {
			for (int col=1; col<=V; col++) {
				if (dp[row][col] == value) {
					ans[index++] = col;
					value -= values[row][col];
					break;
				}
			}
		}
//		int index = 0;
//		int curCol = 5;
//		for (int row=F; row>=1; row--) {
//			for (int col=curCol; col>=1; col--) {
//				if (dp[row][col] != dp[row][col-1]) {
////					System.out.println(row + " " + col);
//					ans[index++] = col;
//					curCol = col-1;
//					break;
//				}
//			}
//		}
		
		for (int i=F-1; i>=0; i--) {
			System.out.print(ans[i] + " ");
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
}
