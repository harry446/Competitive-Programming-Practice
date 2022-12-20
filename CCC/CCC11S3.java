package second;

import java.io.*;
import java.util.*;

public class CCC11S3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int T = readInt();
		
		for (int i=0; i<T; i++) {
			int level = readInt();
			int x = readInt();
			int y = readInt();
			
			if (find(level, x, y)) {
				System.out.println("crystal");
			}
			else {
				System.out.println("empty");
			}
		}
	}
	
	public static boolean find (int level, int x, int y) {
		
		if (level == 0) {
			return false;
		}
		
		int unit = (int)Math.pow(5, level-1);
		
		int x1 = x/unit;
		int y1 = y/unit;
		if (((x1 == 1 || x1 == 2 || x1 == 3) && y1 == 0) || (x1 == 2 && y1 == 1)) {
			return true;
		}
		
		if ((x1 == 1 && y1 == 1) || (x1 == 2 && y1 == 2) || (x1 == 3 && y1 == 1)) {
			return find(level-1, x%unit, y%unit);
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
}
