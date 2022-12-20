package second;

import java.io.*;
import java.util.*;

public class CCC04S3 {

	public static class Pair {
		int r, c;
		
		public Pair (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static Map<String, LinkedList<Pair>> graph = new HashMap<>();
	static int[][] value = new int[10][9];
	static boolean[][] visited = new boolean[10][9];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int row=0; row<10; row++) {
			Arrays.fill(value[row], -1);
			for (int col=0; col<9; col++) {
				String S = read();
				
				if (S.charAt(0) <= '9') {
					value[row][col] = Integer.parseInt(S);
					continue;
				}
				
				String[] temp = S.split("\\+");
				for (int i=0; i<temp.length; i++) {
					int r = (int)temp[i].charAt(0)-'A';
					int c = (int)temp[i].charAt(1)-'1';
					String temp2 = row + ", " + col;
					if (!graph.containsKey(temp2)) {
						graph.put(temp2, new LinkedList<>());
					}
					graph.get(temp2).add(new Pair(r, c));
				}
			}
		}
		
//		for (int row=0; row<10; row++) {
//			for (int col=0; col<9; col++) {
//				System.out.print(value[row][col] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	
//		for (String key : graph.keySet()) {
//			System.out.print(key + ": ");
//			for (Pair kids : graph.get(key)) {
//				System.out.print(kids.r + " " + kids.c + ", ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		for (int row=0; row<10; row++) {
			for (int col=0; col<9; col++) {
				if (value[row][col] != -1) {
					continue;
				}
				
				dfs(row, col);
				
				visited = new boolean[10][9];
			}
		}
		
		for (int row=0; row<10; row++) {
			for (int col=0; col<9; col++) {
				if (value[row][col] < 0) {
					System.out.print("* ");
					continue;
				}
				System.out.print(value[row][col] + " ");
			}
			System.out.println();
		}
		
//		System.out.println();
//		for (int row=0; row<10; row++) {
//			for (int col=0; col<9; col++) {
//				System.out.print(value[row][col] + " ");
//			}
//			System.out.println();
//		}
		
	}
	
	
	public static int dfs(int r, int c) {
		
		if (value[r][c] != -1) {
//			System.out.println("YESS");
			return value[r][c];
		}
//		if (value[r][c] < -1) {
//			System.out.println("YESSS");
//			return value[r][c];
//		}
		
		boolean flag = false;
		visited[r][c] = true;
		int sum = 0;
		
		String S = r + ", " + c;
		LinkedList<Pair> cur = graph.get(S);
		
		for (Pair kids : cur) {
//			flag = false;
			
//			if (kids.r == R && kids.c == C) {
////				flag = false;
//				System.out.println("YES" + "R: " + R + " C: " + C);
//				return value[r][c] = -10;
//			}
			
			if (value[kids.r][kids.c] >= 0) {
				sum += value[kids.r][kids.c];
				flag = true;
				continue;
			}
			
			if (visited[kids.r][kids.c]) {
				return value[r][c] = -10;
			}
			
//			if (!visited[kids.r][kids.c]) {
//				flag = true;
//				int ans = dfs(kids.r, kids.c, R, C);
//				if (ans >= 0) {
//					sum += ans;
//				}
//				else {
//					return value[r][c] = ans;
//				}
//			}
			
			int ans = dfs(kids.r, kids.c);
			if (ans >= 0) {
				sum += ans;
			}
			else {
				return value[r][c] = ans;
			}
			flag = true;
		}
		
		if (flag) {
			return value[r][c] = sum;
		}
		return value[r][c] = -10;
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
}
