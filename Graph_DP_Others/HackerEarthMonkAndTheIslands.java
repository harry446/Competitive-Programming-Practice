package second;

import java.util.*;

public class HackerEarthMonkAndTheIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int T = SC.nextInt();
		
		for (int k=0; k<T; k++) {
			int N = SC.nextInt();
			int M = SC.nextInt();
			boolean[] visited = new boolean[N+1];
			Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
			LinkedList<Integer> queue = new LinkedList<>();
			
			for (int i=0; i<M; i++) {
				int x = SC.nextInt();
				int y = SC.nextInt();
				
				if (!graph.containsKey(x)) {
					graph.put(x, new LinkedList<>());
				}
				graph.get(x).add(y);
				
				if (!graph.containsKey(y)) {
					graph.put(y, new LinkedList<>());
				}
				graph.get(y).add(x);
			}
			
			visited[1] = true;
			queue.add(1);
			int step = 0;
			
			while (!queue.isEmpty()) {
				int size = queue.size();
//				step++;
				
				for (int i=0; i<size; i++) {
					int temp = queue.pop();
//					System.out.println(temp + " temp " + step);
					if (temp == N) {
						System.out.println(step);
						break;
					}
					LinkedList<Integer> cur = graph.get(temp);
					
					if (cur == null) {
						continue;
					}
					
					for (int kids : cur) {
						if (!visited[kids]) {
							queue.add(kids);
							visited[kids] = true;
						}
					}
					
				}
				step++;
			}
			
		}
	}

}
