package second;

import java.util.Scanner;

public class CCC19J3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int N = SC.nextInt();
		
		for (int i=0; i<N; i++) {
			String S = SC.next();
			System.out.println(Encoder(S));
			
		}
	}
	
	public static String Encoder(String S) {
		String Code = "";
		char c = ' ';
		int count = 0;
		
		for (int i=0; i<S.length(); i++) {
			if (S.charAt(i) != c) {
				if (count >= 1) {
					Code += count + " " + c + " ";
					c = S.charAt(i);
					count = 1;
				}
				else {
					c = S.charAt(i);
					count++;
				}
			
			}
			
			else if (S.charAt(i) == c) {
				count++;
			}
			
			if (i+1 == S.length()) {
				Code += count + " " + c;
			}
		}
		
		return Code;
		
	}
	
	

}
