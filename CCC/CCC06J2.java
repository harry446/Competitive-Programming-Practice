package second;

import java.util.Scanner;

public class CCC06J2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		int m = SC.nextInt();
		int n = SC.nextInt();

		int count = 0;
		for (int i=1; i<m; i++){
			for (int j=m; j<1; j--){
				if (i+j == 10){
					count++;
				}
			}
		}

		System.out.println(count);

	}

}
