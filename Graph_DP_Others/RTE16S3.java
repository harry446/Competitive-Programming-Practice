package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RTE16S3 {

	public static class Pair {
		int b, w;
		
		public Pair (int b, int w) {
			this.b = b;
			this.w = w;
		}
	}
	
	static int N, Q;
	static ArrayList<Pair>[] graph;
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		graph = new ArrayList[N];
		
		for (int i=0; i<N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=1; i<N; i++) {
			int a = readInt();
			int b = readInt();
			int c = readInt();
			graph[a].add(new Pair(b, c));
			graph[b].add(new Pair(a, c));
		}
		
		dist = new int[N];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		dist[0] = 1;
		dfs(0, 1);
		
		Q = readInt();
		
	}
	
	public static void dfs (int s, int w) {
		visited[s] = true;
		dist[s] = w;
		ArrayList<Pair> cur = graph[s];
		
		for (Pair kids : cur) {
			if (!visited[kids.b]) {
				//dfs(kids.b);
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
