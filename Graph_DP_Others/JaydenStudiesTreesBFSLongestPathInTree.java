package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JaydenStudiesTreesBFSLongestPathInTree {

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
			int x = sc.nextInt();
			int y = sc.nextInt();
			adj[x].add(y);
			adj[y].add(x);
		}
		
		bfs(1);
		System.out.println("hello");
		int idx = 0;
		int maxDist = 0;
		for (int i=1; i<=N; i++) {
			if (dist[i] > maxDist) {
				idx = i;
				maxDist = dist[i];
			}
		}
		
		System.out.println("hi");
		Arrays.fill(visited, false);
		bfs(idx);
		maxDist = 0;
		for (int i=1; i<=N; i++) {
			maxDist = Math.max(dist[i], maxDist);
		}
	}

	public static void bfs (int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		dist[n] = 0;
		visited[n] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int v : adj[cur]) {
				visited[v] = true;
				q.add(v);
				dist[v] = dist[cur]+1;
			}
		}
		
	}
}
