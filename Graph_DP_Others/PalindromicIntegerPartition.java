package second;

import java.io.*;
import java.util.*;

public class PalindromicIntegerPartition {

	static long[] map;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		map = new long[N+1];
		System.out.println(find(N));
	}
	
	static long find (int x) {
		if (x <= 1) {
			return 1;
		}
		
		if (map[x] != 0) {
			return map[x];
		}
		long ans = 1L;
		
		for (int i=1; i<=x; i++) {
			if (2*i <= x) {
				ans += find(x-2*i);
			}
		}
		
		return map[x] = ans;
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
}
