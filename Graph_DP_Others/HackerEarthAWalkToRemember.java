package second;

import java.util.*;
import java.io.*;

public class HackerEarthAWalkToRemember {
	
	static boolean[] visited;
	static Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
	static Map<Integer, LinkedList<Integer>> graphR = new HashMap<>();
	static Stack<Integer> sk = new Stack<>();
	static boolean[] Pos;
	static int count;
//	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] re = br.readLine().split(" ");
		int N = Integer.parseInt(re[0]);
		int M = Integer.parseInt(re[1]);
		visited = new boolean[N+1];
		Pos = new boolean[N+1];
		
		for (int i=0; i<M; i++) {
			String[] re2 = br.readLine().split(" ");
			int A = Integer.parseInt(re2[0]);
			int B = Integer.parseInt(re2[1]);
			
			if (!graph.containsKey(A)) {
				graph.put(A, new LinkedList<>());
			}
			graph.get(A).add(B);
			
			if (!graphR.containsKey(B)) {
				graphR.put(B, new LinkedList<>());
			}
			graphR.get(B).add(A);
		}
		br.close();
		
		for (int key : graph.keySet()) {
			if (!visited[key]) {
				dfs(key);
			}
		}
		
		Arrays.fill(visited, false);
		
		while (!sk.isEmpty()) {
			int temp = sk.pop();
			if (visited[temp]) {
				continue;
			}
			
			count = 0;
			dfs2(temp);
			
			if (count == 1) {
				Pos[temp] = false;
//				set.remove(temp);
			}
		}
		
		for (int i=1; i<N+1; i++) {
			if (Pos[i]) {
				System.out.print(1 + " ");
				continue;
			}
//			if (set.contains(i)) {
//				System.out.print(1 + " ");
//				continue;
//			}
			System.out.print(0 + " ");
		}
		
		
	}
	
	public static void dfs(int s) {
		visited[s] = true;
		LinkedList<Integer> cur = graph.get(s);
		
		if (cur == null) {
			sk.add(s);
			return;
		}
		
		for (int kid : cur) {
			if (!visited[kid]) {
				dfs(kid);
			}
		}
		
		sk.add(s);
//		return;
	}

	
	public static void dfs2(int s) {
		visited[s] = true;
		LinkedList<Integer> cur = graphR.get(s);
		count++;
		Pos[s] = true;
//		set.add(s);
		
		if (cur == null) {
			return;
		}
		
		for (int kid : cur) {
			if (!visited[kid]) {
				dfs2(kid);
			}
		}
		
	}
	
}
