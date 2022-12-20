package second;

import java.util.*;

public class CCC06J4 {
	
	static ArrayList<LinkedList<Integer>> adj = new ArrayList<>();
	static int[] inDegree = new int[8];
	static boolean[] visited = new boolean[9];
	static String T = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		int x = 10;
		int y = 10;
		
		for (int i=0; i<9; i++) {
			adj.add(new LinkedList<>());
		}
		while (x!=0 && y!=0) {
			x = SC.nextInt();
			y = SC.nextInt();
			adj.get(x).add(y);
			inDegree[y]++;
		}
		adj.get(1).add(7);
		adj.get(1).add(4);
		adj.get(2).add(1);
		adj.get(3).add(4);
		adj.get(3).add(5);
		inDegree[7]++;
		inDegree[4]++;
		inDegree[1]++;
		inDegree[4]++;
		inDegree[5]++;
		
		if (topologicalSort().length() == 14) {
			System.out.println(T);
		}
		else {
			System.out.println("Cannot complete these tasks. Going to bed.");
		}
		
	}

	public static String topologicalSort() {
		PriorityQueue<Integer> Queue = new PriorityQueue<>();
		for (int i=1; i<8; i++) {
			if (inDegree[i] == 0) {
				Queue.add(i);
				visited[i] = true;
			}
		}
		
		while (!Queue.isEmpty() ) {
			int vertex = Queue.poll();
			T += Integer.toString(vertex);
			T += " ";
			LinkedList<Integer> children = adj.get(vertex);
			for (int m : children) {
				inDegree[m]--;
				if (inDegree[m] == 0 && !visited[m]) {
					Queue.add(m);
					visited[m] = true;
				}
			}
		}
		return T;
	}
}
