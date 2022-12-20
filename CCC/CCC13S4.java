package second;

import java.io.*;
import java.util.*;

public class CCC13S4 {

	static int N, M;
	static ArrayList<Integer>[] graph;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		M = readInt();
		graph = new ArrayList[N+1];
		
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			graph[readInt()].add(readInt());
		}
		
		int p = readInt();
		int q = readInt();
		
		if (bfs(p, q)) {
			System.out.println("yes");
			return;
		}
		
		if (bfs(q, p)) {
			System.out.println("no");
			return;
		}
		
		System.out.println("unknown");
		
	}
	
	public static boolean bfs (int p, int q) {
		
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		visited[p] = true;
		queue.add(p);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int kids : graph[cur]) {
				if (!visited[kids]) {
					if (kids == q) {
						return true;
					}
					queue.add(kids);
					visited[kids] = true;
				}
			}
		}
		
		return false;
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
