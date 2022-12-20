package second;

import java.util.*;

public class HackerEarthSocialNetworkingGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int n = SC.nextInt();
		int e = SC.nextInt();
		Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
		
		//graph input
		for (int i=0; i<e; i++) {
			int u = SC.nextInt();
			int v = SC.nextInt();
			
			if (!graph.containsKey(u)) {
				graph.put(u, new LinkedList<>());
			}
			graph.get(u).add(v);
			
			if (!graph.containsKey(v)) {
				graph.put(v, new LinkedList<>());
			}
			graph.get(v).add(u);
		}
		
		//queries
		int m = SC.nextInt();
		for (int j=0; j<m; j++) {
			boolean[] visited = new boolean[n];
			LinkedList<Integer> queue = new LinkedList<>();
			int count = 0;
			int start = SC.nextInt();
			int t = SC.nextInt();
			
			//bfs
			visited[start] = true;
			queue.add(start);
			int step = 0;
			
			while (!queue.isEmpty()) {
				int size = queue.size();
				step++;
				
				for (int i=0; i<size; i++) {
					int temp = queue.pop();
					LinkedList<Integer> cur = graph.get(temp);
					
					if (cur == null) {
						continue;
					}

					for (int kids : cur) {
						if (!visited[kids]) {
							queue.add(kids);
							visited[kids] = true;
							if (step == t) {
								count++;
							}
						}	
					}
				}
			}
			
			System.out.println(count);

			
		}
		SC.close();
		
		
	}

}
