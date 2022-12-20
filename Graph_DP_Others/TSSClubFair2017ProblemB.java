package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TSSClubFair2017ProblemB {

//	public static class Pair implements Comparable<Pair> {
//		int dist, order;
//		
//		public Pair (int dist, int order) {
//			this.dist = dist;
//			this.order = order;
//		}
//		
//		public int compareTo (Pair o) {
//			return dist - o.dist;
//		}
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int Q = readInt();
		int[] psa = new int[1414215];
		
		for (int i=0; i<N; i++) {
			psa[(int)Math.ceil(Math.sqrt(Math.pow(readInt(), 2) + Math.pow(readInt(), 2)))]++;
		}
		
		for (int i=1; i<=1414214; i++) {
			psa[i] += psa[i-1];
		}
		
		for (int i=0; i<Q; i++) {
			int q = readInt();
			System.out.println(psa[q]);
		}
		
		
//		int[] ans = new int[Q];
//		int[] houses = new int[N+1];
//		Pair[] q = new Pair[Q];
//		
//		for (int i=0; i<N; i++) {
//			houses[i] = (int)Math.ceil(Math.sqrt(Math.pow(readInt(), 2) + Math.pow(readInt(), 2)));
//		}
//		houses[N] = Integer.MAX_VALUE;
//		
//		for (int i=0; i<Q; i++) {
//			q[i] = new Pair(readInt(), i);
//		}
//		Arrays.sort(houses);
//		Arrays.sort(q);
//		
//		int index = 0;
//		for (int i=0; i<=N; i++) {
//			if (houses[i] > q[index].dist) {
//				ans[q[index].order] = i;
//				index++;
//				i--;
//			}
//			if (index == Q) {
//				break;
//			}
//		}
//		
//		for (int i=0; i<Q; i++) {
//			System.out.println(ans[i]);
//		}
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
