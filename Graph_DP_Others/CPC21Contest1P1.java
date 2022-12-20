package second;

import java.io.*;
import java.util.*;

public class CPC21Contest1P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int T = readInt();
		long d = 1000000000000000000L;
		
		for (int i=0; i<T; i++) {
			long a = readLong();
			long b = readLong();
			
			String S = "" + (double)a/b;
			System.out.println(S.length() - 2);
//			double c = (double)a/b;
//			System.out.println(c);
//			System.out.println((long)(c*Math.pow(10, 18)));
//			long e = d - (long)(c*Math.pow(10, 18));
//			String S = "" + e;
//			
//			System.out.println(S);
//			System.out.println(d);
//			
//			int count = 0;
//			for (int j=0; j<S.length(); j++) {
//				if (S.charAt(j) == '0') {
//					break;
//				}
//				System.out.println("YES");
//				count++;
//			}
//			
//			if (count == 18 && e < 999999999999999999L) {
//				System.out.println(-1);
//			}
//			else {
//				System.out.println(count + (18-S.length()));
//			}
//			System.out.println();
			
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
