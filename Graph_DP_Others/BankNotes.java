package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BankNotes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int[] b = new int[N];
		int[] c = new int[N];
		
		for (int i=0; i<N; i++) {
			b[i] = readInt();
		}
		for (int i=0; i<N; i++) {
			c[i] = readInt();
		}
		
		int K = readInt();
		
		
		int[] dp = new int[K+1];
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0] = 0;
		for (int i=0; i<N; i++) {
			int cur = b[i];
			int[] count = new int[cur];
			int[] temp = new int[K+1];
			for (int j=1; j<=K; j++) {
				temp[j] = dp[j];
			}
			
			for (int j=cur; j<=K; j++) {
				int A = dp[j-cur]+1;
				int B = dp[j];
				
				if (A < B && count[j%cur] < c[i]) {
					count[j%cur]++;
					dp[j] = A;
				}
			}
		}
		
		System.out.println(dp[K]);
		
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
