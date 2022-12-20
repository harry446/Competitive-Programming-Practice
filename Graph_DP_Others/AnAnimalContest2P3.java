package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AnAnimalContest2P3 {

	public static class Pair {
		int r, c;
		
		public Pair (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static Queue<Pair> q = new LinkedList<>();
	static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		M = readInt();
		graph = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		for (int i=1; i<=N; i++) {
			String S = read();
			for (int j=1; j<=M; j++) {
				graph[i][j] = graph[i-1][j] + graph[i][j-1] - graph[i-1][j-1];
				if (S.charAt(j-1) == 'X') {
					graph[i][j]++;
				}
			}
		}
		
//		for (int i=0; i<=N; i++) {
//			for (int j=0; j<=M; j++) {
//				System.out.printf("%2d ", graph[i][j]);
//			}
//			System.out.println();
//		}
		
//		System.out.println(graph[2+2-1][2+2-1]);
//		System.out.println(graph[2-1][2]);
//		System.out.println(graph[2][2-1]);
//		System.out.println(graph[2-1][2-1]);
//		System.out.println(graph[2+2-1][2+2-1] - graph[2-1][2+2-1] - graph[2+2-1][2-1] + graph[2-1][2-1]);
		
		int high = Math.min(N, M);
		int low = 1;
		int mid;
		while (low <= high) {
			mid = (high+low)/2;
			bfs(mid);		
			
			if (visited[N-mid+1][M-mid+1]) {
				if (mid == Math.min(N, M) && graph[mid][mid] != 0) {
					continue;
				}
				low = high;
			}
			
			for (int j=1; j<=N; j++) {
				Arrays.fill(visited[j], false);
			}
		}
		
		
	}
	
	public static void bfs (int k) {
		q.add(new Pair(1, 1));
		visited[1][1] = true;
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			
			for (int i=0; i<4; i++) {
				int newR = cur.r + moves[i][0];
				int newC = cur.c + moves[i][1];
				if (newR+k-1 > N || newC+k-1 > M || newR <=0 || newC <=0 || newR-1 > N || newC-1 > M) {
					continue;
				}
				
				if (!visited[newR][newC] && graph[newR+k-1][newC+k-1] - graph[newR-1][newC+k-1] - graph[newR+k-1][newC-1] + graph[newR-1][newC-1] == 0) {	//left
					visited[newR][newC] = true;
					q.add(new Pair(newR, newC));
				}
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
	static char readCharacter() {
		return read().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
	
}
