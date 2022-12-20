package second;

import java.util.Scanner;

public class BluebookChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		int amount = SC.nextInt();
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int cents = 0;
		int amountleft = 0;

		quarters = amount/25;
		amountleft = amount%25;
		dimes = amountleft/10;
		amountleft = amountleft%10;
		nickels = amountleft/5;
		amountleft = amountleft%5;
		cents = amountleft/1;

		System.out.print(amount+" cents requires ");
		if (quarters !=  0 && quarters < 2){
			System.out.print(quarters+" quarter, ");
		}

		if (quarters != 0 && quarters > 1){
			System.out.print(quarters+" quarters, ");
		}

		if (dimes != 0 && dimes < 2){
			System.out.print(dimes+" dime, ");
		}

		if (dimes != 0 && dimes > 1){
			System.out.print(dimes+" dimes, ");
		}

		if (nickels != 0 && nickels < 2){
			System.out.print(nickels+" nickel, ");
		}

		if (nickels != 0 && nickels > 1){
			System.out.print(nickels+" nickels, ");
		}

		if (cents != 0 && cents <2){
			System.out.println(cents+" cent. ");
		}

		if (cents != 0 && cents > 1){
			System.out.println(cents+" cents. ");
		}


	}

}
