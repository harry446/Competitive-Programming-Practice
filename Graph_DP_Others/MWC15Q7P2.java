package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MWC15Q7P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int F = readInt();
		int R = readInt();
		int[][] psa = new int[F][R+1];
		
		for (int i=0; i<F; i++) {
			for (int j=1; j<=R; j++) {
				psa[i][j] = psa[i][j-1] + readInt();
			}
		}
		
		int Q = readInt();
		for (int i=0; i<Q; i++) {
			int a = readInt(); 
			int b = readInt();
			int c = readInt()-1;
			
			System.out.println(psa[c][b] - psa[c][a-1]);
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
