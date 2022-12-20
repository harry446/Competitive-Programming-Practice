package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MockCCC14S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int[] a = new int[N];
		
		for (int i=0; i<N; i++) {
			a[i] = readInt();
		}
		
		int start = 0;
		int length = 1;
		int max = 0;
		
		for (int p=1; p<N; p++) {
			int i = p+1;
			while (i<N && a[i-1] > a[i]) {
				i++;
			}
			if (i-1 <= p) {
				continue;
			}
			
			int k = i;
			while (k<N && a[k-1] == a[k]) {
				k++;
			}
			
			int j = k;
			while (j<N && a[j-1] < a[j]) {
				j++;
			}
			if (j == k) {
				continue;
			}
			
			max = Math.max(max, j-p);
			p = j-2;
		}
		
		System.out.println(max);

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
