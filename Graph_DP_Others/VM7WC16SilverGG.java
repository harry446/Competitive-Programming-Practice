package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class VM7WC16SilverGG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String S = read();
		int Q = readInt();
		int[] psa = new int[S.length()+1];
		
		for (int i=1; i<=S.length(); i++) {
			psa[i] = psa[i-1];
			if (S.charAt(i-1) == 'G' ) {
				psa[i]++;
			}
		}
		
		for (int i=0; i<Q; i++) {
			int a = readInt();
			int b = readInt();
			
			System.out.println(psa[b+1] - psa[a]);
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
