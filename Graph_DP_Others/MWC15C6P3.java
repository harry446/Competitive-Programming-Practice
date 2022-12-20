package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MWC15C6P3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int Q = readInt();
		long[] a = new long[N+1];
		
		for (int i=1; i<=N; i++) {
			int m = readInt();
			for (int j=0; j<m; j++) {
				a[i] |= (1L << readInt() + 30);
			}
		}
		
		for (int i=0; i<Q; i++) {
			int m = readInt();
			long ans = 0;
			for (int j=0; j<m; j++) {
				ans ^= a[readInt()];
			}
			
			ArrayList<Integer> ar = new ArrayList<>();
			for (int j=0; j<61; j++) {
				if ((ans & (1L << j)) > 0) {
					ar.add(j-30);
				}
			}
			
			System.out.print(ar.size());
			for (int k : ar) {
				System.out.print(" " + k);
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
	static char readCharacter () {
		return read().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
	
}
