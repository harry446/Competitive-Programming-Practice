package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC18J5 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int[] dist = new int[N+1];
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		Queue<Integer> q = new LinkedList<>();
		
		for (int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
			
			int M = readInt();
			for (int j=0; j<M; j++) {
				adj[i].add(readInt());
			}
		}
		
		dist[1] = 1;
		q.add(1);
		
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			if (adj[cur].size() == 0) {
				min = Math.min(min, dist[cur]);
			}
			
			for (int kids : adj[cur]) {
				if (dist[kids] == 0) {
					q.add(kids);
					dist[kids] = dist[cur]+1;
				}
			}
		}
		
		boolean flag = true;
		for (int i=1; i<=N; i++) {
			if (dist[i] == 0) {
				flag = false;
				break;
			}
		}
		
		System.out.println(flag ? "Y" : "N");
		System.out.println(min);
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
