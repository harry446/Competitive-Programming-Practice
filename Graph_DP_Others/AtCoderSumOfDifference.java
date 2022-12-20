package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AtCoderSumOfDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int[] a = new int[N+1];
		long[] psa = new long[N+1];
		
		for (int i=1; i<=N; i++) {
			a[i] = readInt();
		}
		Arrays.sort(a);
		
		for (int i=1; i<=N; i++) {
			psa[i] = psa[i-1] + a[i];
		}
		
		long total = 0;
		for (int i=1; i<=N; i++) {
			total += (a[i] * (i-1)) - psa[i-1];
		}
		
		System.out.println(total);
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
