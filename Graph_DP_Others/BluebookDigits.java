package second;

import java.util.Scanner;

public class BluebookDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		int T = SC.nextInt();

		for (int i=0; i<T; i++){
			int number = SC.nextInt();
			String S = Math.abs(number)+"";

			System.out.println(S.length());
		}


	}

}
