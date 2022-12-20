package second;

import java.util.*;

public class DequePractice {

	static int[] nums;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Given an array of size N  and the size value X, please output all the minimum of the subarray whose size is X. 
		//(sliding windows)
		
		Scanner sc = new Scanner (System.in);
		
		int N = sc.nextInt();
		nums = new int[N];
		for (int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		int X = sc.nextInt();		//target size (window size) of the subarray
		
		
		minValueInEachSubarray(N, nums, X);
		
	}
	
	public static void minValueInEachSubarray (int N, int nums[], int X) {
		Deque<Integer> window = new LinkedList<Integer>();
		int i;
		for (i=0; i<X; i++) {
			//for every element, the previous larger elements are useless so remove them from the window
			while (!window.isEmpty() && nums[i] <= nums[window.peekLast()]) {
				window.removeLast();
			}
			window.addLast(i);
		}
		for (; i<N; i++) {
			//the element at the front of the deque is the smallest element of the previous window
			System.out.println(nums[window.peek()]);
			
			while (!window.isEmpty() && window.peek() <= i-X) {
				window.removeFirst();
			}
			window.addLast(i);
		}
		System.out.println(nums[window.peek()]);
	}

}
