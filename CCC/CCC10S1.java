package second;

import java.util.Arrays;
import java.util.Scanner;

public class CCC10S1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		String[] names = new String[2];
        int bestValue = 0;
        int secondValue = 0;
		
        if (N == 0) {
        	return;
        }

		for (int i=0; i<N; i++){
			String name = SC.next();
			int R = SC.nextInt();
			int S = SC.nextInt();
			int D = SC.nextInt();
			int total = 2*R+3*S+D;
			
			if (total>bestValue){
				secondValue = bestValue;
				names[1] = names[0];
				bestValue = total;
				names[0] = name;
			}
			else if(total>secondValue){
				names[1] = name;
				secondValue = total;
			}
		}
		
		if (bestValue == secondValue) {
			Arrays.sort(names);
			for (int i=0; i<2; i++) {
				System.out.println(names[i]);
			}
		}
		else if (N == 1) {
			System.out.println(names[0]);
		}
		else {
			for (int i=0; i<2; i++) {
				System.out.println(names[i]);
			}
		}
		
		
			
		
		
		
		
		
		
		
	}

}
