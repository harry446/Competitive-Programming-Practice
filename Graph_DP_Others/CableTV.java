package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CableTV {

	public static class Edge implements Comparable<Edge> {
		int n1, n2, w;
		
		public Edge (int n1, int n2, int w) {
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
		}
		
		public int compareTo (Edge o) {
			return w - o.w;
		}
	}
	
	static ArrayList<Edge> A = new ArrayList<>(), B = new ArrayList<>();
	static int[] par, rank;
	static int cost = 0, count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int M = readInt();
		par = new int[N+1];
		rank = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			par[i] = i;
		}
		
		
		for (int i=0; i<M; i++) {
			int a = readInt();
			int b = readInt();
			int c = readInt();
			int d = readInt();
			
			if (d == 0) {
				A.add(new Edge(a, b, c));
			}
			else {
				B.add(new Edge(a, b, c));
			}
		}
		
		Collections.sort(A);
		Collections.sort(B);
		
		for (Edge edges : A) {
			if (union(edges.n1, edges.n2)) {
				cost += edges.w;
			}
		}
		
		for (Edge edges : B) {
			if (union(edges.n1, edges.n2)) {
				cost += edges.w;
				count++;
			}
		}
		
		System.out.println(count + " " + cost);
		
	}
	
	public static int find (int n) {
		if (par[n] == n) {
			return n;
		}
		return par[n] = find(par[n]);
	}
	
	public static boolean union (int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			if (rank[a] < rank[b]) {
				par[a] = b;
			}
			else {
				if (rank[a] == rank[b]) {
					rank[a]++;
				}
				par[b] = a;
			}
			return true;
		}
		return false;
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
