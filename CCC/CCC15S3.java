package second;

import java.io.*;
import java.util.*;

public class CCC15S3 {

	static int G, P;
	static int[] par;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		G = readInt();
		P = readInt();
		par = new int[G+1];
		
		for (int i=0; i<=G; i++) {
			par[i] = i;
		}
		
		int count = 0;
		for (int i=0; i<P; i++) {
			int gate = find(readInt());
			if (gate == 0) {
				System.out.println(count);
				return;
			}
			
			par[gate] = par[gate-1];
			count++;
		}
		
		System.out.println(P);
	}
	
	public static int find (int s) {
		if (par[s] == s) {
			return s;
		}
		return par[s] = find(par[s]);
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
