package second;

import java.io.*;
import java.util.*;

public class CCC05J5 {
	
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while (true) {
			String S = read();
			count = 0;
			
			if (S.equals("X")) {
				break;
			}
			
			if (isMonkey(S, true)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		
	}
	
	public static boolean isMonkey (String S, boolean flag) {
		
		if (S.length() == 1) {
			if (S.equals("B") && !flag && count == 1) {
				return true;
			}
			
			if (S.equals("A") && flag && count == 0) {
				return true;
			}
			
			return false;
		}
		
		
		char c = S.charAt(S.length()-1);
		
		if (c == 'S' && flag) {
			count++;
			return isMonkey(S.substring(0, S.length()-1), flag);	//A first next time
		}
		
		if (c == 'B' && !flag) {
			count--;
			return isMonkey(S.substring(0, S.length()-1), flag);	//N first next time
		}
		
		if (flag) {		//A first
			if (c == 'A') {
				return isMonkey(S.substring(0, S.length()-1), !flag);	//N first next time
			}
			return false;
		}
		
		if (!flag) {	//N first
			if (c == 'N') {
				return isMonkey(S.substring(0, S.length()-1), !flag);	//A first next time
			}
			return false;
		}
		
		return false;
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
