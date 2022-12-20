package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DMOPC17Contest2P3 {

	static ArrayList<Integer>[] adj;
	static int[] dist;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE, X, Y;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int R = readInt();
		adj = new ArrayList[N+1];
		dist = new int[N+1];
		visited = new boolean[N+1];
		
		for (int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i=1; i<N; i++) {
			int a = readInt();
			int b = readInt();
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i=0; i<R; i++) {
			int a = readInt();
			q.add(a);
			dist[a] = 1;
		}
		
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int kids : adj[cur]) {
				if (dist[kids] == 0) {
					q.add(kids);
					dist[kids] = dist[cur] + 1;
				}
			}
		}
		
		X = readInt();
		Y = readInt();
		
		min = Math.min(min, dist[X]);
		dfs(X);
		
		System.out.println(min-1);
	}

	public static boolean dfs (int s) {
		
		visited[s] = true;
		
		if (s == Y) {
			return true;
		}
		
		ArrayList<Integer> cur = adj[s];
		
		for (int kids : cur) {
			if (!visited[kids]) {
				if (dfs(kids)) {
					min = Math.min(min, dist[kids]);
					return true;
				}
			}
		}
		
		return false;
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
