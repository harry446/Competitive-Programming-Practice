package second;

import java.io.*;
import java.util.*;

public class AnAnimalContest3P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A = readInt();
		int B = readInt();
		int C = readInt();
		int D = readInt();
		
		if (A < B && C < D) {
			System.out.println("Go to the department store");
		}
		else if (A < B) {
			System.out.println("Go to the grocery store");
		}
		else if (C < D) {
			System.out.println("Go to the pharmacy");
		}
		else {
			System.out.println("Stay home");
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
