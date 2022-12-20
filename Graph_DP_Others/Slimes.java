package second;

import java.io.*;
import java.util.*;

public class Slimes {

	static Map<String, Long> dp = new HashMap<>();
	static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		
		long[] slimes = new long[N+1];
		long[][] dp = new long[N+1][N+1];
		
		for (int i=1; i<=N; i++) {
			dp[i][i] = readLong();
			slimes[i] = dp[i][i] + slimes[i-1];
		}
		
		for (int i=1; i<N; i++) {
			for (int j=1; j<=N-i; j++) {
				long min = Long.MAX_VALUE;
				int index = i + j;
				
				for (int k=j; k<index; k++) {
					min = Math.min(min, slimes[index] - slimes[j-1] + dp[j][k] + dp[k+1][index]);
				}
				
				dp[j][index] = min;
				
			}
		}
		
//		for (int i=0; i<=N; i++) {
//			for (int j=0; j<=N; j++) {
//				System.out.printf("%2d ", dp[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(dp[1][N] - slimes[N]);
//		ArrayList<Long> slimes = new ArrayList<>();
//		
//		for (int i=0; i<N; i++) {
//			slimes.add(readLong());
//		}
//		
//		System.out.println(find(slimes));
	}
	
//	public static long find (ArrayList<Long> slimes) {
//		
////		for (long k : slimes) {
////			System.out.print(k + " ");
////		}
////		System.out.println();
//		System.out.println(count++);
//		if (slimes.size() == 1) {
//			return 0;
//		}
//		
//		String S = "";
//		for (long k : slimes) {
//			S += k + ",";
//		}
//		
//		if (dp.containsKey(S)) {
//			return dp.get(S);
//		}
//		
//		ArrayList<Long> cur = slimes;
//		long min = Long.MAX_VALUE;
//		
//		for (int i=0; i<cur.size()-1; i++) {
//			long a = cur.get(i);
//			long b = cur.get(i+1);
//			long cost = a + b;
//			cur.remove(i);
//			cur.remove(i);
//			cur.add(i, cost);
//			min = Math.min(min, find(cur) + cost);
//			
//			cur.remove(i);
//			cur.add(i, a);
//			cur.add(i+1, b);
//		}
//		
//		
//		dp.put(S, min);
//		return min;
//	}

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
}
