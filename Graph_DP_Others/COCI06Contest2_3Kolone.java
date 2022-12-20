package second;

import java.util.Scanner;

public class COCI06Contest2_3Kolone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int N1 = SC.nextInt();
		int N2 = SC.nextInt();
		char[] row = new char[200];
		
		String row1 = SC.next();
		for (int i=0; i<N1; i++) {
			row[99-(i*2)] = row1.charAt(i);
		}
		
		String row2 = SC.next();
		int T = SC.nextInt();
		for (int i=0; i<N2; i++) {
//			row[101+i] = row2.charAt(i);
			row[100 + 2*i - 2*T] = row2.charAt(i);
		}
		
		
//		int T = SC.nextInt();	
//		for (int i=0; i<T; i++) {
//			row[100-(2*(T-i))] = row[101+i];
//			row[101+i] = 0;
//		}
		
		
		for (int i=0; i<200; i++) {
			if (row[i] != 0) {
				System.out.print(row[i]);
			}
		}
	}

}
