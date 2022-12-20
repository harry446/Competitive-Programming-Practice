package second;

import java.io.*;
import java.util.*;

public class CCC03S3_2 {

	static int R, C, count = 1;
	static int[][] graph;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int w = readInt();
		R = readInt();
		C = readInt();
		graph = new int[R][C];
		
		for (int row=0; row<R; row++) {
			String S = read();
			for (int col=0; col<C; col++) {
				if (S.charAt(col) == 'I') {
					graph[row][col] = -1;
				}
			}
		}
		

		for (int row=0; row<R; row++) {
			for (int col=0; col<C; col++) {
				if (graph[row][col] == 0) {
					dfs(row, col);
					count++;
				}
			}
		}
		
		int[] area = new int[count];
		for (int row=0; row<R; row++) {
			for (int col=0; col<C; col++) {
				if (graph[row][col] == -1) {
					continue;
				}
				area[graph[row][col]]++;
			}
		}
		
		Arrays.sort(area);
		
		int room = 0;
		for (int i=count-1; i>=1; i--) {
			if (w < area[i]) {
				break;
			}
			room++;
			w -= area[i];
			
		}
		
		System.out.print(room + " room");
		if (room != 1) {
			System.out.print("s");
		}
		System.out.println(", " + w + " square metre(s) left over");
	}
	
	public static void dfs(int r, int c) {
		graph[r][c] = count;
		
		if (r-1 >= 0 && graph[r-1][c] == 0) {
			dfs(r-1, c);
		}
		if (c-1 >= 0 && graph[r][c-1] == 0) {
			dfs(r, c-1);
		}
		if (r+1 < R && graph[r+1][c] == 0) {
			dfs(r+1, c);
		}
		if (c+1 < C && graph[r][c+1] == 0) {
			dfs(r, c+1);
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
}
