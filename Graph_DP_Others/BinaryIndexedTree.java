package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BinaryIndexedTree {

	static int N;
	static int[] arr, tree;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		arr = new int[N+1];
		tree = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			arr[i] = readInt();
		}
		build(arr);
		
		int q = readInt();
		while (q-- > 0) {
			char cmd = read().charAt(0);
			if (cmd == 'U') {		//update
				int pos = readInt();
				int delta = readInt();
				update(pos, delta);
			}
			else {
				int L = readInt();
				int R = readInt();
				System.out.printf("Sum from %d to %d is: %d\n", L, R, query(L, R));
			}
		}
		
	}

	//build - O(N)
	public static void build (int[] arr) {
		for (int i=1; i<=N; i++) {
			update(i, arr[i]);
		}
	}
	
	//update - O(log(N))
	public static void update (int pos, int delta) {
		arr[pos] += delta;
		for (int i=pos; i<=N; i+=(i&-i)) {
			tree[i] += delta;
		}
	}
	
	//query - O(log(N))
	public static int query (int pos) {
		int sum = 0;
		for (int i=pos; i>0; i-=(i&-i)) {
			sum += tree[i];
		}
		return sum;
	}
	
	//query range
	public static int query (int L, int R) {
		return query(R) - query(L-1);
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
