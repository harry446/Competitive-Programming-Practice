package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCO95P5 {

	static ArrayList<Integer>[] adj;
//	static boolean[] visited;
	static int[] par;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int m = readInt();
		int n = readInt();
		adj = new ArrayList[26];
//		visited = new boolean[26];
		par = new int[26];
		
		for (int i=0; i<26; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i=0; i<m; i++) {
			int u = read().charAt(0) - 'A';
			int v = read().charAt(0) - 'A';
			adj[u].add(v);
			adj[v].add(u);
		}
		
		for (int i=0; i<n; i++) {
			int u = read().charAt(0) - 'A';
			int v = read().charAt(0) - 'A';
			System.out.println(BFS(u, v));
		}
	}
	
	public static String BFS (int u, int v) {
		Queue<Integer> q = new LinkedList<>();
//		Arrays.fill(visited, false);
		Arrays.fill(par, -2);
		
		q.add(u);
		par[u] = -1;
//		visited[u] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int k : adj[cur]) {
				if (par[k] == -2) {
					par[k] = cur;
					if (k == v) {
						break;
					}
					q.add(k);
				}
//				if (!visited[k]) {
//					visited[k] = true;
//					par[k] = cur;
//					q.add(k);
//				}
			}
		}
		
		String ans = "";
		for (int i=v; i>=0; i=par[i]) {
			ans = (char)(i + 'A') + ans;
		}
		return ans;
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
