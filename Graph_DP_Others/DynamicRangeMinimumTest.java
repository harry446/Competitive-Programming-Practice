package second;

import java.io.*;
import java.util.*;

public class DynamicRangeMinimumTest {

	static class Node {
		int l, r, val;
		public Node (int l, int r, int val) {
			this.l = l;
			this.r = r;
			this.val = val;
		}
		
	}
	
	static int N, M;
	static int[] a;
	static Node[] tree;
	static FastReader fr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		fr = new FastReader();
		
		N = fr.nextInt();
		M = fr.nextInt();
		tree = new Node[4*N];
		a = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			a[i] = fr.nextInt();
		}
		buildTree(1, N, 1);
		
		while (M-- > 0) {
			byte op = fr.readByte();
			int n1 = fr.nextInt();
			int n2 = fr.nextInt();
	         
			System.out.println(op + ", n1: " + n1 + ", n2: " + n2);
			if (op == 'M') {
				n1++;
				update(n1, n2, 1);
			} 
			else if (op == 'Q') {
				n1++; 
				n2++;
				System.out.println(queryMin(n1, n2, 1));
			}
		}
	}
	
	static void buildTree (int l, int r, int idx) {
		tree[idx] = new Node(l, r, Integer.MAX_VALUE);
		
		if (l == r) {
			tree[idx].val = a[l];
			return;
		}
		
		int mid = (l+r) / 2;
		buildTree(l, mid, 2*idx);
		buildTree(mid+1, r, 2*idx+1);
		tree[idx].val = Math.min(tree[2*idx].val, tree[2*idx+1].val);
	}
	
	
	static void update (int idx, int x, int treeIdx) {
		if (tree[treeIdx].l > idx || tree[treeIdx].r < idx) {
			return;
		}
		
		if (tree[treeIdx].l == idx && tree[treeIdx].l == tree[treeIdx].r) {
			tree[treeIdx].val = x;
			return;
		}
		
		int mid = (tree[treeIdx].l + tree[treeIdx].r) / 2;
		if (idx <= mid) {
			update(idx, x, 2*treeIdx);
		}
		else {
			update(idx, x, 2*treeIdx+1);
		}
		tree[treeIdx].val = Math.min(tree[2*treeIdx].val, tree[2*treeIdx+1].val);
	}
	
	
	static int queryMin (int l, int r, int treeIdx) {
		if (tree[treeIdx].r < l || tree[treeIdx].l > r) {
			return Integer.MAX_VALUE;
		}
		
		if (tree[treeIdx].r <= r && tree[treeIdx].l >= l) {
			return tree[treeIdx].val;
		}
		
		int ansL = queryMin(l, r, 2*treeIdx);
		int ansR = queryMin(l, r, 2*treeIdx+1);
		return Math.min(ansL, ansR);
	}
	
	
 
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static StringTokenizer st;
// 
//	static String read() {
//		while (st == null || !st.hasMoreTokens()) {
//			try { st = new StringTokenizer(br.readLine()); 
//			} catch (IOException e) {}
//		}
//		return st.nextToken();
//	}
//	static int readInt() {
//		return Integer.parseInt(read());
//	}
//	static long readLong() {
//		return Long.parseLong(read());
//	}
//	static double readDouble() {
//		return Double.parseDouble(read());
//	}
//	static char readCharacter() {
//		return read().charAt(0);
//	}
//	static String readLine() throws IOException {
//		return br.readLine().trim();
//	}

	
	static class FastReader {
        final InputStream in = System.in;
        final int bufSize = 30000;
        byte[] buf = new byte[bufSize];
        int pos = 0;
        int byteCount = bufSize;

        boolean isNeg;
        byte ch;

        int nextInt() throws IOException {
            while(ch < '-') ch = readByte();
            if(isNeg = (ch == '-')) ch = readByte();
            int res = ch-'0';
            while((ch = readByte()) >= '0' && ch <= '9') res = res*10 + ch-'0';
            return isNeg ? -res : res;
        }

        long nextLong() throws IOException {
            while(ch < '-') ch = readByte();
            if(isNeg = (ch == '-')) ch = readByte();
            long res = ch-'0';
            while((ch = readByte()) >= '0' && ch <= '9') res = res*10 + ch-'0';
            return isNeg ? -res : res;
        }

        double nextDouble() throws IOException {
            long whole = nextLong();
            if(ch != '.') return whole;
            long div = 10;
            long decimal = readByte()-'0';
            for(; (ch = readByte()) >= '0' && ch <= '9'; div *= 10) decimal = decimal*10 + ch-'0';
            return isNeg ? (whole - (double) decimal / div) : (whole + (double) decimal / div);
        }

        byte[] nextString(int maxLength) throws IOException {
            byte[] strArr = new byte[maxLength + 1];
            for (int i = 0; i < maxLength; i++) {
                strArr[i] = readByte();
                if(strArr[i] <= ' '){
                    byte[] res = new byte[i];
                    System.arraycopy(strArr, 0, res, 0, i);
                    return res;
                }
            }

            throw new AssertionError();
        }

        FastReader() throws IOException {
            fill();
        }

        void fill() throws IOException {
            byteCount = in.read(buf, 0, bufSize);
        }

        byte readByte() throws IOException {
            if (pos == byteCount) {
                fill();
                pos = 0;
            }
            return buf[pos++];
        }
    }
	
}
