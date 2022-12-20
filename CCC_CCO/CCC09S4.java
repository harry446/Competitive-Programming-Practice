package second;

import java.util.*;
import java.io.*;

public class CCC09S4 {

	 static class Pair {
		 int f, s;
		 public Pair(int f0, int s0) {
			 f = f0; s = s0;
	     }
	}
	
	static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    
    static boolean[] visited;
    static int[] dist;
    static int[][] adj;
    static ArrayList<Pair> prices;	// {city #, price of pencil} 
    
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new OutputStreamWriter(System.out));
        int N = readInt();
        int T = readInt();
        
        visited = new boolean[N+1];
        dist = new int[N+1];
        adj = new int[N+1][N+1];
        prices = new ArrayList<>();
        
        
        for (int i=0; i<T; i++) {
        	int x = readInt();
        	int y = readInt();
        	int c = readInt();
        	adj[x][y] = adj[y][x] = c;
        }
        
        int K = readInt();
        for (int i=0; i<K; i++) {
        	int z = readInt();
        	int p = readInt();
        	prices.add(new Pair(z, p));
        }
		
        int D = readInt();
        Arrays.fill(dist, 99999999);
		dist[D] = 0;
		
		for (int i=1; i<=N; i++) {
			int smallest = 0;
			for (int j=1; j<=N; j++) {
				if (!visited[j] && dist[j] < dist[smallest]) {
					smallest = j;
				}
			}
			if (smallest == 0) {
				break;
			}
			
			visited[smallest] = true;
			
			for (int v=1; v<=N; v++) {
				if (adj[smallest][v] > 0 && dist[smallest] + adj[smallest][v] < dist[v]) {
					dist[v] = dist[smallest] + adj[smallest][v];
				}
			}
		}
		
		int min = 99999999;
		for (Pair m : prices) {
			int z = m.f;
			int p = m.s;
			int price = dist[z] + p;
			min = Math.min(min, price);
		}
		
		System.out.println(min);
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
