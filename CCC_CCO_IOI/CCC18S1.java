package second;

import java.util.Arrays;
import java.util.Scanner;

public class CCC18S1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		int N = SC.nextInt();
		int[] nums = new int[N];
		double[] dist = new double[N];
		
		for (int i=0; i<N; i++) {
			nums[i] = SC.nextInt();
		}
		
		Arrays.sort(nums);
		Arrays.fill(dist, (double)Integer.MAX_VALUE);
		
		for (int i=1; i<N-1; i++) {
			dist[i] = (double)(nums[i]-nums[i-1])/2 + (double)(nums[i+1]-nums[i])/2;
		}
		
		Arrays.sort(dist);
//		dist[0] = 1.0*Math.round(dist[0]*10)/10.0;
		System.out.printf("%.1f", dist[0]);
	}

}
