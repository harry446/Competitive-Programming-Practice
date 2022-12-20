package second;

import java.util.*;


public class HackerEarthPearl2018 {
	
	public static class Pair {
		int a, w;
		public Pair(int a1, int w1){
			a = a1;
			w = w1;
		}
	}
	
	static ArrayList<LinkedList<Pair>> graph = new ArrayList<>();
	static int total = 0;
	static int N;
	static int[] path, H;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		N = SC.nextInt();;
		path = new int[N+1];
		H = new int[N+1];
		visited = new boolean[N+1];
		
		
		for (int i=1; i<N+1; i++) {
			H[i] = SC.nextInt();;
		}
		
		for (int i=0; i<=N; i++) {
			graph.add(new LinkedList<>());
		}
		
		
		for (int i=0; i<N-1; i++) {
			int x = SC.nextInt();;
			int y = SC.nextInt();;
			int w = SC.nextInt();;
			
			graph.get(x).add(new Pair(y, w));
			graph.get(y).add(new Pair(x, w));
			total += w;
		}
		SC.close();
		
		path[1] = 0;
		
		dfs(1, 0);
			
		int min = Integer.MAX_VALUE;
		
		for (int i=1; i<=N; i++) {
			int P = 2*total - path[i] + H[i];
			min = Math.min(P, min);
		}
		
		System.out.println(min);
		
		
	}

	public static void dfs(int s, int pa) {
		visited[s] = true;
		LinkedList<Pair> cur = graph.get(s);
		
		for (Pair kid : cur) {
			if (!visited[kid.a] && kid.a != pa) {
				path[kid.a] = path[s] + kid.w;
				dfs(kid.a, s);
			}
		}
	}
}
