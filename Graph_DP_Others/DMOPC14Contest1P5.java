package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//import java.util.LinkedList;
//import java.util.Scanner;

public class DMOPC14Contest1P5 {

	public static class Pair {
		int r, c;
		
		public Pair (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int R = readInt();
		int C = readInt();
		
		int BR = readInt();
		int BC = readInt();
		int ER = readInt();
		int EC = readInt();
		
		char[][] graph = new char[R][C];
		int[][] dist = new int[R][C];
		
		for (int i=0; i<R; i++) {
			graph[i] = read().toCharArray();
		}
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(BR, BC));
		dist[BR][BC] = 1;
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			
			if (cur.r-1 >= 0 && dist[cur.r-1][cur.c] == 0 && graph[cur.r-1][cur.c] == 'O') {
				q.add(new Pair(cur.r-1, cur.c));
				dist[cur.r-1][cur.c] = dist[cur.r][cur.c] + 1;
			}
			if (cur.r+1 < R && dist[cur.r+1][cur.c] == 0 && graph[cur.r+1][cur.c] == 'O') {
				q.add(new Pair(cur.r+1, cur.c));
				dist[cur.r+1][cur.c] = dist[cur.r][cur.c] + 1;
			}
			if (cur.c-1 >= 0 && dist[cur.r][cur.c-1] == 0 && graph[cur.r][cur.c-1] == 'O') {
				q.add(new Pair(cur.r, cur.c-1));
				dist[cur.r][cur.c-1] = dist[cur.r][cur.c] + 1;
			}
			if (cur.c+1 < C && dist[cur.r][cur.c+1] == 0 && graph[cur.r][cur.c+1] == 'O') {
				q.add(new Pair(cur.r, cur.c+1));
				dist[cur.r][cur.c+1] = dist[cur.r][cur.c] + 1;
			}
		}
		
		int T = readInt();
		int min = Integer.MAX_VALUE;
		for (int i=0; i<T; i++) {
			int a = readInt();
			int b = readInt();
			if (dist[a][b] != 0) {
				min = Math.min(min, dist[a][b]);
			}
		}
		
		System.out.println(min == Integer.MAX_VALUE ? dist[ER][EC] : dist[ER][EC] - min);
		
		
		
//		Scanner SC = new Scanner (System.in);
//
//		int R = SC.nextInt();
//		int C = SC.nextInt();
//
//		int BR = SC.nextInt();
//		int BC = SC.nextInt();
//		int ER = SC.nextInt();
//		int EC = SC.nextInt();
//
//		char [][] map = new char [R][C];
//
//		for (int i=0; i<R; i++) {
//			String S = SC.nextLine();
//			map[R] = S.toCharArray();
//		}
//
//		int T = SC.nextInt();
//
//		for (int i=0; i<T; i++){
//			int r = SC.nextInt();
//			int c = SC.nextInt();
//			map[r][c] = 'T';
//		}
//
//		//BFS
//		int [][] step = new int [R][C];
//
//		for (int row=0; row<R; row++) {
//			for (int col=0; col<C; col++) {
//				step[row][col] = Integer.MAX_VALUE;
//			}
//		}
//
//		LinkedList <Integer> rowQ = new LinkedList <Integer>();
//		LinkedList <Integer> colQ = new LinkedList <Integer>();
//		rowQ.add(BR);
//		colQ.add(BC);
//		step [BR][BC] = 0;
//
//		while(!rowQ.isEmpty() || !colQ.isEmpty()){
//			int r = rowQ.pop();
//			int c = colQ.pop();
//			//up
//			if (BR-1>=0 && step[r-1][c] > step[r][c]+1 && map[r-1][c]!='X'){
//				step[r-1][c] = step[r][c]+1;
//				rowQ.add(r-1);
//				colQ.add(c);
//			}
//			//right
//			if (BC+1<C && step[r][c+1] > step[r][c]+1 && map[r][c+1]!='X'){
//				step[r][c+1] = step[r][c]+1;
//				rowQ.add(r);
//				colQ.add(c+1);
//			}
//			//down
//			if (BR+1<R && step[r+1][c] > step[r][c]+1 && map[r+1][c]!='X'){
//				step[r+1][c] = step[r][c]+1;
//				rowQ.add(r+1);
//				colQ.add(c);
//			}
//			//left
//			if (BC-1>=0 && step[r][c-1] > step[r][c]+1 && map[r][c-1]!='X'){
//				step[r][c+1] = step[r][c]+1;
//				rowQ.add(r);
//				colQ.add(c-1);
//			}
//			
//		}
//
//		int min = Integer.MAX_VALUE;
//		for (int row=0; row<R; row++){
//			for (int col=0; col<C; col++){
//				if (map[row][col] == 'T' && step[row][col]<min){
//					min = step[row][col];
//				}
//			}
//		}
//		
//		System.out.println(step[ER][EC] - min);


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
