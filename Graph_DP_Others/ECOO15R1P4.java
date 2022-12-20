package second;

import java.io.*;
import java.util.*;

public class ECOO15R1P4 {

	static String[] words = {"ook", "ookook", "oog", "ooga", "ug", "mook", "mookmook", "oogam", "oogum", "ugug"};
	static Map<String, Integer> dp = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i=0; i<10; i++) {
			String S = read();
			dp = new HashMap<>();
			
			System.out.println(find(S));
		}
		
	}
	
	public static int find (String S) {
		
		if (dp.containsKey(S)) {
			return dp.get(S);
		}
		
		int count = 0;
		for (int i=0; i<10; i++) {
			if (S.equals(words[i])) {
				count++;
			}
		}
		if (S.length() <= 2) {
			return count;
		}
		
		for (int i=0; i<10; i++) {
			if (S.length() < words[i].length()) {
				continue;
			}
			
			if (S.substring(0, words[i].length()).equals(words[i])) {
				count += find(S.substring(words[i].length()));
			}
			
		}
		
		dp.put(S, count);
		return count;
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
