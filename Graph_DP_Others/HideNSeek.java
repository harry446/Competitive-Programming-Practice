package second;

import java.io.*;
import java.util.*;

public class HideNSeek {

	public static class Pair {
		int x, y;
		
		public Pair (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, T, BR, BC, min = Integer.MAX_VALUE;
	static Pair[] pos, hiders;
	static char[][] graph;
	static int[][] dist;
	static Map<String, Integer> dp = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		M = readInt();
		T = readInt();
		pos = new Pair[T+1];
		hiders = new Pair[T];
		graph = new char[N][M];
		dist = new int[N][M];
		
		for (int i=0; i<N; i++) {
			graph[i] = read().toCharArray();
		}

		int count = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (graph[i][j] == 'G') {
					pos[0] = new Pair(i, j);
					BR = i;
					BC = j;
				}
				else if (graph[i][j] == 'H') {
					hiders[count] = new Pair(i, j);
					pos[++count] = new Pair(i, j);
				}
			}
		}
		
		for (int i=0; i<T; i++) {
			for (int j=i+1; j<=T; j++) {
				int BR = pos[i].x;
				int BC = pos[i].y;
				int ER = pos[j].x;
				int EC = pos[j].y;
				for (int k=0; k<N; k++) {
					Arrays.fill(dist[k], -1);
				}
				
				bfs(BR, BC);
				dp.put(BR + "," + BC + "$" + ER + "," + EC, dist[ER][EC]);
				dp.put(ER + "," + EC + "$" + BR + "," + BC, dist[ER][EC]);
			}
		}
		
		permutations(T, hiders);
		System.out.println(min);
		
		
	}
	
	public static void bfs (int BR, int BC) {
		dist[BR][BC] = 0;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(BR, BC));
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int curR = cur.x;
			int curC = cur.y;
			int curD = dist[curR][curC];
			
			if (curR-1 >= 0 && graph[curR-1][curC] != 'X' && dist[curR-1][curC] == -1) {
				dist[curR-1][curC] = curD+1;
				q.add(new Pair(curR-1, curC));
			}
			if (curR+1 < N && graph[curR+1][curC] != 'X' && dist[curR+1][curC] == -1) {
				dist[curR+1][curC] = curD+1;
				q.add(new Pair(curR+1, curC));
			}
			if (curC-1 >= 0 && graph[curR][curC-1] != 'X' && dist[curR][curC-1] == -1) {
				dist[curR][curC-1] = curD+1;
				q.add(new Pair(curR, curC-1));
			}
			if (curC+1 < M && graph[curR][curC+1] != 'X' && dist[curR][curC+1] == -1) {
				dist[curR][curC+1] = curD+1;
				q.add(new Pair(curR, curC+1));
			}
		}
	}
	
	public static void permutations (int t, Pair[] hiders) {
		if (t == 1) {
			int total = dp.get(BR + "," + BC + "$" + hiders[0].x + "," + hiders[0].y);
			for (int i=0; i<T-1; i++) {
				total += dp.get(hiders[i].x + "," + hiders[i].y + "$" + hiders[i+1].x + "," + hiders[i+1].y);
			}
			min = Math.min(min, total);
			return;
		}

		for (int i=0; i<t-1; i++) {
			permutations(t-1, hiders);
			if (t%2 == 0) {
				swap(hiders, i, t-1);
			}
			else {
				swap(hiders, 0, t-1);
			}
		}
		permutations(t-1, hiders);
	}
	
	public static void swap (Pair[] hiders, int a, int b) {
		Pair temp = hiders[a];
		hiders[a] = hiders[b];
		hiders[b] = temp;
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
