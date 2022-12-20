package second;

import java.util.Scanner;

public class CCC03S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		int N = SC.nextInt();
		String[] words = new String[4];
		SC.nextLine();
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<4; j++) {
				String[] temp = SC.nextLine().split(" ");
				String temp2 = temp[temp.length-1].toLowerCase();
				for (int k=temp2.length()-1; k>=0; k--) {
					if (temp2.charAt(k) == 'a' || temp2.charAt(k) == 'e' || temp2.charAt(k) == 'i' || temp2.charAt(k) == 'o' || temp2.charAt(k) == 'u') {
						temp2 = temp2.substring(k);
						break;
					}
				}
				words[j] = temp2;
			}
			
			if (words[0].equals(words[1]) && words[1].equals(words[2]) && words[2].equals(words[3])) {
				System.out.println("perfect");
			}
			else if (words[0].equals(words[1]) && words[2].equals(words[3])) {
				System.out.println("even");
			}
			else if (words[0].equals(words[2]) && words[1].equals(words[3])) {
				System.out.println("cross");
			}
			else if (words[0].equals(words[3]) && words[1].equals(words[2])) {
				System.out.println("shell");
			}
			else {
				System.out.println("free");
			}
			
			
		}
		
//		for (int i=0; i<4; i++) {
//			System.out.println(words[i]);
//		}
	}

}
