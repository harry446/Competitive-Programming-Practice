package second;

import java.io.*;
import java.util.*;

public class CPC21Contest1P0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String S = read();
		
		for (int i=0; i<26; i++) {
			boolean flag = false;
			for (int j=0; j<S.length(); j++) {
				if ((char)(i+'a') == S.charAt(j)) {
					flag = true;
				}
			}
			if (!flag) {
				System.out.println((char)(i+'a'));
				return;
			}
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
