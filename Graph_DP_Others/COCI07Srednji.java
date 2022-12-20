package second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class COCI07Srednji {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner SC = new Scanner (System.in);
		
		Map<Integer, Integer> map1 = new HashMap<>();	//For going down
		Map<Integer, Integer> map2 = new HashMap<>();	//For going up
		int N = SC.nextInt();
		int B = SC.nextInt();
		int[] nums = new int[N];
		int BLocation = -1;
		
		for (int i=0; i<N; i++) {
			nums[i] = SC.nextInt();
			if (nums[i] == B) {
				BLocation = i;
			}
		}
		
		//going down
		int cur = 0;
		for (int i=BLocation-1; i>=0; i--) {
			if (nums[i] > B) {
				cur++;
			}
			else {
				cur--;
			}
			
			if (!map1.containsKey(cur)) {
				map1.put(cur, 1);
			}
			else {
				map1.put(cur, map1.get(cur)+1);
			}
		}
		
		//going up
		cur = 0;
		for (int i=BLocation+1; i<N; i++) {
			if (nums[i] > B) {
				cur++;
			}
			else {
				cur--;
			}
			
			if (!map2.containsKey(cur)) {
				map2.put(cur, 1);
			}
			else {
				map2.put(cur, map2.get(cur)+1);
			}
		}
		
		int answer = 1;
		for (int key : map2.keySet()) {
			if (map1.containsKey(-1*key)) {
				answer += map1.get(-1*key) * map2.get(key);
			}
		}
		
		if (map1.containsKey(0)) {
			answer += map1.get(0);
		}
		if (map2.containsKey(0)) {
			answer += map2.get(0);
		}
		
		System.out.println(answer);
		
	}

}
