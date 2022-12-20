package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DMOPC14Contest2P4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int[] psa = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			psa[i] = psa[i-1] + readInt();
		}
		
		int Q = readInt();
		for (int i=0; i<Q; i++) {
//			int a = readInt();
//			int b = readInt();
//			System.out.println(psa[b+1] - psa[a]);
			System.out.println(Math.abs(psa[readInt()] - psa[readInt()+1]));
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
