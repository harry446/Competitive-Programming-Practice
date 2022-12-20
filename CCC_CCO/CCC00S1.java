package second;

import java.util.Scanner;

public class CCC00S1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		int N = SC.nextInt();
		int a = SC.nextInt();
		int b = SC.nextInt();
		int c = SC.nextInt();
		int count = 0;
		
		while (N > 0) {
			//Machine 1
			if (N <= 0) {
				break;
			}
			a++;
			N--;
			count++;
			if (a == 35) {
				a = 0;
				N += 30;
			}
			
			//Machine 2
			if (N <= 0) {
				break;
			}
			b++;
			N--;
			count++;
			if (b == 100) {
				b = 0;
				N += 60;
			}
			
			//Machine 3
			if (N <= 0) {
				break;
			}
			c++;
			N--;
			count++;
			if (c == 10) {
				c = 0;
				N += 9;
			}
		}
		
		System.out.println("Martha plays " + count + " times before going broke.");
		
	}

}
