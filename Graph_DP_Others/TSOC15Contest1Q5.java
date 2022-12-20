package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TSOC15Contest1Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int M = readInt();
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		int[] dist1 = new int[N+1];
		int[] dist2 = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			int a = readInt();
			int b = readInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		
		int W = readInt();
		Queue<Integer> q = new LinkedList<>();
		
		for (int i=0; i<W; i++) {
			int a = readInt();
			q.add(a);
			dist1[a] = 1;
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int kids : adj[cur]) {
				if (dist1[kids] == 0) {
					q.add(kids);
					dist1[kids] = dist1[cur]+1;
				}
			}
		}
		
		
		q.add(1);
		dist2[1] = 1;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			int curD = dist2[cur] + 1;
			for (int kids : adj[cur]) {
				if (dist2[kids] == 0 && curD-1 < 4*(dist1[kids]-1)) {
					q.add(kids);
					dist2[kids] = curD;
				}
			}
		}
		
		if (dist2[N] == 0) {
			System.out.println("sacrifice bobhob314");
		}
		else {
			System.out.println(dist2[N]-1);
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
