package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MWC15C4P4 {

	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		adj = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for (int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i=0; i<N; i++) {
			adj[readInt()].add(readInt());
		}
		
		dfs(readInt());
		
		if (visited[readInt()]) {
			System.out.println("Tangled");
		}
		else {
			System.out.println("Not Tangled");
		}
	}
	
	public static void dfs (int s) {
		visited[s] = true;
		ArrayList<Integer> cur = adj[s];
		
		for (int kids : cur) {
			if (!visited[kids]) {
				dfs(kids);
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
