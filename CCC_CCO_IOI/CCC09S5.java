package second;

import java.io.*;
import java.util.*;

public class CCC09S5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int count = 0, max = -1;
		int M = readInt();	//East to West, number of rows
		int N = readInt();	//North to South, number of columns
		int[][] diff = new int[M][N+1];
		
		int K = readInt();
		for (int i=0; i<K; i++) {
			int x = readInt()-1;	//column number of coffee shop
			int y = M-readInt();	//row number of coffee shop (reversed)
			int R = readInt();		//radius
			int B = readInt();		//bitrate
			
			//find vertical range
			int vStart = Math.max(0, y-R);
			int vEnd = Math.min(M-1, y+R);
			
			for (int j=vStart; j<=vEnd; j++) {
				int vDist = Math.abs(j - y);	//find the vertical distance for Pythagorean theorem
				int hDist = (int)Math.sqrt(Math.pow(R, 2) - Math.pow(vDist, 2));
				//System.out.println("H: " + hDist);
				//find horizontal range
				int hStart = Math.max(0, x-hDist);
				int hEnd = Math.min(N, x+hDist+1);	//+1 for difference array
				
				diff[j][hStart] += B;
				diff[j][hEnd] -= B;
			}
		}
		
//		for (int row=0; row<M; row++) {
//			for (int col=0; col<=N; col++) {
//				System.out.print(diff[row][col] + " ");
//			}
//			System.out.println();
//		}
		
		for (int row=0; row<M; row++) {
			int value = 0;
			for (int col=0; col<=N; col++) {
				value += diff[row][col];
				if (value == max) {
					count++;
				}
				else if (value > max) {
					max = value;
					count = 1;
				}
			}
		}
		
		System.out.println(max);
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
}
