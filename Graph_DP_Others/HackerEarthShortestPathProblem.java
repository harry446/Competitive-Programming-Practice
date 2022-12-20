package second;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HackerEarthShortestPathProblem {

	public static class Pair implements Comparable<Pair> {
		int node;
		int du;
		
		public Pair (int node, int du) {
			this.node = node;
			this.du = du;
		}
		
		public int compareTo(Pair other) {
			if (du >= other.du) {
				return 1;
			}
			else {
				return -1;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int n = SC.nextInt();
		int m = SC.nextInt();
		int[] dist = new int[n+1];
		HashMap<Integer, LinkedList<Pair>> mp = new HashMap<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		
		for (int i=0; i<m; i++) {
			int x = SC.nextInt();
			int y = SC.nextInt();
			int w = SC.nextInt();
			if (!mp.containsKey(x)) {
				mp.put(x, new LinkedList<>());
			}
			
			mp.get(x).add(new Pair(y, w));
		}
		
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		
		pq.add(new Pair(1, 0));
		
		while(!pq.isEmpty()) {
			Pair cur = pq.poll();
			
			LinkedList<Pair> kids = mp.get(cur.node);
			if (kids == null) {
				continue;
			}
			
			for (Pair kid : kids) {
				if (dist[kid.node] > cur.du + kid.du) {
					dist[kid.node] = cur.du + kid.du;
					pq.add(new Pair(kid.node, dist[kid.node]));
				}
			}
		}
		
		for (int i=2; i<=n; i++) {
			System.out.print(dist[i] + " ");
		}
	}

}
