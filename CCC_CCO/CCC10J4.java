package second;

import java.util.Scanner;

public class CCC10J4 {

	static int N;
	static int[] nums, diff;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		while (true) {
			N = SC.nextInt();
			if (N == 0) {
				break;
			}
			nums = new int[N];
			diff = new int[N-1];
			for (int i=0; i<N; i++) {
				nums[i] = SC.nextInt();
			}
			for (int i=0; i<N-1; i++) {
				diff[i] = nums[i+1] - nums[i];
			}
			
			System.out.println(loop());
		}
		
	}
	
	public static boolean search(int len) {
		for (int i=0; i<N-len-1; i++) {
			if (diff[i] != diff[i+len]) {
				return false;
			}
		}
		return true;
	}
	
	public static int loop() {
		for (int i=1; i<N; i++) {
			if (search(i)) {
				return i;
			}
		}
		return N;
	}

}
