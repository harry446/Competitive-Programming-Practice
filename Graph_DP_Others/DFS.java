package second;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class DFS {

	static boolean[] visited;
	static Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int n = SC.nextInt();
		int e = SC.nextInt();
		visited = new boolean[n];
		
		for (int i=0; i<e; i++) {
			int bp = SC.nextInt();
			int ep = SC.nextInt();
			
			if (!graph.containsKey(bp)) {
				graph.put(bp, new LinkedList<Integer>());
			}
			graph.get(bp).add(ep);
			
			if (!graph.containsKey(ep)) {
				graph.put(ep, new LinkedList<Integer>());
			}
			graph.get(ep).add(bp);
		}
		
		
		int components = 0;
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				components++;
				dfs(i);
			}
		}
		
		System.out.println(components);
		
		
	}
	
	public static void dfs(int s) {
		visited[s] = true;
		LinkedList<Integer> cur = graph.get(s);
		
		if (cur == null) {
			return;
		}
		
		for (int kid : cur) {
			if (!visited[kid]) {
				dfs(kid);
			}
		}
		
		return;
		
		
	}

}
