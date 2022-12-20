package second;

import java.util.Scanner;

public class MooseContest19HowPerfect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		double n = SC.nextInt();
		
		if (Math.sqrt(n)%1 == 0 && Math.pow(n, 1.0/3.0)%1 == 0) {
			System.out.println("Perfectly Perfect");
		}
		else if (Math.sqrt(n)%1 == 0) {
			System.out.println("Somewhat Perfect");
		}
		else if (Math.pow(n, 1.0/3.0)%1 == 0) {
			System.out.println("Kinda Perfect");
		}
		else {
			System.out.println("Not Perfect At All");
		}
		
		System.out.println(Math.pow(n, 1.0/3.0));
		
	}

}
