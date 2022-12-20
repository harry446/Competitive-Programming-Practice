package second;

import java.io.*;
import java.util.*;

public class CPC21Contest1P4 {

	static int N, M;
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		M = readInt();
		graph = new LinkedList[N+1];
		visited = new boolean[N+1];
		
		for (int i=1; i<=N; i++) {
			graph[i] = new LinkedList<>();
		}

		for (int i=0; i<M; i++) {
			graph[readInt()].add(readInt());
		}
		
		int temp = -1;
		for (int i=N-1; i>=1; i--) {
			boolean flag = false;
			for (int j=i; j<=temp; j++) {
				if (visited[j]) {
					flag = true;
				}
			}
			
			if (!flag && temp != -1) {
				continue;
			}
			
			Arrays.fill(visited, false);
			dfs(i);
			temp = i;
			for (int j=N; j>i; j--) {
				if (visited[j]) {
					System.out.println(i + " " + j);
					return;
				}
			}
		}
		
		System.out.println(-1);
		
	}
	
	public static void dfs (int s) {
		visited[s] = true;
		
		LinkedList<Integer> cur = graph[s];
		if (cur == null) {
			return;
		}
		
		for (int kids : cur) {
			if (!visited[kids]) {
				dfs(kids);
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
}
