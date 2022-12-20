package second;

import java.util.Scanner;

public class CCC1718J3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int Acount = 0;
		int Bcount = 0;
		for (int i=0; i<7; i++){
			int A = SC.nextInt();
			int B = SC.nextInt();
			if (A>B){
				Acount++;
			}
			if (B>A){
				Bcount++;
			}
			if (Acount>=4 || Bcount>=4 || i>=7){
				System.out.println(Acount+" "+Bcount);
				break;
			}
		}
	}

}
