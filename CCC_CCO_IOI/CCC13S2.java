package second;

import java.util.Scanner;

public class CCC13S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int W = SC.nextInt();
		int N = SC.nextInt();
		int[] car = new int[N];
		
		boolean flag = false;
		int total = 0;
		for (int i=0; i<N; i++){
			car[i] = SC.nextInt();
		}
		
		for (int i=0; i<N; i++){
			if (i<4){
				total = total + car[i];
			}
			else {
				total = total + car[i] - car[i-4];
			}
			if (total>W){
				flag = true;
				System.out.println(i);
				break;
			}
		}
		
		if (!flag){
			System.out.println(N);
		}
		
		
	}

}
