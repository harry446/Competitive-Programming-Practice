package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC10S4 {

	public static class Pair {
		int n, w;
		
		public Pair (int n, int w) {
			this.n = n;
			this.w = w;
		}
	}
	
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
	
	static ArrayList<Pair>[][] dual = new ArrayList[1001][1001];
	static ArrayList<Edge> edge = new ArrayList<>();
	static int[] par, rank;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int M = readInt();
		par = new int[M+1];
		rank = new int[M+1];
		
		for (int i=1; i<=1000; i++) {
			for (int j=1; j<=1000; j++) {
				dual[i][j] = new ArrayList<>();
			}
		}
		
		for (int i=1; i<=M; i++) {
			par[i] = i;
		}
		
		for (int i=1; i<=M; i++) {
			int e = readInt();
			int[] corners = new int[e];
			int[] edges = new int[e];
			
			for (int j=0; j<e; j++) {
				corners[j] = readInt();
			}
			for (int j=0; j<e; j++) {
				edges[j] = readInt();
			}
			
			for (int j=0; j<e-1; j++) {
				int c1 = corners[j];
				int c2 = corners[j+1];
				
				dual[c1][c2].add(new Pair(i, edges[j]));
				dual[c2][c1].add(new Pair(i, edges[j]));
				
				if (dual[c1][c2].size() == 2) {
					edge.add(new Edge(dual[c1][c2].get(0).n, dual[c1][c2].get(1).n, edges[j]));
				}
			}
			
			int c1 = corners[e-1];
			int c2 = corners[0];
			
			dual[c1][c2].add(new Pair(i, edges[e-1]));
			dual[c2][c1].add(new Pair(i, edges[e-1]));
			
			if (dual[c1][c2].size() == 2) {
				edge.add(new Edge(dual[c1][c2].get(0).n, dual[c1][c2].get(1).n, edges[e-1]));
			}
			
		}
		
		Collections.sort(edge);
		int ans1 = 0;
		for (Edge e : edge) {
			if (union(e.n1, e.n2)) {
				ans1 += e.w;
			}
		}
		
		for (int i=1; i<=1000; i++) {
			for (int j=1; j<=1000; j++) {
				if (dual[i][j].size() == 1) {
					edge.add(new Edge(0, dual[i][j].get(0).n, dual[i][j].get(0).w));
				}
			}
		}
		
		for (int i=1; i<=M; i++) {
			par[i] = i;
			rank[i] = 0;
		}
		
		Collections.sort(edge);
		int ans2 = 0;
		for (Edge e : edge) {
			if (union(e.n1, e.n2)) {
				ans2 += e.w;
			}
		}
		
		System.out.println(Math.min(ans1, ans2));
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
