package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC17S4 {

	public static class Edge implements Comparable<Edge> {
		int n1, n2, w;
		boolean o;
		
		public Edge (int n1, int n2, int w, boolean o) {
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
			this.o = o;
		}
		
		public int compareTo (Edge o) {
			if (w != o.w) {
				return w - o.w;
			}
			
			if (this.o && !o.o) {
				return -1;
			}
			return 0;
		}
	}
	
	static int N, M, D, max = 0, days = 0, count = 0, index = 0;
	static ArrayList<Edge> edge = new ArrayList<>();
	static int[] par, rank;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		M = readInt();
		D = readInt();
		par = new int[N+1];
		rank = new int[N+1];
		
		for (int i=1; i<=M; i++) {
			if (i<N) {
				edge.add(new Edge(readInt(), readInt(), readInt(), true));
			}
			else {
				edge.add(new Edge(readInt(), readInt(), readInt(), false));
			}
		}
		
		Collections.sort(edge);
		
		for (Edge e : edge) {
			if (union(e.n1, e.n2)) {
				count++;
				max = e.w;
				if (!e.o) {
					days++;
				}
				
				if (count == N-1) {
					break;
				}
			}
			index++;
		}
		
		if (!edge.get(index).o) {
			Arrays.fill(par, 0);
			Arrays.fill(rank, 0);
			
			for (Edge e : edge) {
				if (find(e.n1) != find(e.n2)) {
					if (e.w < max || (e.w==max && e.o)) {
						union(e.n1, e.n2);
					}
					else if (e.o && e.w<=D) {
						System.out.println(days-1);
						return;
					}
				}
			}
		}
		
		System.out.println(days);
		
		
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
			if (rank[a] < rank[b]) {
				par[a] = b; 
			}
			else {
				if (rank[a] == rank[b]) {
					rank[b]++;
				}
				par[b] = a;
			}
			return true;
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
	static char readCharacter() {
		return read().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
	
}
