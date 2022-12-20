package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BobHatesTriangles {

	static class Pair {
		int f, s;
		
		public Pair (int f, int s) {
			this.f = f;
			this.s = s;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int M = readInt();
		ArrayList<Pair>[] adj = new ArrayList[N+1];
		boolean[] visitedN = new boolean[N+1];
		boolean[] visitedE = new boolean[M];
		
		for (int i=0; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			int a = readInt();
			int b = readInt();
			adj[a].add(new Pair(b, i));
			adj[b].add(new Pair(a, i));
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i=1; i<=N; i++) {
			if (visitedN[i]) {
				continue;
			}
			
			visitedN[i] = true;
			q.add(i);
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (Pair kids : adj[cur]) {
					if (visitedE[kids.s]) {
						continue;
					}
					visitedE[kids.s] = true;
					
					if (!visitedN[kids.f]) {
						q.add(kids.f);
						visitedN[kids.f] = true;
						
					}
				
					System.out.println(cur + " " + kids.f);
				}
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
	static char readCharacter () {
		return read().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}

	
}
