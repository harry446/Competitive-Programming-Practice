package second;

import java.io.*;
import java.util.*;

public class CCC07S3 {

	static Map<Integer, Integer> graph = new HashMap<>();
	static Map<Integer, Integer> visited = new HashMap<>();
	static int count;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		
		for (int i=0; i<N; i++) {
			int x = readInt();
			int y = readInt();
			
			graph.put(x, y);
			visited.put(x, -1);
			visited.put(y, -1);
		}
		
		while (true) {
			int x = readInt();
			int y = readInt();
			
			if (x == 0 && y == 0) {
				break;
			}
			
			count = -2;
			dfs(x, x, y);
			
			if (visited.get(y) == -1) {
				System.out.println("No");
			}
			else {
				System.out.println("Yes " + count);
			}
			
			for (int keys : visited.keySet()) {
				visited.put(keys, -1);
			}
			
		}
	}
	
	public static void dfs (int n, int s, int f) {
		count++;
		visited.put(n, 1);
		
		if (n == f) {
			return;
		}
		int kid = graph.get(n);
		
		if (kid == s) {
			dfs(kid, s, f);
		}
		
		if (visited.get(kid) == -1) {
			dfs(kid, s, f);
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
	
}
