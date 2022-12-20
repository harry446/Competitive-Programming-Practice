package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DMOPC13Contest3P3 {

	static int N, H;
	static int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static int[][] graph;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		H = readInt();
		graph = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				graph[i][j] = readInt();
			}
		}
		
		dfs(1, 1);
		
		System.out.println(visited[N][N] ? "yes" : "no");
	}

	public static void dfs (int r, int c) {
		visited[r][c] = true;
		
		for (int i=0; i<4; i++) {
			int newR = r+moves[i][0];
			int newC = c+moves[i][1];
			
			if (newR > 0 && newR <= N && newC > 0 && newC <= N && !visited[newR][newC] && Math.abs(graph[r][c] - graph[newR][newC]) <= H) {
				dfs(newR, newC);
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
