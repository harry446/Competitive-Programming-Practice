package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DWITE10R3Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		for (int z=0; z<5; z++) {
			
			int[][] graph = new int[10][10];
			Queue<Integer> q = new LinkedList<>();
			
			for (int i=0; i<10; i++) {
				String S = read();
				for (int j=0; j<10; j++) {
					char c = S.charAt(j);
					if (c == '.') {
						graph[i][j] = 0;
					}
					else if (c == 'T') {
						graph[i][j] = Integer.MAX_VALUE;
					}
					else {
						graph[i][j] = 0;
						q.add(i*100 + j);
					}
				}
			}
			
			while (!q.isEmpty()) {
				int cur = q.poll();
				int r = cur/100;
				int c = cur%100;
				
				if (r-1 >= 0 && graph[r-1][c] == Integer.MAX_VALUE) {
					q.add((r-1)*100 + c);
					graph[r-1][c] = graph[r][c] + 1;
				}
				if (r+1 < 10 && graph[r+1][c] == Integer.MAX_VALUE) {
					q.add((r+1)*100 + c);
					graph[r+1][c] = graph[r][c] + 1;
				}
				if (c-1 >= 0 && graph[r][c-1] == Integer.MAX_VALUE) {
					q.add(r*100 + c-1);
					graph[r][c-1] = graph[r][c] + 1;
				}
				if (c+1 < 10 && graph[r][c+1] == Integer.MAX_VALUE) {
					q.add(r*100 + c+1);
					graph[r][c+1] = graph[r][c] + 1;
				}
			}
			
			int max = -1;
			for (int i=0; i<10; i++) {
				for (int j=0; j<10; j++) {
					max = Math.max(max, graph[i][j]);
				}
			}
			
			System.out.println(max == Integer.MAX_VALUE ? -1 : max);
			
			read();
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
