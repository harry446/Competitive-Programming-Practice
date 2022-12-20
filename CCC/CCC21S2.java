package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC21S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int M = readInt();
		int N = readInt();
		int K = readInt();
		boolean[] flagR = new boolean[M];
		boolean[] flagC = new boolean[N];
		
		for (int i=0; i<K; i++) {
			char c = read().charAt(0);
			int n = readInt()-1;
			
			if (c == 'R') {
				flagR[n] = !flagR[n];
			}
			else {
				flagC[n] = !flagC[n];
			}
		}
		
		int count = 0;
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				if (flagR[i] != flagC[j]) {
					count++;
				}
			}
		}
		
		System.out.println(count);
//		int rCount = 0, cCount = 0;
//		for (int i=0; i<M; i++) {
//			if (flagR[i]) {
//				rCount++;
//			}
//		}
//		for (int i=0; i<N; i++) {
//			if (flagC[i]) {
//				cCount++;
//			}
//		}
//		
//		System.out.println(rCount*N + cCount*M - 2*rCount*cCount);
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
