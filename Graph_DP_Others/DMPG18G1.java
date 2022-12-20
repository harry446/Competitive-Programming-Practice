package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DMPG18G1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int K = readInt();
		int left = K+1;
		boolean[] chairs = new boolean[N+1];
		int[] position = new int[N+1];
		
		for (int i=0; i<K; i++) {
			chairs[readInt()] = true;
		}
		for (int i=1; i<=K+1; i++) {
			int a = readInt();
			if (chairs[a]) {
				left--;
				chairs[a] = false;
			}
			else {
				position[a] = i;
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		
		int cur = 0;
		while (true) {
			
			if (left == 1) {
				System.out.println(stack.pop());
				return;
			}
			
			cur++;
			if (position[cur] != 0) {
				stack.push(position[cur]);
				position[cur] = 0;
			}
			else {
				if (chairs[cur] && !stack.isEmpty()) {
					chairs[cur] = true;
					stack.pop();
					left--;
				}
			}
			
			if (cur == N) {
				cur = 0;
			}
//			System.out.println("hi: " + cur);
		}
		
//		System.out.println(last);
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
