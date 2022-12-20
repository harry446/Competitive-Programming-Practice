package second;

import java.util.Arrays;
import java.util.Scanner;

public class Dijstra {
	
	static int n, s;
	static int[][] graph;
	static int[] du;
	static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		n = SC.nextInt();
		s = SC.nextInt();
		
	}
	
	public static int findMin() {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for (int i=0; i<n; i++) {
			if (!visited[i] && du[i] < min) {
				min = du[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	public static void dijstra() {
		for (int i=0; i<n; i++) {
			du[i] = Integer.MAX_VALUE;
		}
		Arrays.fill(visited, false);
		du[s] = 0;
		
		while (true) {
			int k = findMin();
			if (k == -1) {
				break;
			}
			
			visited[k] = true;
			for (int i=0; i<n; i++) {
				if (!visited[i] && graph[k][i] > 0) {
					if (du[i] > du[k] + graph[k][i]) {
						du[i] = du[k] + graph[k][i];
					}
				}
			}
		}
		
	}

}
