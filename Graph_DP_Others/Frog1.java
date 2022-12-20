package second;

import java.io.*;
import java.util.*;

public class Frog1 {

	static int N;
	static int[] height;
	static Map<Integer, Integer> map = new HashMap<>();
	static int[] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		height = new int[N+1];
		dp = new int[N+1];
		Arrays.fill(dp, -1);
		
		for (int i=1; i<=N; i++ ) {
			height[i] = readInt();
		}
		
		System.out.println(find(1));
	}
	
	public static int find (int x) {
		if (x == N) {
			return 0;
		}
		
//		if (map.containsKey(x)) {
//			return map.get(x);
//		}
		
		if (dp[x] != -1) {
			return dp[x];
		}
		
		int a = find(x+1) + Math.abs(height[x] - height[x+1]);
		int b = Integer.MAX_VALUE;
		if (x+2 <= N) {
			b = find(x+2) + Math.abs(height[x] - height[x+2]);
		}
		
//		int c= Math.min(a, b);
//		map.put(x, c);
//		return c;
		
		return dp[x] = Math.min(a, b);
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
