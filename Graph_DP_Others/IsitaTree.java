package second;

import java.util.*;

public class IsitaTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		int count1 = 0;
		int count2 = 0;
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				if (sc.nextInt() == 1) {
					count2++;
					count1 |= (1<<i);	
				}
			}
		}
		
		if (count1 == 15 && count2 == 6) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		
	}

}
