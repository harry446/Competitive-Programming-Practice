package second;

import java.io.*;
import java.util.*;

public class CodingSpree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int N = readInt();
		int T = readInt();
		int[] points = new int[N+1];
		int[] time = new int[N+1];
		int[][] dp = new int[N+1][T+1];
		
		for (int i=1; i<=N; i++) {
			points[i] = readInt();
			time[i] = readInt();
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=0; j<=T; j++) {
				if (j < time[i]) {
					dp[i][j] = dp[i-1][j];
					continue;
				}
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time[i]] + points[i]);
			}
		}
		
		System.out.println(dp[N][T]);
//		Scanner SC = new Scanner (System.in);
//		
//		int N = SC.nextInt();
//		int T = SC.nextInt();
//		Map<Integer, LinkedList<Integer>> data = new HashMap<>();
//		double[] efficiency = new double[N+1];
//		int[] number = new int[N+1];
//		int total = 0;
//		
//		for (int i=0; i<N; i++) {
//			int V = SC.nextInt();
//			int H = SC.nextInt();
//			number[i+1] = i+1;
//			efficiency[i+1] = V*1.0/H;
//			data.put(i+1, new LinkedList<>());
//			data.get(i+1).add(V);
//			data.get(i+1).add(H);
//		}
//		
//		
//		for (int i=1; i<N; i++) {
//			for (int j=1; j<N-i+1; j++) {
//				if (efficiency[j] < efficiency[j+1]) {
//					double temp = efficiency[j];
//					efficiency[j] = efficiency[j+1];
//					efficiency[j+1] = temp;
//					int temp2 = number[j];
//					number[j] = number[j+1];
//					number[j+1] = temp2;
//				}
//			}
//		}
//		
//		
//		for (int i=1; i<=N; i++) {
//			if (T >= data.get(number[i]).get(1)) {
//				total += data.get(number[i]).get(0);
//				T -= data.get(number[i]).get(1);
//			}
//		}
//		
//		System.out.println(total);

		
		
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
