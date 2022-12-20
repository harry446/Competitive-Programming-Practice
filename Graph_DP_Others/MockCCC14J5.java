package second;

import java.io.*;
import java.util.*;

public class MockCCC14J5 {

	public static class Position {
		int r, c, t;
		
		public Position (int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int R = readInt();
		int C = readInt();
		int T = readInt();
		char[][][] graph = new char[T][R][C];
		int[][][] dist = new int[T][R][C];
		
		for (int i=0; i<T; i++) {
			for (int row=0; row<R; row++) {
				graph[i][row] = read().toCharArray();
				Arrays.fill(dist[i][row], -1);
			}
		}
		
		int BR = -1;
		int BC = -1;
		int ER = -1;
		int EC = -1;
		for (int row=0; row<R; row++) {
			for (int col=0; col<C; col++) {
				if (graph[0][row][col] == 'A') {
					BR = row;
					BC = col;
				}
				else if (graph[0][row][col] == 'B') {
					ER = row;
					EC = col;
				}
			}
		}
		
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(BR, BC, 0));
		dist[0][BR][BC] = 0;
		
		while (!q.isEmpty()) {
			Position cur = q.poll();
			int curR = cur.r;
			int curC = cur.c;
			int curT = cur.t;
			int curD = dist[curT][curR][curC];
			
			if (curR == ER && curC == EC && curT == 0) {
				break;
			}
			
			if (curR-1 >= 0 && graph[curT][curR-1][curC] != 'X' && dist[curT][curR-1][curC] == -1) {
				q.add(new Position(curR-1, curC, curT));
				dist[curT][curR-1][curC] = curD + 1;
			}
			if (curR+1 < R && graph[curT][curR+1][curC] != 'X' && dist[curT][curR+1][curC] == -1) {
				q.add(new Position(curR+1, curC, curT));
				dist[curT][curR+1][curC] = curD + 1;
			}
			if (curC-1 >= 0 && graph[curT][curR][curC-1] != 'X' && dist[curT][curR][curC-1] == -1) {
				q.add(new Position(curR, curC-1, curT));
				dist[curT][curR][curC-1] = curD + 1;
			}
			if (curC+1 < C && graph[curT][curR][curC+1] != 'X' && dist[curT][curR][curC+1] == -1) {
				q.add(new Position(curR, curC+1, curT));
				dist[curT][curR][curC+1] = curD + 1;
			}
			for (int i=0; i<T; i++) {
				if (graph[i][curR][curC] != 'X' && dist[i][curR][curC] == -1) {
					q.add(new Position(curR, curC, i));
					dist[i][curR][curC] = curD + 1;
				}
			}
		}
		
		System.out.println(dist[0][ER][EC]);
		
//		ArrayList<char[][]> graph = new ArrayList<>();
//		ArrayList<int[][]> dist = new ArrayList<>();
//		
//		for (int i=0; i<T; i++) {
//			graph.add(new char[R][C]);
//			dist.add(new int[R][C]);
//		}
//		
//		for (int i=0; i<T; i++) {
//			for (int row=0; row<R; row++) {
//				graph.get(i)[row] = read().toCharArray();
//				Arrays.fill(dist.get(i)[row], -1);
//			}
//		}
//		
//		int BR = -1;
//		int BC = -1;
//		int ER = -1;
//		int EC = -1;
//		for (int row=0; row<R; row++) {
//			for (int col=0; col<C; col++) {
//				if (graph.get(0)[row][col] == 'A') {
//					BR = row;
//					BC = col;
//				}
//				else if (graph.get(0)[row][col] == 'B') {
//					ER = row;
//					EC = col;
//				}
//			}
//		}
//		
//		Queue<Position> q = new LinkedList<>();
//		q.add(new Position(BR, BC, 0));
//		dist.get(0)[BR][BC] = 0;
//		
//		while (!q.isEmpty()) {
//			Position cur = q.poll();
//			int curR = cur.r;
//			int curC = cur.c;
//			int curT = cur.t;
//			int curD = dist.get(curT)[curR][curC];
//			
//			if (curR == ER && curC == EC && curT == 0) {
//				break;
//			}
//			
//			if (curR-1 >= 0 && graph.get(curT)[curR-1][curC] != 'X' && dist.get(curT)[curR-1][curC] == -1) {
//				q.add(new Position(curR-1, curC, curT));
//				dist.get(curT)[curR-1][curC] = curD + 1;
//			}
//			if (curR+1 < R && graph.get(curT)[curR+1][curC] != 'X' && dist.get(curT)[curR+1][curC] == -1) {
//				q.add(new Position(curR+1, curC, curT));
//				dist.get(curT)[curR+1][curC] = curD + 1;
//			}
//			if (curC-1 >= 0 && graph.get(curT)[curR][curC-1] != 'X' && dist.get(curT)[curR][curC-1] == -1) {
//				q.add(new Position(curR, curC-1, curT));
//				dist.get(curT)[curR][curC-1] = curD + 1;
//			}
//			if (curC+1 < C && graph.get(curT)[curR][curC+1] != 'X' && dist.get(curT)[curR][curC+1] == -1) {
//				q.add(new Position(curR, curC+1, curT));
//				dist.get(curT)[curR][curC+1] = curD + 1;
//			}
//			for (int i=0; i<T; i++) {
//				if (graph.get(i)[curR][curC] != 'X' && dist.get(i)[curR][curC] == -1) {
//					q.add(new Position(curR, curC, i));
//					dist.get(i)[curR][curC] = curD + 1;
//				}
//			}
//		}
		
//		System.out.println(dist.get(0)[ER][EC]);
		
		
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
 
	static String read() {
		while (st == null || !st.hasMoreTokens()) {
			try { st = new StringTokenizer(br.readLine()); 
			} catch (IOException e) {}
		}
		return st.nextToken();
	}
	static int readInt() {
		return Integer.parseInt(read());
	}
	static long readLong() {
		return Long.parseLong(read());
	}
	static double readDouble() {
		return Double.parseDouble(read());
	}
	static char readCharacter () {
		return read().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
