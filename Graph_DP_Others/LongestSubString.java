package second;

import java.util.*;

public class LongestSubString {
	
	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		String S1 = SC.next();
		String S2 = SC.next();
		
//		String S1 = "abcedfasggsaf";
//		String S2 = "uaffkmgltseakggf";
		
		System.out.println(longestSubString(S1, S2));
		
	}
	
//	public static int longestSubString (String S1, String S2) {		
//		if (S1.length() == 0 || S2.length() == 0) {
//			return 0;
//		}
//		
//		if (S1.charAt(0) == S2.charAt(0)) {
//			return longestSubString(S1.substring(1), S2.substring(1)) + 1;
//		}
//		
//		int temp1 = longestSubString(S1.substring(1), S2);
//		int temp2 = longestSubString(S1, S2.substring(1));
//		return Math.max(temp1, temp2);
//		
//	}
	
	//with DP, top down, using map (much faster)
	public static int longestSubString (String S1, String S2) {
		if (S1.length() == 0 || S2.length() == 0) {
			return 0;
		}
		
		String key = S1 + "#" + S2;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		
		if (S1.charAt(0) == S2.charAt(0)) {
			return longestSubString(S1.substring(1), S2.substring(1)) + 1;
		}
		
		int temp1 = longestSubString(S1.substring(1), S2);
		int temp2 = longestSubString(S1, S2.substring(1));
		int max = Math.max(temp1, temp2);
		
		map.put(key, max);
		return max;
	}

}
