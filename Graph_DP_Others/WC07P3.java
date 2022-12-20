package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WC07P3 {

	static class Pair {
		int f, s;
		
		public Pair (int f, int s) {
			this.f = f;
			this.s = s;
		}
	}
	
	static int N, ans;
	static int[][] dp;
	static boolean[][] adj, visited;
	static Queue<Pair> q = new LinkedList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int T = readInt();
		
		while (T-- > 0) {
			N = readInt();
			adj = new boolean[N][N];
			dp = new int[N][1<<N];
			visited = new boolean[N][1<<N];
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (readInt() == 1) {
						adj[i][j] = true;
					}
				}
			}
			
			q.add(new Pair(0, 1));
			dp[0][1] = 1;
			visited[0][1] = true;
			
			ans = 0;
			
			while (!q.isEmpty()) {
				Pair cur = q.poll();
				int u = cur.f;
				int mask = cur.s;
				
				if (u == N-1) {
					ans += dp[u][mask];
				}
				
				for (int i=0; i<N; i++) {
					if (adj[u][i]) {
						if ((mask & (1<<i)) == 0) {		//!visited
							dp[i][mask | (1<<i)] += dp[u][mask];
							if (!visited[i][mask | (1<<i)]) {
								visited[i][mask | (1<<i)] = true;
								q.add(new Pair(i, mask | (1<<i)));
							}
						}
					}
				}
			}
			
			System.out.println(ans);
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
