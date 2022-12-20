package second;

import java.util.Scanner;

public class CCC08J3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		String S1 = "ABCDEF";
		String S2 = "GHIJKL";
		String S3 = "MNOPQR";
		String S4 = "STUVWX";
		String S5 = "YZ -.%";
		char[][] A = new char[5][6];

		A[0] = S1.toCharArray();
		A[1] = S2.toCharArray();
		A[2] = S3.toCharArray();
		A[3] = S4.toCharArray();
		A[4] = S5.toCharArray();

		String S = SC.nextLine();
		int BR = 0;
		int BC = 0;
		int ER = 0;
		int EC = 0;
		int total = 0;

		for (int i=0; i<S.length(); i++){
			char c = S.charAt(i);

			for (int row=0; row<5; row++){
				for (int col=0; col<6; col++){
					if (A[row][col] == c){
						ER = row;
						EC = col;
						break;
					}
				}
			}
			total = total +Math.abs(BR-ER)+Math.abs(BC-EC);
			BR = ER;
			BC = EC;
		}

		total = total +Math.abs(BR-4)+Math.abs(BC-5);
		System.out.println(total);


	}

}
