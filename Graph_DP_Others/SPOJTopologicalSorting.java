package second;

import java.io.*;
import java.util.*;

public class SPOJTopologicalSorting {

	static ArrayList<Integer>[] adj;
	static ArrayList<Integer> T = new ArrayList<>();	//Store the answers
	static int[] inDegree;
	static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(new OutputStreamWriter(System.out));

		int n = readInt();
		int m = readInt();
		adj = new ArrayList[n+1];
		inDegree = new int[n+1];
		
		for (int i=1; i<n+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i=0; i<m; i++) {
			int x = readInt();
			int y = readInt();
			if (x == 0 && y == 0) {
				continue;
			}
			adj[x].add(y);
		}
		
		if (topologicalSort(n)) {
			for (int kid : T) {
				System.out.print(kid + " ");
			}
		}
		else {
			System.out.println("Sandro fails.");
		}
		
	}

	public static boolean topologicalSort (int N) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		//setting the initial inDegrees
		for (int i=1; i<=N; i++) {
			for (int v : adj[i]) {
				inDegree[v]++;
			}
		}
		
		for (int i=1; i<=N; i++) {			//Generate the initial queue for bfs
			if (inDegree[i] == 0) {			//only generate the ones with inDegree 0 (tasks with no prerequisites) 
				q.add(i);
			}
		}
		
		
		//start bfs
		while (!q.isEmpty()) {
			int cur = q.poll();
			T.add(cur);							//add the current node to the answer arraylist
			for (int adjNode : adj[cur]) {		//loops through all the adjacent nodes
				inDegree[adjNode]--;		//minus inDegree by 1 (0 means all the previous tasks are done)
				if (inDegree[adjNode] == 0) {
					q.add(adjNode);
				}
			}
		}
		
		if (T.size() < N) {
			return false;
		}
		return true;
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