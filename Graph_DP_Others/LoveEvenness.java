package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LoveEvenness {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = 2*readInt();
		int[] nums = new int[N];
		
		long total = 0;
		for (int i=0; i<N; i++) {
			nums[i] = readInt();
			total += nums[i];
		}
		Arrays.sort(nums);
		
		
		int score = 0;
		for (int i=N-1; i>=N/2; i--) {
			score += nums[i];
		}
		
		System.out.println(score - (total-score));
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
