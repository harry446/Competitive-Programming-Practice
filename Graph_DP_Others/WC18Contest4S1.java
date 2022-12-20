package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WC18Contest4S1 {

	static String R;
	static int[] par;
	static int[] rank;
//	static ArrayList<Integer>[] adj;
//	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int M = readInt();
		int K = readInt();
		par = new int[N+1];
		rank = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			par[i] = i;
			rank[i] = 1;
		}
		
		R = read();
		
		for (int i=0; i<M; i++) {
			int a = readInt();
			int b = readInt();
			
			if (R.charAt(a-1) == R.charAt(b-1)) {
				int c = find(a);
				int d = find(b);
				if (c != d) {
					if (rank[c] < rank[d]) {
						par[c] = d;
					}
					else {
						if (rank[c] == rank[d]) {
							rank[c]++;
						}
						par[d] = c;
					}
				}
			}
		}
		
		int count = 0;
		for (int i=0; i<K; i++) {
			int a = readInt();
			int b = readInt();
			
			if (find(a) == find(b)) {
				count++;
			}
		}
		
		System.out.println(count);
		
//		adj = new ArrayList[N+1];
//		visited = new boolean[N+1];
//		
//		for (int i=1; i<=N; i++) {
//			adj[i] = new ArrayList<>();
//		}
//		
//		R = read();
//		
//		for (int i=0; i<M; i++) {
//			int a = readInt();
//			int b = readInt();
//			if (R.charAt(a-1) == R.charAt(b-1)) {
//				adj[a].add(b);
//				adj[b].add(a);
//			}
//		}
//		
//		
//		int count = 0;
//		for (int i=0; i<K; i++) {
//			int a = readInt();
//			int b = readInt();
//			
//			if (R.charAt(a-1) != R.charAt(b-1)) {
//				continue;
//			}
//			
//			if (!visited[a] && !visited[b]) {
//				dfs(a);
//			}
//			
//			if (visited[a] && visited[b]) {
//				count++;
//			}
//		}
//		
//		System.out.println(count);
		
		
		
	}

	public static int find (int n) {
		if (par[n] == n) {
			return n;
		}
		return par[n] = find(par[n]);
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
