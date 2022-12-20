package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC05S5 {

	static int N;
	static int[] tree, val;
	static Set<Integer> coord = new TreeSet<>();
	static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		tree = new int[100001];
		val = new int[100001];
		for (int i=1; i<=N; i++) {
			val[i] = readInt();
			coord.add(val[i]);
		}
		
		//coordinate compression
		int idx = 1;
//		for (Iterator i=coord.iterator(); i.hasNext();) {
//			map.put((int)i.next(), idx++);
//		}
		for (int k : coord) {
			map.put(k, idx++);
		}
		
		long sum = 0;
		for (int i=1; i<=N; i++) {
			//System.out.print("val[i]: " + val[i] + ", ");
			
			val[i] = map.get(val[i]);	//overall ranking of val[i], 1 -> worst(lowest score)
			
			sum += i - query(val[i]);	//current total players - all players played before cur player whom the cur player also performed better than
										//							(before && worse than cur player)
										//= the current standings of the current player
			
//			System.out.println("Sum: " + sum + ", i: " + i + ", rank: " + val[i] + ", query(val[i]): " + query(val[i]));
			
			update(val[i], 1);			//increasing all values of players with higher score by 1, 
										//denoting there is one additional player whom they performed better than
										//binary tree updating as players are being processed in chronological order
		}
		System.out.printf("%.2f\n", sum*100/N/100.0);
	}

	public static void update (int idx, int delta) {
		while (idx <= 100001) {
			tree[idx] += delta;
			idx += (idx & -idx);
		}
	}
	
	public static int query (int idx) {
		int sum = 0;
		while (idx > 0) {
			sum += tree[idx];
			idx -= (idx & -idx);
		}
		return sum;
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
