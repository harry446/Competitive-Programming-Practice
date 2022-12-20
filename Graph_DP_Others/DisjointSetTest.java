package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DisjointSetTest {
	
	static int[] par, rank, ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int M = readInt();
		par = new int[N+1];
		rank = new int[N+1];
		ans = new int[N-1];
		
		int count = 0;
		for (int i=1; i<=M; i++) {
			if (union(readInt(), readInt())) {
				ans[count++] = i;
			}
		}
		
		if (count == N-1) {
			for (int a : ans) {
				System.out.println(a);
			}
		}
		else {
			System.out.println("Disconnected Graph");
		}
		
	}

	
	public static int find (int s) {
		if (par[s] == 0) {
			return s;
		}
		return par[s] = find(par[s]);
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
