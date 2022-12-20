package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DMOPC16Contest4P5 {

	public static class Edge {
		int ev, w;
		
		public Edge (int ev, int w) {
			this.ev = ev;
			this.w = w;
		}
	}
	
	static int N, M;
	static ArrayList<Edge>[] adj;
	static boolean[] mstSet, visited;
	static int[] par, value;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		N = readInt();
		M = readInt();
		adj = new ArrayList[N+1];
		mstSet = new boolean[N+1];
		visited = new boolean[N+1];
		
		for (int i=1; i<=N; i++) {
			
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
