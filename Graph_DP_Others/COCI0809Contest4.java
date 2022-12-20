package second;

import java.util.Scanner;

public class COCI0809Contest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		String S = SC.nextLine();
		String S1 = "";
		boolean flag = true;
		while (flag){
			for (int i=0; i<4; i++){
				if (S.charAt(i)>S.charAt(i+1)){
					S1 = S1 + S.charAt(i+1);
					S1 = S1 + S.charAt(i);
				}
			}
			System.out.println(S1);
			if (S1.equals("12345")){
				flag = false;
			}
		}
		
	}

}
