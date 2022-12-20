package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BattlePositions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int I = readInt();
		int N = readInt();
		int J = readInt();
		int[] diff = new int[I+2];
		
		for (int i=0; i<J; i++) {
			int a = readInt();
			int b = readInt()+1;
			int k = readInt();
			diff[a] += k;
			diff[b] -= k;
		}
		
		int count = 0;
		for (int i=1; i<=I; i++) {
			diff[i] += diff[i-1];
			if (diff[i] < N) {
				count++;
			}
		}
		
		System.out.println(count);
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
