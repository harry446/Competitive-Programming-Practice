package second;

import java.util.*;

public class DMPG15S6 {
	
	static class Edge {
		int n;
		double p;
		public Edge(int n, double p) {
			this.n = n;
			this.p = p;
		}
		
	}

	static ArrayList<Edge>[] adj;
	static Map<String, Integer> map = new HashMap<>();;
	static double[] max;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		adj = new ArrayList[N+1];
		max = new double[N+1];
		
		for (int i=0; i<N; i++) {
			String name = sc.next();
			map.put(name, i);
			adj[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			String a = sc.next();
			String b = sc.next();
			double c = sc.nextDouble();
			
			int u = map.get(a);
			int v = map.get(b);
			adj[u].add(new Edge(v, c));
		}
		
		Queue<Integer> q = new LinkedList<>();
		max[map.get("APPLES")] = 1.0;
		q.add(map.get("APPLES"));
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (max[cur] > 1.1 && cur == map.get("APPLES")) {
				System.out.println("YA");
				return;
			}
			for (Edge e : adj[cur]) {
				int v = e.n;
				double w = e.p;
				if (max[v] < max[cur] * w) {
					max[v] = max[cur] * w;
					q.add(v);
				}
			}
		}
		
		System.out.println("NAW");
	}

}
