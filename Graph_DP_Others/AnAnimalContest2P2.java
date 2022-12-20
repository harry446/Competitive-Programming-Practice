package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AnAnimalContest2P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		
		if (N == 2) {
			if (readInt()%2 != readInt()%2) {
				System.out.println(1);
			}
			else {
				System.out.println(2);
			}
			return;
		}
		
		int[] a = new int[N];
		Set<Integer> set = new HashSet<>();
		
		for (int i=0; i<N; i++) {
			a[i] = readInt();
			set.add(a[i]);
		}
		
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				if ((a[i]+a[j])%2 == 0 && set.contains((a[i]+a[j])/2)) {
					System.out.println(3);
					return;
				}
			}
		}
		
		System.out.println(2);
		return;
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
