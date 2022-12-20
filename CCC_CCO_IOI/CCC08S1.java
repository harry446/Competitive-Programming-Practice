package second;

import java.io.*;
import java.util.*;

public class CCC08S1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> list = new ArrayList<>();
		Map<Integer, String> map = new HashMap<>();
		
		while (true) {
			String S = read();
			int temp = readInt();
			
			map.put(temp, S);
			list.add(temp);
			
			if (S.equals("Waterloo")) {
				break;
			}
		}
		
		Collections.sort(list);
		
		System.out.println(map.get(list.get(0)));
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
