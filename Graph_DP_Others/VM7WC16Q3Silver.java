package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class VM7WC16Q3Silver {

//	static ArrayList<Integer>[] adj;
//	static boolean[] visited;
	static int[] par, rank;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int M = readInt();
		int A = readInt();
		int B = readInt();
		
//		adj = new ArrayList[N+1];
//		visited = new boolean[N+1];
		
		par = new int[N+1];
		rank = new int[N+1];
		
		for (int i=1; i<=N; i++) {
//			adj[i] = new ArrayList<>();
			par[i] = i;
		}
		
		for (int i=0; i<M; i++) {
//			int a = readInt();
//			int b = readInt();
			
			union(readInt(), readInt());
//			adj[a].add(b);
//			adj[b].add(a);
		}
		
		System.out.println(find(A) == find(B) ? "GO SHAHIR!" : "NO SHAHIR!");
//		dfs(A);
//		
//		System.out.println(visited[B] ? "GO SHAHIR!" : "NO SHAHIR!");
	}
	
	public static int find (int s) {
		if (par[s] == s) {
			return s;
		}
		return par[s] = find(par[s]);
	}
	
	public static void union (int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if (a != b) {
			if (rank[a] < rank[b]) {
				par[a] = b;
			}
			else {
				if (rank[a] == rank[b]) {
					rank[a]++;
				}
				par[b] = a;
			}
		}
		
	}
	
//	public static void dfs (int s) {
//		visited[s] = true;
//		ArrayList<Integer> cur = adj[s];
//		
//		for (int kids : cur) {
//			if (!visited[kids]) {
//				dfs(kids);
//			}
//		}
//	}
	

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
