package second;

import java.io.*;
import java.util.*;

public class CCC08S4 {

	static ArrayList<Integer> list;
	static int[] cards = new int[4];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		
		for (int i=0; i<N; i++) {
			list = new ArrayList<>();
			
		}
	}
	
	public static void find (int index) {
		if (index == 1) {
			list.add(cards[0]);
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
