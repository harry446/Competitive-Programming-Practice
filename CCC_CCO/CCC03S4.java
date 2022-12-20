package second;

import java.io.*;
import java.util.*;

public class CCC03S4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int N = readInt();
		
		for (int i=0; i<N; i++) {
			String S = read();
			String[] subS = new String[S.length()];
			
			for (int j=0; j<S.length(); j++) {
				subS[j] = S.substring(j, S.length());
			}
			
			Arrays.sort(subS);
			
			int sum = subS[0].length();
			
			for (int j=0; j<S.length()-1; j++) {
				int count = 0;
				int temp = Math.min(subS[j].length(), subS[j+1].length());
				for (int k=0; k<temp; k++) {
					if (subS[j].charAt(k) != subS[j+1].charAt(k)) {
						break;
					}
					count++;
				}
				
				sum += subS[j+1].length()-count;
				
			}
			
			System.out.println(sum+1);
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
