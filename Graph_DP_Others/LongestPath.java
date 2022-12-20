package second;

import java.io.*;
import java.util.*;

public class LongestPath {

	static int N, M;
	static ArrayList<Integer>[] graph;
	static int[] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		M = readInt();
		graph = new ArrayList[N+1];
		dp = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		Arrays.fill(dp, -1);
		
		for (int i=0; i<M; i++) {
			graph[readInt()].add(readInt());
		}
		
		int max = -1;
		for (int i=1; i<=N; i++) {
			if(dp[i] != -1) {
				max = Math.max(max, dp[i]);
				continue;
			}
			max = Math.max(max, dfs(i));
		}
		
		System.out.println(max);
	}
	
	public static int dfs (int s) {
		
		if (dp[s] != -1) {
			return dp[s];
		}

		ArrayList<Integer> cur = graph[s];
		
		int max = 0;
		for (int kids : cur) {
			max = Math.max(max, dfs(kids)+1);
		}
		
		return dp[s] = max;
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
	static char readCharacter () {
		return read().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
