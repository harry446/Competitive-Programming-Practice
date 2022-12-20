package second;

import java.io.*;
import java.util.*;

public class DMOPC14Contest3P4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ans = new int[100001];
		
		int count = 0;
		for (int i=1; i<=100000; i++) {
//			count += i;
			for (int j=1; j<=Math.sqrt(i); j++) {
				count++;
			}
//			System.out.println();
		}
		
		System.out.println(count);
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
