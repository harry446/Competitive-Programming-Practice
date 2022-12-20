package second;

import java.util.Arrays;
import java.util.Scanner;

public class Duowei1645ShortestPathGrid {
	
	static int v, e, s;
	static int[][] graph;
	static int[] du;
	static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		v = SC.nextInt();
		e = SC.nextInt();
		s = SC.nextInt();
		
		graph = new int[v][e];
		du = new int[v];
		visited = new boolean[v];
		
	}
	
	public static int findMin() {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for (int i=0; i<v; i++) {
			if (!visited[i] && du[i] < min) {
				min = du[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	public static void dijstra() {
		Arrays.fill(du, Integer.MAX_VALUE);
//		Arrays.fill(visited, false);
		du[s] = 0;
		
		while (true) {
			int k = findMin();
			if (k == -1) {
				break;
			}
			
			visited[k] = true;
			for (int i=0; i<v; i++) {
				if (!visited[i] && graph[k][i] > 0) {
					if (du[i] > du[k] + graph[k][i]) {
						du[i] = du[k] + graph[k][i];
					}
				}
			}
		}
	}

}
