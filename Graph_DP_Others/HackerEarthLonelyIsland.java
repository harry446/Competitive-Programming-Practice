package second;

import java.util.*;

public class HackerEarthLonelyIsland {
	
	static Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
	static Set<Integer> tip = new HashSet<>();
	static Map<Integer, Double> p = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
			
		int N = SC.nextInt();
		int M = SC.nextInt();
		int R = SC.nextInt();
		
		
		for (int i=0; i<M; i++) {
			int A = SC.nextInt();
			int B = SC.nextInt();
			if (!graph.containsKey(A)) {
				graph.put(A, new LinkedList<>());
			}
			graph.get(A).add(B);
		}
		
		p.put(R, (double)1);
		dfs(R);
		
		int[] ans = new int[tip.size()];
		
		double max = 0;
		for (int cur : tip) {
			max = Math.max(max, p.get(cur));
		}
		
		int count = 0;
		for (int cur : tip) {
			if (p.get(cur) == max || max-p.get(cur) <= Math.pow(10, -9)) {
				ans[count] = cur;
				count++;
			}
		}
		Arrays.sort(ans);
		
		for (int i=0; i<tip.size(); i++) {
			if (ans[i] != 0) {
				System.out.print(ans[i] + " ");
			}
			
		}
	}
	
	public static void dfs(int s) {
		LinkedList<Integer> cur = graph.get(s);
		
		if (cur == null) {
			tip.add(s);
			return;
		}
		
		for (int kid : cur) {
			if (!p.containsKey(kid)) {
				p.put(kid, (double)0);
			}
			p.put(kid, (double)p.get(kid)+ (double)1/cur.size()*(double)p.get(s));
			
			dfs(kid);
		}
	}

}
