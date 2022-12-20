package second;

import java.io.*;
import java.util.*;

public class AnAnimalContest3P3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int[] a = new int[N];
		
		for (int i=0; i<N; i++) {
			a[i] = readInt();
		}
		Arrays.sort(a);
		
		for (int i=0; i<N/2; i++) {
			System.out.print(a[i] + " " + a[N-i-1]);
			System.out.print(i == N/2-1 ? "" : " ");
		}
		System.out.println(N%2 == 0 ? "" : " " + a[N/2]);
		
		for (int i=0; i<N/2; i++) {
			System.out.print("BS");
		}
		System.out.println(N%2 == 0 ? "" : "E");
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
	static char readCharacter () {
		return read().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
