package second;

import java.util.Scanner;

public class CCC12S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		String S = sc.next();
		
		int total = 0;
		int n1 = 0, n2 = 0;
		for (int i=S.length()-2; i>=0; i-=2) {
			n1 = S.charAt(i)-'0';
			n2 = convert(S.charAt(i+1));
			
			if (n1 != 0) {
				if (i+3 < S.length() && convert(S.charAt(i+3)) > n2) {
					total -= n1 * n2;
				}
				else {
					total += n1 * n2;
				}
			}
					
		}

		System.out.println(total);
	}
	
	public static int convert (char c) {
		if (c == 'I') {
			return 1;
		}
		else if (c == 'V') {
			return 5;
		}
		else if (c == 'X') {
			return 10;
		}
		else if (c == 'L') {
			return 50;
		}
		else if (c == 'C') {
			return 100;
		}
		else if (c == 'D') {
			return 500;
		}
		else {
			return 1000;
		}
	}

}
