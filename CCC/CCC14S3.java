package second;

import java.io.*;
import java.util.*;

public class CCC14S3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int T = readInt();
		
		for (int i=0; i<T; i++) {
			int N = readInt();

			Stack<Integer> carts = new Stack<>();
			Stack<Integer> temp = new Stack<>();
			
			for (int j=0; j<N; j++) {
				carts.add(readInt());
			}
			
			int cur = 1;
			while (cur <= N) {
				if (!temp.isEmpty() && temp.peek() == cur) {
					temp.pop();
					cur++;
					continue;
				}

				if (carts.isEmpty()) {
					System.out.println("N");
					break;
				}
				
				if (carts.peek() == cur) {
					carts.pop();
					cur++;
				}
				else {
					temp.add(carts.peek());
					carts.pop();
				}
				
				
				
//				if (!carts.isEmpty()) {
//					if (carts.peek() == cur) {
//						carts.pop();
//						cur++;
//					}
//					else {
//						temp.add(carts.peek());
//						carts.pop();
//					}
//					continue;
//				}	
//				
//				System.out.println("N");
//				break;

			}
			
			if (cur-1 == N) {
				System.out.println("Y");
			}
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
	static char readCharacter () {
		return read().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
