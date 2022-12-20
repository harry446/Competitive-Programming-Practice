package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BinaryIndexedTreeTest {

	static int N, M;
	static int[] val;
	static long[] tree, tree2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		M = readInt();
		val = new int[100001];
		tree = new long[100001];
		tree2 = new long[100001];
		
		for (int i=1; i<=N; i++) {
			val[i] = readInt();
			update(i, val[i]);
			updateCount(val[i], 1);
		}
		
		while (M-- > 0) {
			char c = read().charAt(0);
			if (c == 'C') {
				int x = readInt();
				int v = readInt();
				update(x, v-val[x]);	//adding the difference between v and cur value at index x to all related values of index x in the binary tree uwu
				updateCount(val[x], -1);
				val[x] = v;
				updateCount(val[x], 1);
			}
			else if (c == 'S') {
				int l = readInt();
				int r = readInt();
				System.out.println(query(r) - query(l - 1));
			}
			else if (c == 'Q') {
				int v = readInt();
				System.out.println(queryCount(v));
			}
		}
	}

	public static void update (int idx, int val) {
		while (idx <= N) {
			tree[idx] += val;
			idx += (idx & -idx);
		}
	}
	
	public static void updateCount (int idx, int val) {
		while (idx <= 100000) {		//Not N because values are [1, 100000], tree2 is indexed by value of the number.
			tree2[idx] += val;
			idx += (idx & -idx);
		}
	}
	
	public static long query (int idx) {
		long sum = 0;
		while (idx > 0) {
			sum += tree[idx];
			idx -= (idx & -idx);
		}
		return sum;
	}
	
	public static long queryCount (int idx) {
		long sum = 0;
		while (idx > 0) {
			sum += tree2[idx];
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
