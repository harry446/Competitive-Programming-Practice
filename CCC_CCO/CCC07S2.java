package second;

import java.io.*;
import java.util.*;

public class CCC07S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int[][] standards = new int[N][3];
		for (int i=0; i<N; i++) {
			standards[i][0] = readInt();
			standards[i][1] = readInt();
			standards[i][2] = readInt();
			Arrays.sort(standards[i]);
		}
		
		int M = readInt();
		int[][] packages = new int[M][3];
		for (int i=0; i<M; i++) {
			packages[i][0] = readInt();
			packages[i][1] = readInt();
			packages[i][2] = readInt();
			Arrays.sort(packages[i]);
		}
		
		
		for (int i=0; i<M; i++) {
			int min = Integer.MAX_VALUE;
			for (int j=0; j<N; j++) {
				int num1 = standards[j][0];
				int num2 = standards[j][1];
				int num3 = standards[j][2];
				
				if (num1 >= packages[i][0] && num2 >= packages[i][1] && num3 >= packages[i][2]) {
					min = Math.min(min, num1 * num2 * num3);
				}
			}
			
			if (min == Integer.MAX_VALUE) {
				System.out.println("Item does not fit.");
				continue;
			}
			
			System.out.println(min);
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
}
