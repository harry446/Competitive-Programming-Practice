package second;

import java.util.*;

public class LongestPathInATree {

	static int N;
	static ArrayList<Integer> adj[];
	static boolean[] visited;
	static int[] dist;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		int N = sc.nextInt();
		adj = new ArrayList[N+1];
		visited = new boolean[N+1];
		dist = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i=0; i<N-1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		
		dfs(1, 0);
		int idx = 0;
		int maxDist = 0;
		for (int i=1; i<=N; i++) {
			if (dist[i] > maxDist) {
				idx = i;
				maxDist = dist[i];
			}
		}
		
		Arrays.fill(visited, false);
		dfs(idx, 0);
		maxDist = 0;
		for (int i=1; i<=N; i++) {
			maxDist = Math.max(dist[i], maxDist);
		}
		
		System.out.println(maxDist);
		
	}
	
	public static void dfs (int n, int d) {		//d representing the distance from node to node
		visited[n] = true;
		dist[n] = d;
		
		for (int v : adj[n]) {
			if (!visited[v]) {
				dfs(v, d+1);		//dfs, distance + 1
			}
		}
	}

}
