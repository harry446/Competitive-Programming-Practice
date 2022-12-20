package second;

import java.io.*;
import java.util.*;

public class CCC05S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int X = readInt();
		int Y = readInt();
		int x = 0;
		int y = 0;
		
		while (true) {
			int a = readInt();
			int b = readInt();
			
			if (a == 0 && b == 0) {
				break;
			}
			
			x = Math.min(Math.max(0, x+a), X);
			y = Math.min(Math.max(0, y+b), Y);
			System.out.println(x + " " + y);
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

}
