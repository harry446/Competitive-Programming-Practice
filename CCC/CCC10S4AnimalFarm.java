package second;

import java.io.*;
import java.util.*;

public class CCC10S4AnimalFarm {

	static class Pair {
		int f, s;
		
		public Pair (int f, int s) {
			this.f = f;
			this.s = s;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int u, v, w;
		
		public Edge (int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		public int compareTo (Edge other) {
			return this.w - other.w;
		}
	}
	static int[] par, rank;
	static ArrayList<Pair>[][] dual;
	static ArrayList<Edge> edges1, edges2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		par = new int[N+5];
		rank = new int[N+5];
		dual = new ArrayList[1005][1005];
		edges1 = new ArrayList<>();
		edges2 = new ArrayList<>();
		
		for (int i=0; i<1005; i++) {
			for (int j=0; j<1005; j++) {
				dual[i][j] = new ArrayList<>();
			}
		}
		for (int i=1; i<=N; i++) {
			makeSet(i);
		}
		
		for (int i=1; i<=N; i++) {
			int e = readInt();	//number of edges around a particular pen
			int[] corners = new int[e];
			int[] costs = new int[e];
			
			for (int j=0; j<e; j++) {
				corners[j] = readInt();
			}
			for (int j=0; j<e; j++) {
				costs[j] = readInt();
			}
			
			
			for (int j=0; j<e-1; j++) {
				int corner1 = corners[j];
				int corner2 = corners[j+1];
				int cost = costs[j];
				dual[corner1][corner2].add(new Pair(i, cost));
				dual[corner2][corner1].add(new Pair(i, cost));
				
				if (dual[corner1][corner2].size() == 2) {
					Pair n1 = dual[corner1][corner2].get(0);
					Pair n2 = dual[corner1][corner2].get(1);
					edges1.add(new Edge(n1.f, n2.f, cost));
					edges2.add(new Edge(n1.f, n2.f, cost));
				}
			}
			
			//last one in the list, cycles back
			int corner1 = corners[e-1];
			int corner2 = corners[0];
			int cost = costs[e-1];
			dual[corner1][corner2].add(new Pair(i, cost));
			dual[corner2][corner1].add(new Pair(i, cost));
			
			if (dual[corner1][corner2].size() == 2) {
				Pair n1 = dual[corner1][corner2].get(0);
				Pair n2 = dual[corner1][corner2].get(1);
				edges1.add(new Edge(n1.f, n2.f, cost));
				edges2.add(new Edge(n1.f, n2.f, cost));
			}
		}
		
		
		
		Collections.sort(edges1);
		int ansNotOutside = 0;
		int ansIsOutside = 0;
		for (Edge e : edges1) {
			int u = e.u;
			int v = e.v;
			int w = e.w;
			if (union(u, v)) {
				ansNotOutside += w;
			}
		}
		
		for (int i=0; i<1005; i++) {
			for (int j=0; j<1005; j++) {
				if (dual[i][j].size() == 1) {
					Pair n1 = dual[i][j].get(0);
					edges2.add(new Edge(0, n1.f, n1.s));
				}
			}
		}
		for (int i=1; i<=N; i++) {
			makeSet(i);
		}
		Collections.sort(edges2);
		for (Edge e : edges2) {
			int u = e.u, v = e.v, w = e.w;
			if (union(u, v)) {
				ansIsOutside += w;
			}
		}
		
		System.out.println(Math.min(ansNotOutside, ansIsOutside));
		
	}

	public static void makeSet (int n) {
		par[n] = n;
		rank[n] = 1;
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
			if (rank[a] > rank[b]) {
				par[b] = a;
			}
			else {
				if (rank[a] == rank[b]) {
					rank[b]++;
				}
				par[a] = b;
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
}
