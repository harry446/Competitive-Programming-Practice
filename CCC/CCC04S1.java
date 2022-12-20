package second;

import java.util.Scanner;

public class CCC04S1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int N = SC.nextInt();
		String[] words = new String[3];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<3; j++) {
				words[j] = SC.next();
			}
			
			for (int j=0; j<2; j++) {
				for (int k=0; k<2-j; k++) {
					if (words[k].length() > words[k+1].length()) {
						String temp = words[k];
						words[k] = words[k+1];
						words[k+1] = temp;
					}
				}
			}
			
			boolean flag = true; 
			if (words[0].equals(words[1].substring(0, words[0].length()))) {
				flag = false;
			}
			if (words[0].equals(words[1].substring(words[1].length()-words[0].length(), words[1].length()))) {
				flag = false;
			}
			
			if (words[0].equals(words[2].substring(0, words[0].length()))) {
				flag = false;
			}
			if (words[0].equals(words[2].substring(words[2].length()-words[0].length(), words[2].length()))) {
				flag = false;
			}
			
			if (words[1].equals(words[2].substring(0, words[1].length()))) {
				flag = false;
			}
			if (words[1].equals(words[2].substring(words[2].length()-words[1].length(), words[2].length()))) {
				flag = false;
			}
			
			if (flag) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
		
//		for (int i=0; i<3; i++) {
//			System.out.println(words[i]);
//		}
	}

}
