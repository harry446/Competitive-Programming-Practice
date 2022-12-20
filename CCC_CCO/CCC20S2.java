package second;

import java.io.*;
import java.util.*;

public class CCC20S2 {
	
	static class Pair {
		int r, c;
		
		public Pair (int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}

	static int[][] graph;
	static boolean[][] visited;
	static ArrayList<Pair>[] adj;
	static int M, N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		M = readInt();
		N = readInt();
		graph = new int[M+1][N+1];
		visited = new boolean[M+1][N+1];
		adj = new ArrayList[M*N+1];
		
		
		for (int i=1; i<adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int row=1; row<=M; row++) {
			for (int col=1; col<=N; col++) {
				graph[row][col] = readInt();
				adj[row*col].add(new Pair(row, col));
			}
		}
		
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(1, 1));
		visited[1][1] = true;
		
		while (!queue.isEmpty()) {
			Pair position = queue.poll();
			
			if (position.r == M && position.c == N) {
				System.out.println("yes");
				return;
			}
			
			ArrayList<Pair> cur = adj[graph[position.r][position.c]];
			
			for (Pair kids : cur) {
				if (!visited[kids.r][kids.c]) {
					visited[kids.r][kids.c] = true;
					queue.add(kids);
				}
			}
			
//			if (graph.get(position) == null) {
//				System.out.println(position);
//				continue;
//			}
//			
//			for (Pair kids : graph.get(position)) {
//				if (!visited[kids.r][kids.c]) {
//					visited[kids.r][kids.c] = true;
//					String kid = Integer.toString(kids.r) + "," + Integer.toString(kids.c);
//					queue.add(kid);
//				}
//			}
			
		}
		
		System.out.println("no");
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
