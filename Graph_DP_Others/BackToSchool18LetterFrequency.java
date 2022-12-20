package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackToSchool18LetterFrequency {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String S = readLine();
		int[][] psa = new int[26][S.length()+1];
		
		for (int i=1; i<=S.length(); i++) {
			for (int j=0; j<26; j++) {
				psa[j][i] = psa[j][i-1];
			}
			if (S.charAt(i-1) != ' ') {
				psa[S.charAt(i-1)-97][i]++;
			}
		}

		int Q = readInt();
		for (int i=0; i<Q; i++) {
			int a = readInt();
			int b = readInt();
			char c = read().charAt(0);
			
			System.out.println(psa[c-97][b] - psa[c-97][a-1]);
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
	static char readCharacter() {
		return read().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
	
}
