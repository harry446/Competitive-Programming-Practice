package second;

import java.io.*;
import java.util.*;

public class CCC08J4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		while (true) {
			String S = sc.nextLine();
			String ans = "";
			
			if (S.equals("0")) {
				break;
			}
			
			for (int i=0; i<S.length(); i++) {
				if (S.charAt(i) == ' ') {
					continue;
				}
				ans += S.charAt(i);
			}
			
			
			boolean[] flag = new boolean[ans.length()];
			
			for (int i=ans.length()-1; i>=0; i--) {
				if (isOperator(ans.charAt(i))) {
					int count = 0;
					int index = -1;
					
					for (int j=i; j<ans.length(); j++) {
						if (!flag[j]) {
							count++;
							flag[j] = true;
						}
						if (count == 3) {
							index = j-i;
							flag[j] = false;
							break;
						}
					}
					
					String temp = ans;
					
					if (ans.length() > i+3) {
						ans = temp.substring(0, i);
						for (int k=1; k<=index; k++) {
							ans += temp.charAt(i+k);
						}
						ans += temp.charAt(i);
						ans += temp.substring(i+index+1);
					}
					else {
						ans = temp.substring(0, i);
						for (int k=1; k<=index; k++) {
							ans += temp.charAt(i+k);
						}
						ans += temp.charAt(i);
					}

				}
			}
			
			for (int i=0; i<ans.length(); i++) {
				System.out.print(ans.charAt(i) + " ");
			}
			System.out.println();
			
		}
	}
	
	public static boolean isOperator (char c) {
		if (c == '+' || c == '-') {
			return true;
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
