package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DoubleDoorsRegionalP3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int M = readInt();
		int[] dist = new int[N+1];
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			int a = readInt();
			int b = readInt();
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		int S = readInt();
		int T = readInt();
		
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		dist[S] = 1;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int kids : graph[cur]) {
				if (dist[kids] == 0) {
					q.add(kids);
					dist[kids] = dist[cur]+1;
				}
			}
		}
		
		System.out.println(M-dist[T]+1);
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
