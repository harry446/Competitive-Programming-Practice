package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Balance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int[] nums = new int[N];
		
		for (int i=0; i<N; i++) {
			nums[i] = readInt();
		}
		
		int min = Integer.MAX_VALUE;
		for (int i=0; i<(1<<N); i++) {
			int diff = 0;
			for (int j=0; j<N; j++) {
				if ((i & (1<<j)) > 0) {
					diff += nums[j];
				}
				else {
					diff -= nums[j];
				}
			}
			
			min = Math.min(min, Math.abs(diff));
		}
		
		System.out.println(min);
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
