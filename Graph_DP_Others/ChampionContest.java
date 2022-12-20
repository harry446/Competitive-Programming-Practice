package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ChampionContest {
	
	public static class Pair implements Comparable<Pair> {
		int val, index;
		public Pair (int val, int index) {
			this.val = val;
			this.index = index;
		}
		
		public int compareTo(Pair other) {
			if (val > other.val) {
				return 1;
			}
			else {
				return -1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		String[] S1 = br.readLine().split(" ");
		int n = Integer.parseInt(S1[0]);
		int k = Integer.parseInt(S1[1]);
		int[] value = new int[n];
		int[] win = new int[n];
		int[] position = new int[n];
		Map<Integer, LinkedList<Integer>> friends = new HashMap<>();
		
		
		String[] S2 = br.readLine().split(" ");
		for (int i=0; i<n; i++ ) {
			value[i] = Integer.parseInt(S2[i]);
			position[i] = i;
		}
		
		for (int i=0; i<k; i++) {
			String[] S3 = br.readLine().split(" ");
			int a = Integer.parseInt(S3[0]);
			int b = Integer.parseInt(S3[1]);
			
			if (a>b) {
				if (!friends.containsKey(a)) {
					friends.put(a, new LinkedList<>());
				}
				friends.get(a).add(b);
			}
			else {
				if (!friends.containsKey(b)) {
					friends.put(b, new LinkedList<>());
				}
				friends.get(b).add(a);
			}
		}
		
		
		for (int i=0; i<n-1; i++) {
			for (int j=0; j<n-i-1; j++) {
				if (value[j] > value[j+1]) {
					int temp = value[j];
					value[j] = value[j+1];
					value[j+1] = temp;
					int temp2 = position[j];
					position[j] = position[j+1];
					position[j+1] = temp2;
				}
			}
		}
		
		
//		for (int i=0; i<n; i++) {
//			System.out.println(value[i] + " ");
//			if (friends.containsKey(i+1)) {
//				System.out.println(friends.get(i+1));
//			}
//		}
//		System.out.println();
//		
//		System.out.println("v" + value[2]);
//		System.out.println("v" + value[1]);
		
		win[0] = 0;
		for (int i=1; i<n; i++) {
			int total = i;
			if (friends.containsKey(i+1)) {
				total -= friends.get(i+1).size();
			}
			for (int j=i; j>0; j--) {
				if (value[j] == value[j-1]) {
					total--;
				}
				else {
					break;
				}
			}
			
			if (total < 0) {
				total = 0;
			}
			win[i] = total;
			
		}
		
		
		
		
		for (int i=0; i<n-1; i++) {
			for (int j=0; j<n-i-1; j++) {
				if (position[j] > position[j+1]) {
					int temp = win[j];
					win[j] = win[j+1];
					win[j+1] = temp;
//					int temp2 = position[j];
//					position[j] = position[j+1];
//					position[j+1] = temp2;
				}
			}
		}
		
		for (int i=0; i<n; i++) {
			System.out.print(win[i] + " ");
		}
	}

}
