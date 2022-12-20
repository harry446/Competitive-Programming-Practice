package second;

import java.io.*;
import java.util.*;

public class VM7WC156Gold {

	static LinkedList<Integer>[] graph;
	static int[] values;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		graph = new LinkedList[N+1];
		values = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for (int i=1; i<N; i++) {
			graph[readInt()].add(readInt());
		}
		for (int i=1; i<=N; i++) {
			values[i] = readInt();
		}
		
		dfs(1);
		System.out.println(max);
		
	}

	public static int dfs (int s) {

		for (int kids : graph[s]) {
			values[s] += dfs(kids);
		}
		
		max = Math.max(max, values[s]);
		return values[s];
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
