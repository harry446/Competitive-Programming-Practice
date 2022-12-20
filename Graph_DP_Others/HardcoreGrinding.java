package second;

import java.io.*;
import java.util.*;

public class HardcoreGrinding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int[] diff = new int[10000001];	//difference array
		int sum = 0;
		int total = 0;
		
		for (int i=0; i<N; i++) {
			int s = readInt();
			int f = readInt();
			
			diff[s] += 1;
			diff[f] -= 1;
		}
		
		for (int i=1; i< 10000001; i++) {
			sum += diff[i];
			total = Math.max(sum, total);
		}
		
		System.out.println(total);
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
}
