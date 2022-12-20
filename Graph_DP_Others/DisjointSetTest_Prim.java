package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DisjointSetTest_Prim {

	static class Edge implements Comparable<Edge> {
		int n, w;
		
		public Edge (int n, int w) {
			this.n = n;
			this.w = w;
		}
		
		public int compareTo (Edge o) {
			return w - o.w;
		}
	}
	
	static int[] value, ans;
	static boolean[] mstSet;
	static ArrayList<Edge>[] adj;
	static PriorityQueue<Edge> q = new PriorityQueue<>();
//	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int M = readInt();
		value = new int[N+1];
		ans = new int[N+1];
		mstSet = new boolean[N+1];
		adj = new ArrayList[N+1];
		
		for (int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		Arrays.fill(value, Integer.MAX_VALUE);
		
		for (int i=1; i<=M; i++) {
			int a = readInt();
			int b = readInt();
			adj[a].add(new Edge(b, i));
			adj[b].add(new Edge(a, i));
		}
		
		value[1] = 0;
		q.add(new Edge(1, 0));
		
		while (!q.isEmpty()) {
			Edge cur = q.poll();
			
			if (mstSet[cur.n]) {
				continue;
			}
			
			mstSet[cur.n] = true;
			
			for (Edge e : adj[cur.n]) {
//				System.out.println("cur: " + cur.n + "," + cur.w + "; e: " + e.n + "," + e.w);
				if (!mstSet[e.n]) {
//					System.out.println("yes");
					if (value[e.n] > e.w) {
//						System.out.println("YES");
						value[e.n] = e.w;
						q.add(e);
						ans[e.n] = e.w;
					}
//					ans.add(cur.w);
				}
			}
//			System.out.println("-------------");
			
		}
		
//		System.out.println(ans.size() + " " + (N-1));
		
		
		for (int i=1; i<=N; i++) {
			if (!mstSet[i]) {
				System.out.println("Disconnected Graph");
				return;
			}
		}
		
		for (int i=2; i<=N; i++) {
			System.out.println(ans[i]);
		}
//		if (ans.size() == N-1) {
//			for (int i : ans) {
//				System.out.println(i);
//			}
//		}
//		else {
//			System.out.println("Disconnected Graph");
//		}
		
		
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
