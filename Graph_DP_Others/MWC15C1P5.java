package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MWC15C1P5 {

	static final int MOD = 1000000007;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String A = read().toLowerCase();
		String B = read().toLowerCase();

		long a = 0, b = 0;
		for (int i=0; i<A.length(); i++) {
			a = (a + fastPow(A.charAt(i)-'a'+1, i+1))%10;
		}
		for (int i=0; i<B.length(); i++) {
			b = (b + fastPow(B.charAt(i)-'a'+1, i+1))%10;
		}
		
		if (a == 0) {
			a = 10;
		}
		if (b == 0) {
			b = 10;
		}
		System.out.println(a+b);
	}
	
	public static long fastPow (int a, int b) {
		if (b == 0) {
			return 1;
		}
		
		long t = fastPow(a, b/2) % 10;
		if (b%2 == 1) {
			return (t*t*a%10) % 10;	//extra 1 a because of rounding
		}
		else {
			return (t*t) % 10;
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
	static char readCharacter() {
		return read().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
	
}
