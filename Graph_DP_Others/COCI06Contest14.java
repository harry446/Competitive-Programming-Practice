package second;

import java.io.*;
import java.util.*;

public class COCI06Contest14 {
	
	public static class Pair {
		int r, c;
		
		public Pair (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int R, C;
	static char[][] graph;
	static int[][] dist1, dist2;
	static Queue<Pair> q1 = new LinkedList<>();
	static Queue<Pair> q2 = new LinkedList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		R = readInt();
		C = readInt();
		graph = new char[R][C];
		dist1 = new int[R][C];
		dist2 = new int[R][C];
		
		for (int i=0; i<R; i++) {
			graph[i] = read().toCharArray();
			Arrays.fill(dist1[i], Integer.MAX_VALUE);
			Arrays.fill(dist2[i], -1);
		}
		
		for (int row=0; row<R; row++) {
			for (int col=0; col<C; col++) {
				if (graph[row][col] == 'S') {
					graph[row][col] = '.';
					dist2[row][col] = 0;
					q2.add(new Pair(row, col));
				}
				if (graph[row][col] == '*') {
					dist1[row][col] = 0;
					q1.add(new Pair(row, col));
				}
			}
		}
		
		bfs1();
		int ans = bfs2();
		if (ans != -1) {
			System.out.println(ans);
		}
		else {
			System.out.println("KAKTUS");
		}

		
	}
	
	public static int bfs2 () {
		
		while (!q2.isEmpty()) {
			Pair cur = q2.poll();
			int curR = cur.r;
			int curC = cur.c;
			
			if (graph[curR][curC] == 'D') {
				return dist2[curR][curC];
			}
			
			if (curR-1 >= 0 && graph[curR-1][curC] != 'X' && dist2[curR][curC]+1 < dist1[curR-1][curC] && dist2[curR-1][curC] == -1) {
				q2.add(new Pair(curR-1, curC));
				dist2[curR-1][curC] = dist2[curR][curC] + 1;
			}
			if (curR+1 < R && graph[curR+1][curC] != 'X' && dist2[curR][curC]+1 < dist1[curR+1][curC] && dist2[curR+1][curC] == -1) {
				q2.add(new Pair(curR+1, curC));
				dist2[curR+1][curC] = dist2[curR][curC] + 1;
			}
			if (curC-1 >= 0 && graph[curR][curC-1] != 'X' && dist2[curR][curC]+1 < dist1[curR][curC-1] && dist2[curR][curC-1] == -1) {
				q2.add(new Pair(curR, curC-1));
				dist2[curR][curC-1] = dist2[curR][curC] + 1;
			}
			if (curC+1 < C && graph[curR][curC+1] != 'X' && dist2[curR][curC]+1 < dist1[curR][curC+1] && dist2[curR][curC+1] == -1) {
				q2.add(new Pair(curR, curC+1));
				dist2[curR][curC+1] = dist2[curR][curC] + 1;
			}
		}
		
		return -1;
		
	}
	
	public static void bfs1 () {
		
		while (!q1.isEmpty()) {
			Pair cur = q1.poll();
			int curR = cur.r;
			int curC = cur.c;
			
			if (curR-1 >= 0 && graph[curR-1][curC] == '.' && dist1[curR-1][curC] == Integer.MAX_VALUE) {
				q1.add(new Pair(curR-1, curC));
				dist1[curR-1][curC] = dist1[curR][curC] + 1;
			}
			if (curR+1 < R && graph[curR+1][curC] == '.' && dist1[curR+1][curC] == Integer.MAX_VALUE) {
				q1.add(new Pair(curR+1, curC));
				dist1[curR+1][curC] = dist1[curR][curC] + 1;
			}
			if (curC-1 >= 0 && graph[curR][curC-1] == '.' && dist1[curR][curC-1] == Integer.MAX_VALUE) {
				q1.add(new Pair(curR, curC-1));
				dist1[curR][curC-1] = dist1[curR][curC] + 1;
			}
			if (curC+1 < C && graph[curR][curC+1] == '.' && dist1[curR][curC+1] == Integer.MAX_VALUE) {
				q1.add(new Pair(curR, curC+1));
				dist1[curR][curC+1] = dist1[curR][curC] + 1;
			}
		}
		
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
