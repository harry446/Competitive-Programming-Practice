package second;

import java.io.*;
import java.util.*;

public class AnAnimalContest3P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int K = readInt();
		int D = readInt();
		int[] nums = new int[D];
		
		for (int i=0; i<D; i++) {
			nums[i] = readInt();
		}
		Arrays.sort(nums);
		
		if (D == 1) {
			if (nums[0] == 0) {
				System.out.println(-1);
			}
			else {
				for (int i=0; i<K; i++) {
					System.out.print(nums[0]);
				}
				System.out.println();
			}
			return;
		}
		
		if (K == 1) {
			if (nums[0] != 0) {
				System.out.println(nums[0]);
			}
			else {
				System.out.println(nums[1]);
			}
			return;
		}
		
		if (nums[0] == 0) {
			System.out.print(nums[1]);
			for (int i=1; i<K-1; i++) {
				System.out.print(nums[0]);
			}
			System.out.println(nums[1]);
			return;
		}
		
		for (int i=0; i<K; i++) {
			System.out.print(nums[0]);
		}
		System.out.println();
		
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
