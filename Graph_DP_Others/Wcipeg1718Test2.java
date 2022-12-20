package second;

import java.util.Scanner;

public class Wcipeg1718Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		int B = SC.nextInt();
		
		int total = 0;
		for (int i=0; i<N; i++){
			int P = SC.nextInt();
			total = Total(P);
		}
        
		if (total >= B){
			System.out.println(total-B);
		}
		else{
			System.out.println("The budget will balance itself");
		}
		
	}

	public static int Total(int P){
		int total = 0; 
		total = total + P;
		return P;
	}
}
