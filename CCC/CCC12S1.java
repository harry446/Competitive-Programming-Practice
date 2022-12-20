package second;

import java.util.Scanner;

public class CCC12S1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int J = SC.nextInt();
		
		int count = 0;
		for (int P3=1; P3<J; P3++){
			for (int P2=1; P2<P3; P2++){
				for (int P1=1; P1<P2; P1++){
					count++;
				}
			}
		}
		
		System.out.println(count);
		
		
		
	}

}
