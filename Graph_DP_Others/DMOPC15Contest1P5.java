package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DMOPC15Contest1P5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int W = readInt();
		int H = readInt();
		int N = readInt();
		int[][] psa = new int[H+1][W+1];
		
		for (int i=1; i<=H; i++) {
			for (int j=1; j<=W; j++) {
				psa[i][j] = psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1] + readInt();
			}
		}
		
//		for (int i=0; i<=W; i++) {
//			for (int j=0; j<=H; j++) {
//				System.out.printf("%2d ", psa[i][j]);
//			}
//			System.out.println();
//		}
		int max = -1;
		for (int i=1; i<=N; i++) {
			int length = N/i - 1;
			int width = i-1;
			for (int j=1; j<=H-width; j++) {
				for (int k=1; k<=W-length; k++) {
					max = Math.max(max, psa[j+width][k+length] - psa[j-1][k+length] - psa[j+width][k-1] + psa[j-1][k-1]);
				}
			}
		}
//		for (int i=1; i<=H; i++) {
//			for (int j=1; j<=W; j++) {
//				for (int k=1; k<=W-j+1; k++) {
//					int length = N/k - 1;
//					int width = k - 1;
//					if (i+width > H || j+length > W) {
//						continue;
//					}
//					max = Math.max(max, psa[i+width][j+length] - psa[i-1][j+length] - psa[i+width][j-1] + psa[i-1][j-1]);
//				}
//			}
//		}
		
//		for (int i=1; i<=H; i++) {
//			for (int j=1; j<=W; j++) {
//				for (int k=1; j+k-1<=W; k++) {
//					int length = N/k - 1;
//					int width = k - 1;
//					if (i+width > H || j+length > W) {
//						continue;
//					}
//					max = Math.max(max, psa[i+width][j+length] - psa[i-1][j+length] - psa[i+width][j-1] + psa[i-1][j-1]);
//				}
//			}
//		}
		
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
