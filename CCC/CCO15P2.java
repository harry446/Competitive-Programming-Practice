package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCO15P2 {

	static class Pair {
		int f, s;
		
		public Pair (int f, int s) {
			this.f = f;
			this.s = s;
		}
	}
	
	static int N, M;
	static ArrayList<Pair>[] adj;
	static int[][] dp;	//dp[u][mask] = longest route ending in u with all nodes set in mask visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		M = readInt();
		adj = new ArrayList[N+1];
		dp = new int[N][1<<N];
		
		for (int i=0; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			adj[readInt()].add(new Pair(readInt(), readInt()));
		}
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 1)); 
		dp[0][1] = 0;
		int ans = 0;
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int u = cur.f;
			int mask = cur.s;
			
			if (u == N-1) {
				ans = Math.max(ans, dp[u][mask]);
				continue;
			}
			
			for (Pair e : adj[u]) {
				int v = e.f;
				int w = e.s;
				
				if ((mask & (1<<v)) == 0) {
					if (dp[v][mask | (1<<v)] < dp[u][mask] + w) {
						dp[v][mask | (1<<v)] = dp[u][mask] + w;
						q.add(new Pair(v, mask | (1<<v)));
					}
				}
			}
			
		}
		
		System.out.println(ans);
		
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
