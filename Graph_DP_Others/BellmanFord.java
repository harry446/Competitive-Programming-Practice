package second;

import java.util.*;

public class BellmanFord {

	static class Edge {
		int n1, w;
		
		public Edge (int n1, int w) {
			this.n1 = n1;
			this.w = w;
		}
	}
	
	static ArrayList<Edge> adj[];
	static int[] dist;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		adj = new ArrayList[N+1];
		dist = new int[N+1];
		for (int i=0; i<N+1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			adj[u].add(new Edge(v, w));
			adj[v].add(new Edge(u, w));
		}
		
		Arrays.fill(dist, 99999999);
		dist[1] = 0;
		
		for (int i=1; i<=N-1; i++) {
			for (int u=1; u<=N; u++) {
				for (Edge e : adj[u]) {
					int v = e.n1;
					int w = e.w;
					if (dist[u] != 99999999 && dist[u] + w < dist[v]) {
						dist[v] = dist[u] + w;
					}
				}
			}
		}
	}

}
