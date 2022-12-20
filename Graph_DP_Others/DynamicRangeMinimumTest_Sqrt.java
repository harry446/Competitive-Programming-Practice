package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DynamicRangeMinimumTest_Sqrt {

	static final int INF = 0x3f3f3f3f, B = 300;
	static int[] arr, blocks;
	static int N, M;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		N = readInt();
		M = readInt();
		
		arr = new int[100001];
		blocks = new int[100001];
		for (int i=0; i<N; i++) {
			arr[i] = readInt();
		}
		
		precompute();
		
		for (int i=0; i<M; i++) {
			char c = read().charAt(0);
			int a = readInt();
			int b = readInt();
			
			if (c == 'M') {
				update(a, b);
			}
			else if (c == 'Q') {
				System.out.println(query(a, b));
			}
		}
		
	}
	
	public static void precompute () {
		Arrays.fill(blocks, INF);
		for (int i=0; i<N; i++) {
			blocks[i/B] = Math.min(blocks[i/B], arr[i]);
		}
	}
	
	public static void update (int idx, int x) {
		arr[idx] = x;
		int b = idx/B;
		blocks[b] = INF;
		for (int i=b*B; i<Math.min((b+1)*B, 100000); i++) {
			blocks[b] = Math.min(blocks[b], arr[i]);
		}
	}
	
	public static int query (int l, int r) {
		int ans = INF;
		int bl = (l-1)/B + 1;
		int br = (r+1)/B - 1;
		
		if (bl <= br) {
			for (int i=bl; i<=br; i++) {
				ans = Math.min(ans, blocks[i]);
			}
			
			for (int i=l; i<Math.min(bl*B, 100000); i++) {
				ans = Math.min(ans, arr[i]);
			}
			
			for (int i=(br+1)*B; i<=r; i++) {
				ans = Math.min(ans, arr[i]);
			}
		}
		else {
			for (int i=l; i<=r; i++) {
				ans = Math.min(ans, arr[i]);
			}
		}
		return ans;
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
