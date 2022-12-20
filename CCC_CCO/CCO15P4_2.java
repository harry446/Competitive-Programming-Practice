package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCO15P4_2 {

	static int N, M;
	static char[][] graph;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		M = readInt();
		graph = new char[N][M];
		visited = new boolean[N][M];
		
		for (int i=0; i<N; i++) {
			graph[i] = read().toCharArray();
		}
		
		for (int row=0; row<N; row++) {
			for (int col=0; col<M; col++) {
				if (!visited[row][col] && graph[row][col] != '.') {
					dfs(row*10000+col);
				}
			}
		}
		
	}
	
	public static void dfs (int n) {
		int r = n/10000;
		int c = n%10000;
		
//		System.out.println("r: " + r + ", c:" + c);
		
		visited[r][c] = true;
		
		if (graph[r][c] == 'N') {
			for (int i=r-1; i>=0; i--) {
				if (!visited[i][c] && graph[i][c] != '.') {
					dfs(i*10000+c);
				}
			}
		}
		else if (graph[r][c] == 'S') {
			for (int i=r+1; i<N; i++) {
				if (!visited[i][c] && graph[i][c] != '.') {
					dfs(i*10000+c);
				}
			}
		}
		else if (graph[r][c] == 'W') {
			for (int i=c-1; i>=0; i--) {
				if (!visited[r][i] && graph[r][i] != '.') {
					dfs(r*10000+i);
				}
			}
		}
		else if (graph[r][c] == 'E') {
			for (int i=c+1; i<M; i++) {
				if (!visited[r][i] && graph[r][i] != '.') {
					dfs(r*10000+i);
				}
			}
		}
		
		System.out.printf("(%d,%d)%n", r, c);
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
