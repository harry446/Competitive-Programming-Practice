package second;

import java.util.Scanner;

public class CCC01J1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int H = SC.nextInt();
		//forwards
		for (int C=1; C<=H; C=C+2){
			for (int i=0; i<C; i++){
				System.out.print("*");
			}
			for (int i=0; i<H*2-C*2; i++){
				System.out.print(" ");
			}
			for (int i=0; i<C; i++){
				System.out.print("*");
			}
			System.out.println();
		}
		//backwards
		for (int C=H; C>0; C=C-2){
			for (int i=0; i<C; i++){
				System.out.print("*");
			}
			for (int i=0; i<H*2-C*2; i++){
				System.out.print(" ");
			}
			for (int i=0; i<C; i++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
