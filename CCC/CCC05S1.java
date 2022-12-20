package second;

import java.io.*;
import java.util.*;

public class CCC05S1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		Map<String, Integer> r = new HashMap<>();
		
		r.put("1", 1);
		r.put("2", 2);
		r.put("A", 2);
		r.put("B", 2);
		r.put("C", 2);
		r.put("3", 3);
		r.put("D", 3);
		r.put("E", 3);
		r.put("F", 3);
		r.put("4", 4);
		r.put("G", 4);
		r.put("H", 4);
		r.put("I", 4);
		r.put("5", 5);
		r.put("J", 5);
		r.put("K", 5);
		r.put("L", 5);
		r.put("6", 6);
		r.put("M", 6);
		r.put("N", 6);
		r.put("O", 6);
		r.put("7", 7);
		r.put("P", 7);
		r.put("Q", 7);
		r.put("R", 7);
		r.put("S", 7);
		r.put("8", 8);
		r.put("T", 8);
		r.put("U", 8);
		r.put("V", 8);
		r.put("9", 9);
		r.put("W", 9);
		r.put("X", 9);
		r.put("Y", 9);
		r.put("Z", 9);
		r.put("0", 0);
		

		for (int i=0; i<N; i++) {
			String S = read();
			String ansTemp = "";
			String ans = "";
			
			for (int j=0; j<S.length(); j++) {
				if (S.charAt(j) == '-') {
					continue;
				}
				
				ansTemp += r.get(S.charAt(j) + "");
			}
			
			int count = 0;
			for (int j=0; j<10; j++) {
				count++;
				if (count == 4 || count == 7) {
					ans += "-";
				}
				
				ans += ansTemp.charAt(j);
			}
			
			
			System.out.println(ans);
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
