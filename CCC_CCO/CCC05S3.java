package second;

import java.io.*;
import java.util.*;

public class CCC05S3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int r = 1, c = 1;
		int preR, preC;
		int[][] product = new int[1024][1024];
		int[][] temp = new int[r][c];
		temp[0][0] = 1;
		
		for (int i=0; i<N; i++) {
			preR = r;
			preC = c;
			int curR = readInt();
			int curC = readInt();
			r = r*curR;
			c = c*curC;
			
			int[][] input = new int[curR][curC];
			for (int row=0; row<curR; row++) {
				for (int col=0; col<curC; col++) {
					input[row][col] = readInt();
				}
			}
			
//			int[][] temp = new int[preR][preC];
//			temp[0][0] = 1;
//			if (preR != 1 && preC != 1) {
//				for (int row=0; row<preR; row++) {
//					for (int col=0; col<preC; col++) {
//						temp[row][col] = product[row][col];
//					}
//				}
//				
////				for (int row2=0; row2<preR; row2++) {
////					for (int col2=0; col2<preC; col2++) {
////						System.out.print(temp[row2][col2] + " ");
////					}
////					System.out.println();
////				}
//			}

			for (int row=0; row<r; row++) {
				for (int col=0; col<c; col++) {
//					if (preR != 1 && preC != 1) {
////						product[row][col] = temp[row/curR][col/curC] * input[row%curR][col%curC];
//						product[row][col] = temp[row%preR][col%preC] * input[row/preR][col/preC];
//					}
//					else {
//						product[row][col] = input[row][col];
//					}
					product[row][col] = temp[row%preR][col%preC] * input[row/preR][col/preC];
				}
			}
			
			temp = new int[r][c];
			for (int row=0; row<r; row++) {
				for (int col=0; col<c; col++) {
					temp[row][col] = product[row][col];
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int maxR = Integer.MIN_VALUE;
		int minR = Integer.MAX_VALUE;
		for (int row=0; row<r; row++) {
			int rowSum = 0;
			for (int col=0; col<c; col++) {
				max = Math.max(max, product[row][col]);
				min = Math.min(min, product[row][col]);
				rowSum += product[row][col];
			}
			maxR = Math.max(maxR, rowSum);
			minR = Math.min(minR, rowSum);
		}
		
		int maxC = Integer.MIN_VALUE;
		int minC = Integer.MAX_VALUE;
		for (int col=0; col<c; col++) {
			int colSum = 0;
			for (int row=0; row<r; row++) {
				colSum += product[row][col];
			}
			maxC = Math.max(maxC, colSum);
			minC = Math.min(minC, colSum);
		}
		
		System.out.println(max);
		System.out.println(min);
		System.out.println(maxR);
		System.out.println(minR);
		System.out.println(maxC);
		System.out.println(minC);
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
