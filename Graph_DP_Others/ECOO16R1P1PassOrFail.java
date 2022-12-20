package second;

import java.util.Scanner;

public class ECOO16R1P1PassOrFail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		
		for (int i=0; i<10; i++) {
			int WT = SC.nextInt();
			int WA = SC.nextInt();
			int WP = SC.nextInt();
			int WQ = SC.nextInt();
			int count = 0;
			
			int N = SC.nextInt();
			//marks for each student
			for (int j=0; j<N; j++) {
				int ST = SC.nextInt();
				int SA = SC.nextInt();
				int SP = SC.nextInt();
				int SQ = SC.nextInt();
				
				if ((WT*ST + WA*SA + WP*SP + WQ*SQ) >= 5000) {	
					count++;
				}
			}	
			System.out.println(count);
		}
		
		
		
	}

}
