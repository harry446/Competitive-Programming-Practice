package second;

import java.util.Scanner;

public class CCC1718J4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		String S = SC.nextLine();
		
		int indexO = S.indexOf("o");
		int indexU = S.indexOf("u");
		int indexR = S.indexOf("r");
		
		if (indexO!=-1 && indexO<indexU && indexU<indexR){
			System.out.println("Y");
		}
		else {
			System.out.println("N");
		}
	}

}
