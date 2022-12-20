package second;

import java.util.Scanner;

public class CCC17J3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int a = SC.nextInt();
		int b = SC.nextInt();
		int c = SC.nextInt();
		int d = SC.nextInt();
		int t = SC.nextInt();
		
		int x = Math.abs(c-a);
		int y = Math.abs(b-d);
		if ((x+y)%2 !=0 || x+y<t){
			System.out.println("Y");
		}
		else if ((x+y)%2 == 0 && x+y>=t){
			System.out.println("N");
		}
	}

}
