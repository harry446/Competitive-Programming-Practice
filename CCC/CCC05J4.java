package second;

import java.io.*;
import java.util.*;

public class CCC05J4 {

	static int r, c;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int C = readInt();
		int R = readInt();
		
		int C2 = readInt();
		int R2 = readInt();
		
		int steps = readInt();
		
		boolean[][] visited = new boolean[R][C];
		
		for (int row=0; row<R2; row++) {
			for (int col=0; col<C2; col++) {
				visited[row][col] = true;
				visited[row][C-col-1] = true;
				visited[R-row-1][col] = true;
				visited[R-row-1][C-col-1] = true;
			}
		}
		
		int count = 0;
		int stuck = 0;
		int curR = 0;
		int curC = C2;
		r = 0;
		c = 1;
		visited[curR][curC] = true;
		
		while (true) {
			if (stuck == 4 || steps == 0) {
				break;
			}
			
			if (curR+r < 0 || curR+r >= R || curC+c < 0 || curC+c >= C || visited[curR+r][curC+c]) {
				count++;
				if (count == 4) {
					count = 0;
				}
				direction(count);
				stuck++;
				continue;
			}
			
			if (curR-c >= 0 && curR-c < R && curC+r >= 0 && curC+r < C && !visited[curR-c][curC+r]) {
				count--;
				if (count == -1) {
					count = 3;
				}
				direction(count);
				continue;
			}
			
			stuck = 0;
			
			visited[curR+r][curC+c] = true;
			curR += r;
			curC += c;
			steps--;
		}
		
		System.out.println(curC+1);
		System.out.println(curR+1);
	}
	
	public static void direction (int x) {
		if (x == 1) {
			r = 1;
			c = 0;
		}
		else if (x == 2) {
			r = 0;
			c = -1;
		}
		else if (x == 3) {
			r = -1;
			c = 0;
		}
		else {
			r = 0;
			c = 1;
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
