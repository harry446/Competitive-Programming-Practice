package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GFSSOC15FallS4 {

	static class Edge implements Comparable<Edge> {
		int nd, dist;
		int called;
		
		public Edge (int nd, int dist, int called) {
			this.nd = nd;
			this.dist = dist;
			this.called = called;
		}
		
		public int compareTo (Edge other) {
			return dist - other.dist;
		}
		
	}
	
	static int N, M;
	static ArrayList<Edge>[] adj1, adj2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		M = readInt();
		adj1 = new ArrayList[N+1];
		adj2 = new ArrayList[N+1];
		
		for (int i=1; i<=N; i++) {
			adj1[i] = new ArrayList<>();
			adj2[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			int u = readInt();
			int v = readInt();
			int w = readInt();
			adj1[u].add(new Edge(v, w, 0));
		}
		
		int D = readInt();
		for (int i=0; i<D; i++) {
			int u = readInt();
			int v = readInt();
			int w = readInt();
			adj2[u].add(new Edge(v, w, 0));
		}
		
		
		int[][] dist = new int[N+1][2];
		
		for (int i=1; i<=N; i++) {
			Arrays.fill(dist[i], 0x3f3f3f3f);
		}
		dist[1][0] = 0;
		
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.add(new Edge(1, 0, 0));
		
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			int u = cur.nd;
			int du = cur.dist;
			int flagU = cur.called;
			if (dist[u][flagU] != du) {
				continue;
			}
			
			for (Edge e : adj1[u]) {
				int v = e.nd;
				int dv = e.dist;
				int d = dist[u][flagU] + dv;
				if (d < dist[v][flagU]) {
					dist[v][flagU] = d;
					q.add(new Edge(v, d, flagU));
				}
			}
			
			if (flagU == 0) {
				for (Edge e : adj2[u]) {
					int v = e.nd;
					int dv = e.dist;
					int d = dist[u][0] + dv;
					if (d < dist[v][1]) {
						dist[v][1] = d;
						q.add(new Edge(v, d, 1));
					}
				}
			}
			
			
			
		}
		
		int ans = Math.min(dist[N][0], dist[N][1]);
		System.out.println(ans == 0x3f3f3f3f ? -1 : ans);
		
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
