package second;

import java.util.Scanner;

public class BitWiseOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int N = SC.nextInt();
		
		int count = 0;
//		for (int i=0; i<32; i++) {
//			if ((N&(1<<i)) != 0) {
//				count++;
//			}
//		}
		
		while (N > 0) {
			if ((N&1) != 0) {
				N = N>>1;
			}
		}
		System.out.println(count);
		
		
		//change the mth index to 1
		int a = 5;
		int m = 2; //index
		a = a | (1<<(m-1));
		System.out.println(a);
		
//		System.out.println(N%2);
	}

}
