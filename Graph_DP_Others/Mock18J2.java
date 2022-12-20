package second;

import java.util.Scanner;

public class Mock18J2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		String S = SC.nextLine();

		boolean odd = true;
		for (int len=1; len<=S.length(); len++){
			for (int i=0; i<=S.length()-len; i++){
				String sub = S.substring(i, i+len);
				if (isPalindrome(sub)){
					if (sub.length()%2==0){
						odd = false;
						break;
					}
				}
			}
		}

		if (odd){
			System.out.println("Odd");
		}
		else{
			System.out.println("Even");
		}

	}

	public static boolean isPalindrome(String sub){
		boolean flag = true;
		for (int i=0; i<sub.length(); i++){
			char a = sub.charAt(i);
			char b = sub.charAt(sub.length()-1-i);
			if (a!=b){
				flag = false;
				break;
			}
		}
		return flag;
	}
}
