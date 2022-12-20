package second;

import java.io.*;
import java.util.*;

public class CCC07S4 {

	static int N;
	static ArrayList<Integer>[] graph;
	static Map<Integer, Integer> map = new HashMap<>();
	
	static Map<Integer, LinkedList<Integer>> graph2 = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		graph = new ArrayList[N+1];
		
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		while (true) {
			int x = readInt();
			int y = readInt();
			
			if (x == 0 && y == 0) {
				break;
			}
			graph[x].add(y);
			
		}
		
		System.out.println(dfs(1));
		

	}

	public static int dfs (int n) {
		
		if (n == N) {
			return 1;
		}
		
		if (map.containsKey(n)) {
			return map.get(n);
		}
		
		int total = 0;
		
		ArrayList<Integer> cur = graph[n];
		
		for (int kids : cur) {
			int curPoint = dfs(kids);
			total += curPoint;
			
			map.put(kids, curPoint);
		}
		
		return total;
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
