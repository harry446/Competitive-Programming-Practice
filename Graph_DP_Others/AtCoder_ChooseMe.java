package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AtCoder_ChooseMe {

	static class Pair implements Comparable<Pair> {
		int a, b;
		
		public Pair (int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		public int compareTo (Pair o) {
//			if (a*2+b > o.a*2+o.b) {
//				return 1;
//			}
//			else {
//				return 0;
//			}
			
			return (2*o.a+o.b) - (2*a+b);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int A = 0, B = 0, count = 0;
		Pair[] cities = new Pair[N];
		
		for (int i=0; i<N; i++) {
			int a = readInt();
			int b = readInt();
			cities[i] = new Pair(a, b);
			
			A += a;
		}
		
		Arrays.sort(cities);
		
		while (A >= B) {
			A -= cities[count].a;
			B += cities[count].a + cities[count].b;
			count++;
		}
		
		System.out.println(count);
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
