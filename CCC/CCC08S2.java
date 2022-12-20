package second;

import java.util.Scanner;

public class CCC08S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int r  = SC.nextInt();
		
		while (r != 0) {
			int count = 0;
		
			for (int i=1; i<=r; i++) {
				int y = (int)Math.sqrt(r*r - i*i);
				count += y;
			}
		
			System.out.println((count+r)*4+1);
			r = SC.nextInt();
		}
		
	}

}
