package second;

import java.util.*;

public class CCC10J5 {

	public static class Pair {
		int r, c;
		
		public Pair (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		int BC = SC.nextInt()-1;
		int BR = 8-SC.nextInt();
		int EC = SC.nextInt()-1;
		int ER = 8-SC.nextInt();
		
		
		int[][] dist = new int[8][8];
		for (int i=0; i<8; i++) {
			Arrays.fill(dist[i], -1);
		}
		
		Queue<Pair> q = new LinkedList<>();
		dist[BR][BC] = 0;
		q.add(new Pair(BR, BC));
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int curR = cur.r;
			int curC = cur.c;
//			System.out.println("HI");
			if (curR-1 >= 0 && curC+2 < 8 && dist[curR-1][curC+2] == -1) {
				q.add(new Pair(curR-1, curC+2));
				dist[curR-1][curC+2] = dist[curR][curC] + 1;
			}
			if (curR+1 < 8 && curC+2 < 8 && dist[curR+1][curC+2] == -1) {
				q.add(new Pair(curR+1, curC+2));
				dist[curR+1][curC+2] = dist[curR][curC] + 1;
			}
			if (curR+2 < 8 && curC+1 < 8 && dist[curR+2][curC+1] == -1) {
				q.add(new Pair(curR+2, curC+1));
				dist[curR+2][curC+1] = dist[curR][curC] + 1;
			}
			if (curR+2 < 8 && curC-1 >= 0 && dist[curR+2][curC-1] == -1) {
				q.add(new Pair(curR+2, curC-1));
				dist[curR+2][curC-1] = dist[curR][curC] + 1;
			}
			if (curR+1 < 8 && curC-2 >= 0 && dist[curR+1][curC-2] == -1) {
				q.add(new Pair(curR+1, curC-2));
				dist[curR+1][curC-2] = dist[curR][curC] + 1;
			}
			if (curR-1 >= 0 && curC-2 >= 0 && dist[curR-1][curC-2] == -1) {
				q.add(new Pair(curR-1, curC-2));
				dist[curR-1][curC-2] = dist[curR][curC] + 1;
			}
			if (curR-2 >= 0 && curC-1 >= 0 && dist[curR-2][curC-1] == -1) {
				q.add(new Pair(curR-2, curC-1));
				dist[curR-2][curC-1] = dist[curR][curC] + 1;
			}
			if (curR-2 >= 0 && curC+1 < 8 && dist[curR-2][curC+1] == -1) {
				q.add(new Pair(curR-2, curC+1));
				dist[curR-2][curC+1] = dist[curR][curC] + 1;
			}
		}

//		for (int row=0; row<8; row++) {
//			for (int col=0; col<8; col++) {
//				System.out.printf("%2d ", dist[row][col]);
//			}
//			System.out.println();
//		}
		System.out.println(dist[ER][EC]);
	}

}
