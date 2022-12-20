package second;

import java.util.*;

public class DAG {

	public static ArrayList<LinkedList<Integer>> graph = new ArrayList<>();
	public static boolean[] visited;
	public static int[] inDegree;
	public static int n, m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		n = SC.nextInt();
		m = SC.nextInt();
		inDegree = new int[n];
		visited = new boolean[n];
		
//		Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
		
		
		for (int i=0; i<n; i++) {
			inDegree[i] = 0;
			visited[i] = false;
			graph.add(new LinkedList<Integer>());
			
		}
		
		for (int i=0; i<m; i++) {
			int x = SC.nextInt()-1;
			int y = SC.nextInt()-1;
			graph.get(x).add(y);
			inDegree[y]++;
		}
		
		DAG();
		
	}

	public static void DAG() {
		Queue<Integer> queue = new LinkedList<>();
		for (int i=0; i<n; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
				visited[i] = true;
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur+1 + " ");
			
			for (int kid : graph.get(cur)) {
				if (!visited[kid]) {
					inDegree[kid]--;
					if (inDegree[kid] == 0) {
						queue.add(kid);
						visited[kid] = true;
					}
				}
			}
		}
		
		
	} 
}
