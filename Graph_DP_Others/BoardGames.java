package second;

import java.util.*;

public class BoardGames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = (int)1e7 + 1;
		
		int[] dist = new int[R];
		Queue<Integer> q = new LinkedList<>();
		
		dist[N] = 1;
		q.add(N);
		
		while (dist[M] == 0) {
			int cur = q.poll();
			int newDist = dist[cur] + 1;
			
			if (cur*3 <= R && dist[cur*3] == 0) {
				q.add(cur*3);
				dist[cur*3] = newDist;
			}
			if (cur-1 > 0 && dist[cur-1] == 0) {
				q.add(cur-1);
				dist[cur-1] = newDist;
			}
			if (cur-3 > 0 && dist[cur-3] == 0) {
				q.add(cur-3);
				dist[cur-3] = newDist;
			}
			if (cur%2 == 0 && dist[cur/2] == 0) {
				q.add(cur/2);
				dist[cur/2] = newDist;
			}
		}
		
		System.out.println(dist[M] - 1);
	}

}
