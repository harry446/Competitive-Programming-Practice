package second;

import java.util.Scanner;

public class AtCoderIHateFactorization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		int X = sc.nextInt();
		
		for (int i=-120; i<=120; i++) {
			for (int j=-120; j<=120; j++) {
				if (Math.pow(i, 5) - Math.pow(j, 5) == X) {
					System.out.println(i + " " + j);
					return;
				}
			}
		}
	}

}
