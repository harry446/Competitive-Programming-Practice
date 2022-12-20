package second;

import java.io.*;
import java.util.*;

public class CCC11J5 {
	
	static int N;
	static boolean[] visited;
	static Set<String> set = new HashSet<>();
	static Map<Integer, LinkedList<Integer>> graph = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		visited = new boolean[N+1];
		
		
		for (int i=1; i<N; i++) {
			int friend = readInt();
			
			if (!graph.containsKey(i)) {
				graph.put(i, new LinkedList<>());
			}
			if (!graph.containsKey(friend)) {
				graph.put(friend, new LinkedList<>());
			}
			graph.get(i).add(friend);
			graph.get(friend).add(i);
		}
		
		
		remove(0);
		
		System.out.println(set.size()+1);

		
	}
	
	public static void remove (int count) {
		
		if (count == 3) {
			return;
		}
		
		
		for (int j=count+1; j<N; j++) {
			String S = "";
			LinkedList<Integer> temp = graph.get(j);
			graph.remove(j);
			
			Arrays.fill(visited, false);
			dfs(N);
			
			for (int i=1; i<=N; i++) {
				if (visited[i]) {
					S += "1";
				}
				else {
					S += "0";
				}
			}
			
			set.add(S);
			
			remove(count+1);
			
			graph.put(j, temp);
		}
		return;
	}
	
	public static void dfs (int s) {
		
		LinkedList<Integer> cur = graph.get(s);
		
		if (cur == null) {
			return;
		}
		
		visited[s] = true;
		
		for (int kid : cur) {
			if (!visited[kid]) {
				dfs(kid);
			}
		}
		
		return;
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
