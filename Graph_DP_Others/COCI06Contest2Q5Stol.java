package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class COCI06Contest2Q5Stol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int R = readInt();
		int C = readInt();
		int[][] psa = new int[R][C+1];
		
		for (int i=0; i<R; i++) {
			String S = read();
			for (int j=0; j<C; j++) {
				psa[i][j+1] = psa[i][j] + (S.charAt(j) == '.' ? 1:0);
			}
		}
		
//		for (int i=0; i<R; i++) {
//			for (int j=0; j<=C; j++) {
//				System.out.print(psa[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int max = 0;
		for (int i=1; i<=C; i++) {	//width
			for (int j=0; j<=C-i; j++) {	//columns
				int length = 0;
				for (int k=0; k<R; k++) {	//rows
					if (psa[k][j+i] - psa[k][j] == i) {
						length++;
						max = Math.max(max, 2*i + 2*length);
					}
					else {
						length = 0;
					}
				}
			}
		}
		
		System.out.println(max-1);
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
