package second;

import java.io.*;
import java.util.*;

public class royalGuard {
	
	
	static long[] bX;
	static long[] bY;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		bX = new long[N];
		bY = new long[N];
		
		for (int i=0; i<N; i++) {
			long x = readLong();
			long y = readLong();
			bX[i] = x * (long)(1e9) + y;
			bY[i] = y * (long)(1e9) + x;
		}
		
		Arrays.sort(bX);
		Arrays.sort(bY);
		
		int M = readInt();
		long ans = 0;
		int x0 = readInt();
		int y0 = readInt();
		
		for (int i=0; i<M-1; i++) {
			int x1 = readInt();
			int y1 = readInt();
			if (y0 == y1) {
				int startX = Arrays.binarySearch(bY, y0 * (long)(1e9) + Math.min(x0, x1));
				int endX = Arrays.binarySearch(bY, y0 * (long)(1e9) + Math.max(x0, x1));
				if (startX < 0) {
					startX = -startX - 1;
				}
				if (endX < 0) {
					endX = -endX - 2;
				}
				ans += (endX - startX + 1);
			}
			else if (x0 == x1) {
				int startY = Arrays.binarySearch(bX, x0 * (long)(1e9) + Math.min(y0, y1));
				int endY = Arrays.binarySearch(bX, x0 * (long)(1e9) + Math.max(y0, y1));
				if (startY < 0) {
					startY = -startY - 1;
				}
				if (endY < 0) {
					endY = -endY - 2;
				}
				ans += (endY - startY + 1);
			}
			
			x0 = x1;
			y0 = y1;
		}
		
		System.out.println(ans);
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
