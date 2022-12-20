package second;

import java.io.*;
import java.util.*;

public class CCC06S3 {

	static int X1, Y1, X2, Y2;
	static double M, B;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		X1 = readInt();
		Y1 = readInt();
		X2 = readInt();
		Y2 = readInt();
		
		if (X1 == X2) {
			M = Double.MIN_VALUE;
			B = 0;
		}
		else {
			M = (Y2 - Y1) / (X2 - X1);
			B = Y1 - M*X1;
		}
		
		int N = readInt();
		int count = 0;
		for (int i=0; i<N; i++) {
			boolean flag = false;
			
			int c = readInt();
			
			int firstX = readInt();
			int firstY = readInt();
			int x1 = firstX;
			int y1 = firstY;
			for (int j=0; j<c-1; j++) {
				int x2 = readInt();
				int y2 = readInt();
				
				if (isCrossing(x1, y1, x2, y2)) {
					flag = true;
				}
				x1 = x2;
				y1 = y2;
			}
			
			if (!flag && isCrossing(firstX, firstY, x1, y1)) {
				flag = true;
			}
			
			if (flag) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean isCrossing (int x1, int y1, int x2, int y2) {
		double m, b;
		
		if (x1 == x2) {
			m = Double.MIN_VALUE;
			b = 0;
		}
		else {
			m = (y2 - y1) / (x2 - x1);
			b = y1 - m*x1;
		}
		
		if (M == m) {
			if (M != Double.MIN_VALUE) {
				if (B == b && (isBetween(Y1, y1, y2)) || isBetween(Y2, y1, y2)) {
					return true;
				}
				return false;
			}
			else {
				if (X1 == x1 && (isBetween(Y1, y1, y2)) || isBetween(Y2, y1, y2)) {
					return true;
				}
				return false;
			}
		}
		else {
			double curX, curY;
			if (M != Double.MIN_VALUE && m != Double.MIN_VALUE) {
				curX = -(B-b) / (M-m);
				curY = M*curX + B;
				
//				if (isBetween(curX, X1, X2) && isBetween(curY, Y1, Y2) && isBetween(curX, x1, x2) && isBetween(curY, y1, y2)) {
//					return true;
//				}
//				return false;
			}
			else {
//				double curX, curY;
				if (M == Double.MIN_VALUE) {
					curX = X1;
					curY = m*curX + b;
				}
				else {
					curX = x1;
					curY = M*curX + B;
				}
				
//				if (isBetween(curX, X1, X2) && isBetween(curY, Y1, Y2) && isBetween(curX, x1, x2) && isBetween(curY, y1, y2)) {
//					return true;
//				}
//				return false;
			}
			
			if (isBetween(curX, X1, X2) && isBetween(curY, Y1, Y2) && isBetween(curX, x1, x2) && isBetween(curY, y1, y2)) {
				return true;
			}
			return false;
		}
	}
	
	public static boolean isBetween (double a, int b, int c) {
		if ((a >= b && a <= c) || (a <= b && a >= c)) {
			return true;
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
