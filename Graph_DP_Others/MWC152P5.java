package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MWC152P5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int K = readInt();
		int J = readInt();
		long[][] diff = new long[3][N+1];
		
		for (int i=0; i<J; i++) {
			int x1 = readInt()-1;
			int x2 = readInt();
			int I = readInt();
			int T = readInt()-1;
			
			diff[T][x1] += I;
			diff[T][x2] -= I;
		}
		
		for (int i=0; i<3; i++) {
			int count = 0;
			if (diff[i][0] < K) {
				count++;
			}
			for (int j=1; j<N; j++) {
				diff[i][j] += diff[i][j-1];
				if (diff[i][j] < K) {
					count++;
				}
			}
			System.out.println(count);
		}
//		for (int i=0; i<3; i++) {
//			long cur = 0;
//			int count = 0;
//			for (int j=0; j<N; j++) {
//				cur += diff[i][j];
//				if (cur < K) {
//					count++;
//				}
//			}
//			System.out.println(count);
//		}
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
