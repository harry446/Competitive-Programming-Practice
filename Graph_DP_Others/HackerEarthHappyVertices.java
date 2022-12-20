package second;

import java.util.*;
import java.io.*;

public class HackerEarthHappyVertices {
	
	static Map<Integer,LinkedList<Integer>> graph = new HashMap<>();
	static boolean[] visited;
	static int[] parents, kids;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		String[] S1 = br.readLine().split(" ");
		int N = Integer.parseInt(S1[0]);
		int M = Integer.parseInt(S1[1]);
		
		parents = new int[N+1];
		kids = new int[N+1];
		visited = new boolean [N+1];
		
		
		for (int i=0; i<M; i++) {
			String[] S2 = br.readLine().split(" ");
			int x = Integer.parseInt(S2[0]);
			int y = Integer.parseInt(S2[1]);
			
			if (!graph.containsKey(x)) {
				graph.put(x, new LinkedList<>());
			}
			graph.get(x).add(y);
			
//			kids[x]++;
			if (!graph.containsKey(y)) {
				graph.put(y, new LinkedList<>());
			}
			graph.get(y).add(x);
		}
		br.close();
		
		
		//run dfs
		for (int i=1; i<=N; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}
		
		int count = 0;
		for (int i=1; i<=N; i++) {
			if (kids[i] > kids[parents[i]]) {
				count++;
			}
		}
		
		System.out.println(count);
		
		
	}
	
	public static void dfs(int s) {
		visited[s] = true;
		
		if (parents[s] == 0) {
			parents[s] = s;
		}
		LinkedList<Integer> cur = graph.get(s);
		
		if (cur == null) {
			kids[s] = 0;
			return;
		}
		
		if (parents[s] == s) {
			kids[s] = cur.size();
		}
		else {
			kids[s] = cur.size()-1;
		}
		
		
		for (int kid : cur) {
			if (!visited[kid]) {
				parents[kid] = s;
				dfs(kid);
			}
		}
	}

	
}
