package second;

import java.util.Scanner;

public class TwoPointerSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		
		int[] nums = new int[N];
		
		for (int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		int left = 0;
		int right = 1;
		int sum = nums[0];
		while (left < N && right < N) {
			
			if (sum + nums[right] <= X) {
				sum += nums[right];
				right++;
				continue;
			}
			if (sum == X) {
				break;
			}
			
			sum -= nums[left];
			left++;
			
		}
		
		
		if (sum == X) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

}
