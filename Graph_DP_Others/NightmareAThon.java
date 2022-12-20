package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NightmareAThon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = readInt();
		int Q = readInt();
		int[] ratings = new int[N+1];
		int[] A = new int[N+1];
		int[] B = new int[N+2];
		int[] countA = new int[N+1];
		int[] countB = new int[N+2];
		
		for (int i=1; i<=N; i++) {
			ratings[i] = readInt();
		}
		
		
		for (int i=1; i<=N; i++) {
			
			if (A[i-1] < ratings[i]) {
				A[i] = ratings[i];
				countA[i] = 1;
			}
			else {
				A[i] = A[i-1];
				countA[i] = countA[i-1];
				if (ratings[i] == A[i]) {
					countA[i]++;
				}
			}
			
			if (B[N-i+2] < ratings[N-i+1]) {
				B[N-i+1] = ratings[N-i+1];
				countB[N-i+1] = 1;
			}
			else {
				B[N-i+1] = B[N-i+2];
				countB[N-i+1] = countB[N-i+2];
				if (ratings[N-i+1] == B[N-i+1]) {
					countB[N-i+1]++;
				}
			}
		}
		
//		for (int i=1; i<=N; i++) {
//			System.out.print(A[i] + " ");
//		}
//		System.out.println();
//		for (int i=1; i<=N; i++) {
//			System.out.print(B[i] + " ");
//		}
//		System.out.println("\n");
//		for (int i=1; i<=N; i++) {
//			System.out.print(countA[i] + " ");
//		}
//		System.out.println();
//		for (int i=1; i<=N; i++) {
//			System.out.print(countB[i] + " ");
//		}
//		System.out.println();
		
		for (int i=0; i<Q; i++) {
			int a = readInt();
			int b = readInt();
			
			if (A[a-1] > B[b+1]) {
				System.out.println(A[a-1] + " " + countA[a-1]);
			}
			else if (A[a-1] < B[b+1]) {
				System.out.println(B[b+1] + " " + countB[b+1]);
			}
			else {
				System.out.println(A[a-1] + " " + (countA[a-1]+countB[b+1]));
			}
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
	static char readCharacter () {
		return read().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}

	
}
