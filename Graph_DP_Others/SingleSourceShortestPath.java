package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SingleSourceShortestPath {
	
//	public static class Pair implements Comparable<Pair> {
//		int node;
//		int du;
//		public Pair (int node, int du) {
//			this.node = node;
//			this.du = du;
//		}
//		
//		public int compareTo (Pair other) {
//			if (du >= other.du) {
//				return 1;
//			}
//			else {
//				return -1;
//			}
//		}
//	}
//	
//	static ArrayList<Pair> adj[];
//	static int[] dist;
	
	public static class Pair implements Comparable <Pair> {
		int n2;
		int weight;
		
		public Pair (int n2, int weight) {
			this.n2 = n2;
			this.weight = weight;
		}
		
		public int compareTo (Pair other) {
			return weight - other.weight;
		}
		
	}
	
	
	static ArrayList<Pair> adj[];
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int N = readInt();
		int M = readInt();
		adj = new ArrayList[N+1];
		dist = new int[N+1];
		visited = new boolean[N+1];
		
		for (int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			int u = readInt();
			int v = readInt();
			int w = readInt();
			
			adj[u].add(new Pair(v, w));
			adj[v].add(new Pair(u, w));
		}
		
		PriorityQueue<Pair> q = new PriorityQueue<>();
		Arrays.fill(dist, 0x3f3f3f3f);
		dist[1] = 0;
		q.add(new Pair(1, 0));
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			if (visited[cur.n2]) {
				continue;
			}
			
			visited[cur.n2] = true;
			for (Pair k : adj[cur.n2]) {
				if (dist[k.n2] > dist[cur.n2] + k.weight) {
					dist[k.n2] = dist[cur.n2] + k.weight;
					q.add(new Pair(k.n2, dist[k.n2]));
				}
			}
		}
		
//		Scanner sc = new Scanner (System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		adj = new ArrayList[n+1];
//		dist = new int[n+1];
//		for (int i=0; i<n+1; i++) {
//			adj[i] = new ArrayList<>();
//		}
//		
//		for (int i=0; i<m; i++) {
//			int u = sc.nextInt();
//			int v = sc.nextInt();
//			int w = sc.nextInt();
//			adj[u].add(new Pair(v, w));
//            adj[v].add(new Pair(u, w));
//		}
//		
//		PriorityQueue<Pair> q = new PriorityQueue<>();
//		Arrays.fill(dist, Integer.MAX_VALUE);
//		dist[1] = 0;
//		q.add(new Pair(1,0));
//		
//		while (!q.isEmpty()) {
//			Pair cur = q.poll();
//			int u = cur.node;
//			
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
	static char readCharacter() {
		return read().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}

}
