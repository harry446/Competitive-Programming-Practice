package second;

import java.io.*;
import java.util.*;

public class BrapLeshMafia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		long K = readLong();
		
		long total = 0L;
		
		for (int i=0; i<N; i++) {
			long a = readLong();
			long b = readLong();
			
			total += (a%K * b%K) % K;
		}
		
		System.out.println(total%K);
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
