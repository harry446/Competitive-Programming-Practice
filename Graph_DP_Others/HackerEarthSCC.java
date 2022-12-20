package second;

import java.util.*;

public class HackerEarthSCC {

	static Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
	static Map<Integer, LinkedList<Integer>> graphR = new HashMap<>();
	static boolean[] visited;
	static Stack<Integer> stack = new Stack<>();
	static Map<Integer, LinkedList<Integer>> ar = new HashMap<>();
	static int count = 0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int N = SC.nextInt();
		int M = SC.nextInt();
		visited = new boolean[N+1];
		
		for (int i=0; i<M; i++) {
			int A = SC.nextInt();
			int B = SC.nextInt();
			
			if (!graph.containsKey(A)) {
				graph.put(A, new LinkedList<>());
			}
			graph.get(A).add(B);
			
			if (!graphR.containsKey(B)) {
				graphR.put(B, new LinkedList<>());
			}
			graphR.get(B).add(A);
		}
		
		for (int i=1; i<N+1; i++) {
			if (!graph.containsKey(i)) {
				graph.put(i, new LinkedList<>());
			}
			if (!graphR.containsKey(i)) {
				graphR.put(i, new LinkedList<>());
			}
		}
		
		
		
		
		
		for (int key : graph.keySet()) {
			if (!visited[key]) {
				dfs(key);
			}
		}
		
		Arrays.fill(visited, false);

		while(!stack.isEmpty()) {
			int temp = stack.pop();
			if (visited[temp]) {
				continue;
			}		
			ar.put(count, new LinkedList<>());
			dfs2(temp);	
			count++;
		}
		
		int C = 0;
		int D = 0;
		for (int key : ar.keySet()) {
			if (ar.get(key).size() % 2 == 0) {
				D = D + ar.get(key).size();
				continue;
			}
			C = C + ar.get(key).size();
		}
		
		System.out.println(C-D);
		
		
		
		
	}
	
	public static void dfs(int s) {
		visited[s] = true;
		LinkedList<Integer> cur = graph.get(s);
		
		if (cur == null) {
			stack.add(s);
			return;
		}
		
		for (int kid : cur) {
			if (!visited[kid]) {
				dfs(kid);
			}
		}
		
		stack.add(s);
		return;
	}
	
	
	public static void dfs2(int s) {
		visited[s] = true;
		
		ar.get(count).add(s);
		
		LinkedList<Integer> cur = graphR.get(s);
		
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
