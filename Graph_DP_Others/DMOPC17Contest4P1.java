package second;

import java.util.Scanner;

public class DMOPC17Contest4P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		int Q = SC.nextInt();
		
		int total = 0;
		for (int i=0; i<Q; i++) {
			int X = SC.nextInt();
			int Y = SC.nextInt();
			
			total += (Y-X);
		}
		
		System.out.println(total + "T");
	}

}
