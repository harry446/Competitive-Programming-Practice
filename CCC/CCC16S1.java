package second;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CCC16S1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		String S1 = SC.next();
		String S2 = SC.next();
		if (S1.length() != S2.length()) {
			System.out.println("N");
			return;
		}
		Map<Character, Integer> A1 = new HashMap<>();
		Map<Character, Integer> A2 = new HashMap<>();
		
		for (int i=0; i<S1.length(); i++) {
			if (!A1.containsKey(S1.charAt(i))) {
				A1.put(S1.charAt(i), 0);
			}
			A1.put(S1.charAt(i), A1.get(S1.charAt(i))+1);
			
			
			if (S2.charAt(i) == '*') {
				continue;
			}
			if (!A2.containsKey(S2.charAt(i))) {
				A2.put(S2.charAt(i), 0);
			}
			A2.put(S2.charAt(i), A2.get(S2.charAt(i))+1);
			
		}	
		
		for (int i=0; i<S1.length(); i++) {
			if (S2.charAt(i) != '*') {
				if (!A1.containsKey(S2.charAt(i))) {
					System.out.println("N");
					return;
				}
				if (A1.get(S2.charAt(i)) < A2.get(S2.charAt(i))) {
					System.out.println("N");
					return;
				}
			}
		}
		
		System.out.println("A");
	}

}
