package second;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {

	static int[][] adj; 	//adjacency matrix
	static int[] dist;
	static boolean[] visited;
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		adj = new int[n][n];
		dist = new int[n];
		visited = new boolean[n];
	}

	
	public static int findMin () {
		int minDist = 99999999;
		int minNode = -1;
		for (int i=0; i<n; i++) {
			if (!visited[i] && dist[i] < minDist) {
				minDist = dist[i];
				minNode = i;
			}
		}
		return minNode;
	}
	
	public static void dijkstra (int src) {
		Arrays.fill(dist, 99999999);
		
		dist[src] = 0;
		
		while (true) {
			int u = findMin();
			if (u == -1) {
				break;
			}
			visited[u] = true;
			
			for (int i=0; i<n; i++) {
				if (!visited[i] && adj[u][i] > 0) {
					if (dist[u] + adj[u][i] < dist[i]) {		//relaxation formula
						dist[i] = dist[u] + adj[u][i];
					}
				}
			}
		}
		
	}
}
