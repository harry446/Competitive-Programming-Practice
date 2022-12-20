package second;

import java.io.*;
import java.util.*;

public class WC15FinalsS2 {

	static int[] cows, troughs;
	static int N, M, K;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		N = readInt();
		M = readInt();
		K = readInt();
		cows = new int[N];
		troughs = new int[M];
		
		for (int i=0; i<N; i++) {
			cows[i] = readInt();
		}
		for (int i=0; i<M; i++) {
			troughs[i] = readInt();
		}
		
		Arrays.sort(cows);
		Arrays.sort(troughs);
		
		int low = 1;
		int high = N+1;	
		
		while (low < high) {
			int mid = (low + high)/2;
			
			if (valid(mid)) {
				high = mid;		//remove right half of the array (keeping mid)
			}
			else {
				low = mid+1;	//+1 to not include the mid value (because it is 0)
			}
		}
		
		if (low == N+1) {	//N+1 because it is impossible (will never be reached normally, unless problem is impossible)
			System.out.println(-1);
		}
		else {
			System.out.println(low);
		}
		
	}
	
	public static boolean valid (int x) {	//valid x = whether we can successfully fill the trough with a maximum of x cows
		boolean flag = true;
		int curCow = 0;
		int curTrough = 0;
		int curCowNum = 0;
		
		while (true) {
			if (curCow >= N) {	//Finish processing all cows, return true
				break;
			}
			if (curCow < N && curTrough >= M) {	//There are still cows left to process, but not enough troughs (each trough with x cows)
				flag = false;
				break;
			}
			if (curCowNum < x && troughs[curTrough] <= cows[curCow] && troughs[curTrough] >= cows[curCow] - K) {		//curCowNum is acceptable, within the height range, assign.
				curCowNum++;
				curCow++;
			}
			else {
				curTrough++;
				curCowNum = 0;
			}
		}
		
		return flag;
		
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
