package second;

import java.util.Scanner;

public class COCI0708TaskCRNE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		int N = SC.nextInt();
		if (N%2==0){
			System.out.println((N/2+1)^2);
		}
		else if (N%2!=0){
			System.out.println((N/2+1)*(N/2+2));
		}
	}

}
