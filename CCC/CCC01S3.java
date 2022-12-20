package second;

import java.io.*;
import java.util.*;

public class CCC01S3 {

	static Set<String> answer = new HashSet<>();
	static Set<String> edges = new HashSet<>();
	static Map<String, LinkedList<String>> graph = new HashMap<>();
	static boolean[] visited = new boolean[26];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String S = read();
		
		while (!S.equals("**")) {
			String S1 = S.charAt(0) + "";
			String S2 = S.charAt(1) + "";
			edges.add(S);
			
			if (!graph.containsKey(S1)) {
				graph.put(S1, new LinkedList<>());
			}
			if (!graph.containsKey(S2)) {
				graph.put(S2, new LinkedList<>());
			}
			
			graph.get(S1).add(S2);
			graph.get(S2).add(S1);
			
			S = read();
		}
		
		
		for (String removes : edges) {
			String S1 = removes.charAt(0) + "";
			String S2 = removes.charAt(1) + "";
			
			dfs(S1, S2, "A");
			if (!visited[1]) {
				answer.add(removes);
			}
			Arrays.fill(visited, false);
		}
		
		
		for (String answers : answer) {
			System.out.println(answers);
		}
		
		int count = answer.size();
		System.out.println("There are " + count + " disconnecting roads.");
		
	}
	
	
	public static void dfs (String S1, String S2, String s) {
		int indexValue = (int)s.charAt(0) - 65;
		visited[indexValue] = true;
		LinkedList<String> cur = graph.get(s);
		
		if (cur == null) {
			return;
		}
		
		for (String kid : cur) {
			if ((s.equals(S1) && kid.equals(S2)) || (s.equals(S2) && kid.equals(S1))) {
				continue;
			}

			if (!visited[(int)kid.charAt(0) - 65]) {
				dfs(S1, S2, kid);
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
