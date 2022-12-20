package second;

import java.util.Scanner;

public class CCC16J3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);

		String S = SC.nextLine();

		for (int l=S.length(); l>=1; l--){
			for (int i=0; i<S.length()-l; i++){
				String A = S.substring(i, i+l);
				if (isPalindrome(A)){
					System.out.println(l);
					return;
				}
			}
		}
	}
	
	public static boolean isPalindrome(String S){
		boolean flag = true;
		for (int i=0; i<S.length(); i++){
			char forward = S.charAt(i);
			char backward = S.charAt(S.length()-1-i);
			if(forward != backward){
				return false;
			}
		}
		return true;
	}
}


