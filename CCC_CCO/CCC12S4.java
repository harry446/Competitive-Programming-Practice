package second;

import java.io.*;
import java.util.*;

public class CCC12S4 {

	static int N;
	static ArrayList<Integer>[] location;
	static int[] dist;
	static Queue<ArrayList<Integer>[]> q = new LinkedList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while (true) {
			N = readInt();
			
			if (N == 0) {
				break;
			}
			
			dist = new int[(int)Math.pow(N, N)];
			location = new ArrayList[N];
			
			for (int i=0; i<N; i++) {
				location[i] = new ArrayList<>();
			}
			for (int i=0; i<N; i++) {
				location[i].add(readInt());
			}
			
			q.add(location);
			
			for (int j=0; j<N; j++) {
				for (int coins : location[j]) {
					System.out.print(coins + " ");
				}
				System.out.println();
			}
			System.out.println();
			
			bfs();
//			for (int i=1; i<N; i++) {
//				ArrayList<Integer>[] temp = new ArrayList[N];
//				if (location[i-1].get(0) > location[i].get(0)) {
//					Arrays.fill(temp, new ArrayList<>());
//					temp[i-1].add(location[i-1].get(0));
//					temp[i-1].add(location[i].get(0));
//					for (int j=i+1; j<N; j++) {
//						temp[j].add(location[j].get(0));
//					}
//					q.add(temp);
//					
//				}
//			}
			
		}
		
	}
	
	public static void bfs () {
		
		while (!q.isEmpty()) {
			ArrayList<Integer>[] temp = new ArrayList[N];
			ArrayList<Integer>[] cur = q.poll();
			System.out.println("HI");
			for (int i=1; i<N; i++) {
				
//				System.out.println("i-1: " + (i-1) + ", cur[i-1].size()-1: " + (cur[i-1].size()-1));
//				System.out.println("i: " + (i) + ", cur[i].size()-1: " + (cur[i].size()-1));
//				System.out.println("--------------------------------");
//				for (int j=0; j<N; j++) {
//					for (int coins : cur[j]) {
//						System.out.print(coins + " ");
//					}
//					System.out.println();
//				}
//				System.out.println("--------------------------------");
				
				if (cur[i-1].size() == 0 || cur[i].size() == 0) {
					continue;
				}
				
				int preCoin = cur[i-1].get(cur[i-1].size()-1);
				int curCoin = cur[i].get(cur[i].size()-1);
				if (preCoin > curCoin) {
					for (int j=0; j<N; j++) {
						temp[j] = new ArrayList<>();
					}
					
					for (int j=0; j<N; j++) {
						System.out.print(j + ": ");
						for (int coins : cur[j]) {
							temp[j].add(coins);
							System.out.print(coins + " ");
						}
						System.out.println();
					}
					System.out.println();
					
					for (int j=0; j<N; j++) {
						System.out.print("temp[" + j + "]: ");
						for (int coins : temp[j]) {
							System.out.print(coins + " ");
						}
						System.out.println();
					}
					System.out.println();
					
					temp[i-1].add(curCoin);
					temp[i].remove(temp[i].size()-1);
					q.add(temp);
					
					for (int j=0; j<N; j++) {
						System.out.print("temp[" + j + "]: ");
						for (int coins : temp[j]) {
							System.out.print(coins + " ");
						}
						System.out.println();
					}
					System.out.println();
				}
			}
			
		}
	}
	
//	public static int baseN ()

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
