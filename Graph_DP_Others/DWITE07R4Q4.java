package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DWITE07R4Q4 {
	
	public static class Pair {
		byte r, c;
		
		public Pair (byte r, byte c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte[][] moves = {{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
		
		for (int z=0; z<5; z++) {
			
			byte ER = -1, EC = -1;
			byte[][] graph = new byte[10][10];
			Queue<Pair> q = new LinkedList<>();
			
			for (byte i=0; i<10; i++) {
				String S = read();
				for (byte j=0; j<10; j++) {
					graph[i][j] = (byte)(S.charAt(j) + 80);
					
					if (S.charAt(j) == 'X') {
						if (q.isEmpty()) {
							q.add(new Pair(i, j));
							graph[i][j] = 0;
						}
						else {
							ER = i;
							EC = j;
							graph[i][j] = (byte)'.' + 80;
						}
					}
					
				}
			}
			
			while (!q.isEmpty()) {
				Pair cur = q.poll();
				
				for (byte i=0; i<8; i++) {
					byte r = (byte)(cur.r + moves[i][0]);
					byte c = (byte)(cur.c + moves[i][1]);
					
					if (r >= 0 && r < 10 && c >= 0 && c < 10 && graph[r][c] == '.'+80) {
						q.add(new Pair(r, c));
						graph[r][c] = (byte)(graph[cur.r][cur.c] + 1);
					}
				}
			}
			
			System.out.println(graph[ER][EC]);
			
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
