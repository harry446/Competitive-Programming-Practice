package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC11S3_2 {

	static int T, M, X, Y;
	static boolean[][] grid = new boolean[5][5];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		grid[0][1] = true;
		grid[0][2] = true;
		grid[0][3] = true;
		grid[1][2] = true;
		
		T = readInt();
		
		while (T-- > 0) {
			M = readInt();
			X = readInt();
			Y = readInt();
			System.out.println(find(M, X, Y) ? "crystal":"empty");
		}
	}
	
	public static boolean find (int m, int x, int y) {
		
		if (m == 1) {
			return grid[y][x];
		}
		
		int newX = x/(int)Math.pow(5, m-1);
		int newY = y/(int)Math.pow(5, m-1);
		
		if ((newX == 1 || newX == 3) && newY == 1) {
			return find(m-1, x%(int)Math.pow(5, m-1), y%(int)Math.pow(5, m-1));
		}
		
		if (newX == 2 && newY == 2) {
			return find(m-1, x%(int)Math.pow(5, m-1), y%(int)Math.pow(5, m-1));
		}
		
		return grid[newY][newX];
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
