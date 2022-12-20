package second;

import java.io.*;
import java.util.*;

public class CCC16S3 {

	static int N;
	static ArrayList<Integer> adj[];
	static boolean[] visited;
	static int dist[];
	static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		int N = readInt();
		int M = readInt();
		adj = new ArrayList[N+1];
		visited = new boolean[N+1];
		dist = new int[N+1];
		int[] MR = new int[M+1];
		
		for (int i=1; i<=M; i++) {
			MR[i] = readInt();
		}
		
		
	}
	
	public static void bfs (int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = true;
		dist[n] = 0;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int v : adj/*2*/[cur]) {
				if (!visited[v]) {
					visited[v] = true;
					dist[v] = dist[cur]+1;
					q.add(v);
				}
			}
		}
	}

	static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
 
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
 
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
 
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
 
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
 
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
