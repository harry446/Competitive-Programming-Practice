package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC12S3 {

	public static class Pair implements Comparable<Pair> {
		int n, freq;
		
		public Pair (int n, int freq) {
			this.n = n;
			this.freq = freq;
		}
		
		public int compareTo (Pair other) {
			if (freq > other.freq) {
				return -1;
			}
			else if (freq < other.freq) {
				return 1;
			}
			else {
				return n - other.n;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		Pair[] a = new Pair[1000];
		
		for (int i=0; i<1000; i++) {
			a[i] = new Pair(i, 0);
		}
		
		for (int i=0; i<N; i++) {
			a[readInt()-1].freq++;
		}
		
		Arrays.sort(a);
//		for (Pair k : a) {
//			System.out.println(k.n + ", " + k.freq);
//		}
		
		boolean flag = false;
		if (a[0].freq == a[1].freq) {
			flag = true;
		}
		
		for (int i=1; i<1000; i++) {
			if (flag) {
				if (a[i].freq != a[0].freq) {
					int max = 0;
					for (int j=i-1; j>0; j--) {
						max = Math.max(max, Math.abs(a[0].n - a[j].n));
					}
					System.out.println(max);
					return;
				}
			}
			else {
				if (a[i].freq != a[1].freq) {
					int max = 0;
					for (int j=i-1; j>0; j--) {
						max = Math.max(max, Math.abs(a[0].n - a[j].n));
					}
					System.out.println(max);
					return;
				}
			}
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
	static char readCharacter() {
		return read().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
