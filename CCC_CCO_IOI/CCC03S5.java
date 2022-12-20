package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC03S5 {

//	public static class Edge {
//		int ev, w;
//		
//		public Edge (int ev, int w) {
//			this.ev = ev;
//			this.w = w;
//		}
//	}
//	
//	static int C, R, D, min = Integer.MAX_VALUE;
//	static ArrayList<Edge>[] adj;
//	static boolean[] mstSet, visited;
//	static int[] par, value, dest;
	
	
	public static class Edge implements Comparable<Edge> {
		int n1, n2, w;
		
		public Edge (int n1, int n2, int w) {
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
		}
		
		public int compareTo (Edge o) {
			return o.w - w;
		}
	}
	
	static int C, R, D, min = Integer.MAX_VALUE;
	static ArrayList<Edge> edge = new ArrayList<>();
	static int[] par, rank;
	static boolean[] dest;
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		C = readInt();
		R = readInt();
		D = readInt();
		dest = new boolean[C+1];
		int[] val = new int[C+1];
		
		
		
		for (int i=0; i<R; i++) {
			int a = readInt();
			int b = readInt();
			int w = readInt();
			val[a] = Math.max(val[a], w);
			val[b] = Math.max(val[b], w);
		}
		
		for (int i=0; i<D; i++) {
			min = Math.min(val[readInt()], min);
		}
		
		System.out.println(min);
//		par = new int[C+1];
//		rank = new int[C+1];
//		dest = new boolean[C+1];
//		
//		for (int i=0; i<R; i++) {
//			edge.add(new Edge(readInt(), readInt(), readInt()));
//		}
//		
//		for (int i=0; i<D; i++) {
//			dest[readInt()] = true;
//		}
//		dest[1] = true;
//		D++;
//
//		Collections.sort(edge);
//		
//		for (Edge e : edge) {
//			if (union(e.n1, e.n2)) {
//				if (dest[e.n1]) {
//					dest[e.n1] = false;
//					D--;
//				}
//				if (dest[e.n2]) {
//					dest[e.n2] = false;
//					D--;
//				}
//				
//				min = e.w;
//				
//				if (D == 0) {
//					break;
//				}
//			}
//		}
//		
//		System.out.println(min);
		
		
		
		
		
		
//		C = readInt();
//		R = readInt();
//		D = readInt();
//		adj = new ArrayList[C+1];
//		mstSet = new boolean[C+1];
//		par = new int[C+1];
//		value = new int[C+1];
//		dest = new int[D];
//		visited = new boolean[C+1];
//		
//		for (int i=1; i<=C; i++) {
//			adj[i] = new ArrayList<>();
//		}
//		
//		for (int i=0; i<R; i++) {
//			int a = readInt();
//			int b = readInt();
//			int w = readInt();
//			adj[a].add(new Edge(b, w));
//			adj[b].add(new Edge(a, w));
//		}
//		
//		for (int i=0; i<D; i++) {
//			dest[i] = readInt();
//		}
//		
//		value[1] = Integer.MAX_VALUE;
//		
//		while (true) {
//			int index = maxValue();
//			if (index == -1) {
//				break;
//			}
//			
//			mstSet[index] = true;
//			ArrayList<Edge> cur = adj[index];
//			for (Edge kids : cur) {
//				int v = kids.ev;
//				int w = kids.w;
//				if (!mstSet[v] && w>value[v]) {
//					par[v] = index;
//					value[v] = w;
//				}
//			}
//		}
//		
//		visited[0] = true;
//		for (int i=0; i<D; i++) {
//			int cur = dest[i];
//			while (!visited[cur]) {
//				min = Math.min(min, value[cur]);
//				visited[cur] = true;
//				cur = par[cur];
//			}
//		}
//		
//		System.out.println(min);
		
	}

	public static int find (int n) {
		if (par[n] == 0) {
			return n;
		}
		return par[n] = find(par[n]);
	}
	
	public static boolean union (int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			if (rank[a] > rank[b]) {
				par[b] = a;
			}
			else {
				if (rank[a] == rank[b]) {
					rank[b]++;
				}
				par[a] = b;
			}
			return true;
		}
		return false;
	}
	
//	public static int maxValue() {
//		int max = -1, index = -1;
//		
//		for (int i=1; i<=C; i++) {
//			if (!mstSet[i] && max < value[i]) {
//				index = i;
//				max = value[i];
//			}
//		}
//		return index;
//	}
	
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
