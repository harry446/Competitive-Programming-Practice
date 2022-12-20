package second;

import java.util.Scanner;

public class HackerEarthCoronaVirus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int N = SC.nextInt();
		
		if (N < 0) {
			System.out.println("NO");
			return;
		}
		
		System.out.println("YES");
		
		int count = 0;
		for (int i=0; i<32; i++) {
			if ((N&(1<<i)) != 0) {
				count++;
			}
		}
		
		System.out.println(count);
		
		for (int i=0; i<32; i++) {
			if ((N&(1<<i)) != 0) {
				System.out.print(i + " ");
			}
		}
		
		
	}

}
