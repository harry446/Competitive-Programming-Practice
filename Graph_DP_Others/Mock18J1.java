package second;

import java.util.Scanner;

public class Mock18J1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		String S = SC.nextLine();
		
		int N = 0;
		
		while(true){
			N++;
			if (!S.contains("0")){
				System.out.println(N);
				break;
			}
		}
	}

}
