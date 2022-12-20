package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MockCCC14S3 {

	public static class Pair implements Comparable<Pair> {
		int n, r;
		public Pair (int n, int r) {
			this.n = n;
			this.r = r;
		}
		
		public int compareTo (Pair o) {
			return n - o.n;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int R = readInt();
		int C = readInt();
		int[][] table = new int[R+1][C+1];
		
		for (int row=1; row<=R; row++) {
			for (int col=1; col<=C; col++) {
				table[row][col] = readInt();
			}
		}
		
		int N = readInt();
		Pair[] temp1 = new Pair[R];
		int[][] temp2 = new int[R+1][C+1];
		
		for (int i=0; i<N; i++) {
			int c = readInt();
			
			for (int row=1; row<=R; row++) {
				temp1[row-1] = new Pair(table[row][c], row);
			}
			Arrays.sort(temp1);
			
//			for (int j=0; j<R; j++) {
//				System.out.println(temp1[j].n + ", row: " + temp1[j].r);
//			}
			for (int row=1; row<=R; row++) {
				temp2[row] = table[temp1[row-1].r];
			}
			
			for (int j=1; j<=R; j++) {
				table[j] = temp2[j];
			}
			
//			for (int row=1; row<=R; row++) {
//				for (int col=1; col<=C; col++) {
//					System.out.print(table[row][col] + " ");
//				}
//				System.out.println();
//			}
			
		}
		
		for (int row=1; row<=R; row++) {
			for (int col=1; col<=C; col++) {
				System.out.print(table[row][col] + " ");
			}
			System.out.println();
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
	static char readCharacter() {
		return read().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
	
}
