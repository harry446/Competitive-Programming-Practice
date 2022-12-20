package second;

import java.io.*;
import java.util.*;

public class CCC03S3 {

	public static class Pair {
		int r, c;
		
		public Pair (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int R, C;
	static char[][] graph;
	static int[][] par;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int w = readInt();
		R = readInt();
		C = readInt();
		graph = new char[R][C];
		par = new int[R][C];
		
		for (int i=0; i<R; i++) {
			graph[i] = read().toCharArray();
			Arrays.fill(par[i], -1);
		}
		
//		for (int row=0; row<R; row++) {
//			for (int col=0; col<C; col++) {
//				System.out.print(graph[row][col] + " ");
//			}
//			System.out.println();
//		}
		
		int count = 1;
		for (int row=0; row<R; row++) {
			for (int col=0; col<C; col++) {
				if (graph[row][col] == 'I') {
					continue;
				}
				
				par[row][col] = bfs(row, col);
				
				if (par[row][col] == -1) {
					par[row][col] = count;
					count++;
				}
				
//				if (par[Math.max(row-1, 0)][col] == -1 && par[row][Math.max(col-1, 0)] == -1) {
//					par[row][col] = count;
//					count++;
//					continue;
//				}
				
//				if (row>=1) {
//					if (par[row-1][col] != -1) {
//						par[row][col] = par[row-1][col];
//					}
//				}
//				if (col>=1) {
//					if (par[row][col-1] != -1) {
//						par[row][col] = par[row][col-1];
//					}
//				}
			}
		}
		
//		for (int row=0; row<R; row++) {
//			for (int col=0; col<C; col++) {
//				System.out.printf("%3d ", par[row][col]);
//			}
//			System.out.println();
//		}
//		
		int[] area = new int[count];
		for (int row=0; row<R; row++) {
			for (int col=0; col<C; col++) {
				if (par[row][col] == -1) {
					continue;
				}
				area[par[row][col]]++;
			}
		}
		
		Arrays.sort(area);
		
//		for (int i=1; i<count; i++) {
//			System.out.println(area[i]);
//		}
		
		int room = 0;
		for (int i=count-1; i>=1; i--) {
			if (w < area[i]) {
				break;
			}
			room++;
			w -= area[i];
			
		}
		
		System.out.print(room + " room");
		if (room != 1) {
			System.out.print("s");
		}
		System.out.println(", " + w + " square metre(s) left over");
		
	}
	
	public static int bfs (int br, int bc) {
		boolean[][] visited = new boolean[R][C];
		visited[br][bc] = true;
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(br, bc));
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			
			if (par[r][c] != -1) {
				return par[r][c];
			}
			
			if (graph[Math.max(r-1, 0)][c] == '.' && !visited[Math.max(r-1, 0)][c]) {
//				if (par[r-1][c] != -1) {
//					return par[r-1][c];
//				}
				visited[r-1][c] = true;
				q.add(new Pair(r-1, c));
			}
			if (graph[Math.min(r+1, R-1)][c] == '.' && !visited[Math.min(r+1, R-1)][c]) {
//				if (par[r+1][c] != -1) {
//					return par[r+1][c];
//				}
				visited[r+1][c] = true;
				q.add(new Pair(r+1, c));
			}
			if (graph[r][Math.max(c-1, 0)] == '.' && !visited[r][Math.max(c-1, 0)]) {
//				if (par[r][c-1] != -1) {
//					return par[r][c-1];
//				}
				visited[r][c-1] = true;
				q.add(new Pair(r, c-1));
			}
			if (graph[r][Math.min(c+1, C-1)] == '.' && !visited[r][Math.min(c+1, C-1)]) {
//				if (par[r][c+1] != -1) {
//					return par[r][c+1];
//				}
				visited[r][c+1] = true;
				q.add(new Pair(r, c+1));
			}
		}
		
		return -1;
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
}
