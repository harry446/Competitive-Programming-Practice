package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DMOJLandSeriesFakeJudges {

//	public static class Pair implements Comparable<Pair> {
//		int a, b;
//		
//		public Pair (int a, int b) {
//			this.a = a;
//			this.b = b;
//		}
//		
//		public int compareTo (Pair o) {
//			return a - o.a;
////			if (a > o.a) {
////				return 1;
////			}
////			else if (a < o.a) {
////				return -1;
////			}
////			return 0;
//		}
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int Q = readInt();
		int[] points = new int[N];
		int[] psa = new int[N+1];
		
		for (int i=0; i<N; i++) {
			points[i] = readInt();
		}
		
		for (int i=0; i<Q; i++) {
			psa[readInt()-1] += 1;
			psa[readInt()] -= 1;
		}
		
		for (int i=1; i<N; i++) {
			psa[i] += psa[i-1];
		}
//		psa[N] = -1;
		Arrays.sort(points);
		Arrays.sort(psa);
		
		long ans = 0;
		for (int i=1; i<=N; i++) {
			ans += psa[i] * (long)points[N-i];
		}
		
		System.out.println(ans);
//		int[] points = new int[N];
//		int[] diff = new int[N+2];
//		Pair[] q = new Pair[Q];
//		Pair[] psa1 = new Pair[N+1];
//		long[] psa2 = new long[N+1];
//		
//		for (int i=0; i<N; i++) {
//			points[i] = readInt();
//		}
//		Arrays.sort(points);
//		
//		for (int i=0; i<Q; i++) {
//			int a = readInt();
//			int b = readInt();
//			q[i] = new Pair(a, b);
//			
//			diff[a] += 1;
//			diff[b+1] -= 1;
//		}
//		
//		psa1[0] = new Pair(0, 0);
//		for (int i=1; i<=N; i++) {
//			psa1[i] = new Pair(psa1[i-1].a + diff[i], i);
//		}
//		Arrays.sort(psa1);
//		
//		for (int i=N; i>=1; i--) {
//			psa2[psa1[i].b] = points[N-i];
//		}
//		
//		for (int i=1; i<=N; i++) {
//			psa2[i] += psa2[i-1];
//		}
//		
//		long sum = 0;
//		for (int i=0; i<Q; i++) {
//			sum += psa2[q[i].b] - psa2[q[i].a-1];
//		}
		
//		System.out.println(sum);
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
