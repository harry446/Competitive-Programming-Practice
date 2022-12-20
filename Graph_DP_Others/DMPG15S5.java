package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DMPG15S5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int M = readInt();
		byte[][] diff = new byte[N+2][N+2];
		
		for (int i=0; i<M; i++) {
			int x1 = readInt()+1;
			int y1 = readInt()+1;
			int x2 = x1 + readInt();
			int y2 = y1 + readInt();
			
			diff[x1][y1]++;
			diff[x2][y1]--;
			diff[x1][y2]--;
			diff[x2][y2]--;
		}
		
		int count = 0;
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				diff[i][j] = (byte)(diff[i][j] + diff[i-1][j] + diff[i][j-1] - diff[i-1][j-1]);
				if ((diff[i][j] & 1) > 0) {		//if odd number, last digit is 1 because all odd numbers have 2^0
					count++;
				}
			}
		}
		
		System.out.println(count);
		
//		for (int i=0; i<=N+1; i++) {
//			for (int j=0; j<=N+1; j++) {
//				System.out.printf("%2d ", diff[i][j]%2==0 ? 1:0);
//			}
//			System.out.println();
//		}
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
