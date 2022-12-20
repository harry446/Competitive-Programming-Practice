package second;

import java.io.*;
import java.util.*;

public class CCO13P2 {

	public static class Node {
		int l, r, val, id, level;
		
		public Node (int l, int r, int val, int id, int level) {
			this.l = l;
			this.r = r;
			this.val = val;
			this.id = id;
			this.level = level;
		}
	}
	
	static int N, M;
	static Node[] tree;
	static final int INF = 1000000007;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		N = (1 << readInt());
		M = readInt();
		tree = new Node[4*N];
		buildTree(1, N, 1, 0);
		
		while(M-- > 0) {
			char c = read().charAt(0);
			if (c == 'R') {
				int pos = readInt();
				int x = readInt();
				update(pos, x, 1);
			}
			else if (c == 'W') {
				System.out.println(tree[1].id);
			}
			else {
				int pos = readInt();
				System.out.println(N-queryLevel(pos, 1));
			}
		}
	}
	
	public static void buildTree (int l, int r, int idx, int level) {
		tree[idx] = new Node(l, r, 0, 0, level);
		
		if (l == r) {
			int a = readInt();
			tree[idx].val = a;
			tree[idx].id = l;
			return;
		}
		
		int mid = (l+r)/2;
		buildTree(l, mid, 2*idx, level+1);
		buildTree(mid+1, r, 2*idx+1, level+1);
		pushUp(idx);
	}
	
	
	public static void update (int idx, int val, int treeIdx) {
		if (tree[treeIdx].l > idx || tree[treeIdx].r < idx) {
			return;
		}
		
		if (tree[treeIdx].l == tree[treeIdx].r && tree[treeIdx].l == idx) {
			tree[treeIdx].val = val;
			return;
		}
		
		int mid = (tree[treeIdx].l + tree[treeIdx].r)/2;
		if (idx <= mid) {
			update(idx, val, 2*treeIdx);
		}
		else {
			update(idx, val, 2*treeIdx+1);
		}
		pushUp(idx);
	}
	
	public static int queryLevel (int id, int idx) {
		if (tree[idx].id == id) {
			return tree[idx].level;
		}
		
		int mid = (tree[idx].l + tree[idx].r)/2;
		if (id <= mid) {
			return queryLevel(id, 2*idx);
		}
		else {
			return queryLevel(id, 2*idx+1);
		}
	}
	
	public static void pushUp (int idx) {
		if (tree[2*idx].val > tree[2*idx+1].val) {
			tree[idx].val = tree[2*idx].val;
			tree[idx].id = tree[2*idx].id;
		}
		else {
			tree[idx].val = tree[2*idx+1].val;
			tree[idx].id = tree[2*idx+1].id;
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
