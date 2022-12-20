package second;

import java.util.*;
import java.io.*;

public class SegmentTreeTest {

	public static class Node {
		int l, r, min, gcd, count;
		
		public Node (int l, int r, int min, int gcd, int count) {
			this.l = l;
			this.r = r;
			this.min = min;
			this.gcd = gcd;
			this.count = count;
		}
	}
	
	static int N, M;
	static Node[] tree;
	static final int INF = 1000000007;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N = readInt();
		M = readInt();
		tree = new Node[N*4];
		buildTree(1, N, 1);
		
		while (M-- > 0) {
			char op = read().charAt(0);
			int n1 = readInt();
			int n2 = readInt();
			if (op == 'C') {
				update(n1, n2, 1);
			}
			else if (op == 'M') {
				System.out.println(queryMin(n1, n2, 1));
			}
			else if (op == 'G') {
				System.out.println(queryGCD(n1, n2, 1));
			}
			else {
				int G = queryGCD(n1, n2, 1);
				System.out.println(queryCount(n1, n2, G, 1));
			}
		}
		
	}
	
	public static void buildTree (int l, int r, int idx) {
		tree[idx] = new Node(l, r, 0, 0, 0);
		
		if (l == r) {
			tree[idx].min = readInt();
			tree[idx].gcd = tree[idx].min;
			tree[idx].count = 1;
			return;
		}
		
		int mid = (l+r)/2;
		buildTree(l, mid, 2*idx);
		buildTree(mid+1, r, 2*idx+1);
		pushUp(idx);
	}
	
	public static void update (int idx, int val, int treeIdx) {
		if (tree[treeIdx].l > idx || tree[treeIdx].r < idx) {
			return;
		}
		
		if (tree[treeIdx].l == tree[treeIdx].r && tree[treeIdx].l == idx) {
			tree[treeIdx].min = val;
			tree[treeIdx].gcd = val;
			return;
		}
		
		int mid = (tree[treeIdx].l + tree[treeIdx].r) / 2;
		if (idx <= mid) {
			update(idx, val, 2*treeIdx);
		}
		else {
			update(idx, val, 2*treeIdx+1);
		}
		
		pushUp(treeIdx);
	}
	
	public static int queryMin (int l, int r, int idx) {
		if (tree[idx].r < l || tree[idx].l > r) {
			return INF;
		}
		
		if (tree[idx].r <= r && tree[idx].l >= l) {
			return tree[idx].min;
		}
		
		return Math.min(queryMin(l, r, 2*idx), queryMin(l, r, 2*idx+1));
	}
	
	public static int queryGCD (int l, int r, int idx) {
		if (tree[idx].r < l || tree[idx].l > r) {
			return -1;
		}
		
		if (tree[idx].r <= r && tree[idx].l >= l) {
			return tree[idx].gcd;
		}
		
		int gcd1 = queryGCD (l, r, 2*idx);
		int gcd2 = queryGCD (l, r, 2*idx+1);
		if (gcd1 != -1 && gcd2 == -1) {
			return gcd1;
		}
		if (gcd1 == -1 && gcd2 != -1) {
			return gcd2;
		}
		if (gcd1 != -1 && gcd2 != -1) {
			return gcd(gcd1, gcd2);
		}
		return -1;
	}
	
	public static int queryCount (int l, int r, int val, int idx) {
		if (tree[idx].r < l || tree[idx].l > r) {
			return 0;
		}
		
		if (tree[idx].r <= r && tree[idx].l >= l) {
			if (tree[idx].gcd == val) {
				return tree[idx].count;
			}
			return 0;
		}
		
		return queryCount(l, r, val, 2*idx) + queryCount(l, r, val, 2*idx+1);
	}
	
	
	
	public static int gcd (int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
	
	public static void pushUp (int idx) {
		tree[idx].min = Math.min(tree[2*idx].min, tree[2*idx+1].min);
		tree[idx].gcd = gcd(tree[2*idx].gcd, tree[2*idx+1].gcd);
		tree[idx].count = 0;
		
		if (tree[2*idx].gcd == tree[idx].gcd) {
			tree[idx].count += tree[2*idx].count;
		}
		if (tree[2*idx+1].gcd == tree[idx].gcd) {
			tree[idx].count += tree[2*idx+1].count;
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
