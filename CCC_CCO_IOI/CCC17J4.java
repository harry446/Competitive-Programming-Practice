package second;

import java.util.Scanner;

public class CCC17J4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int D = SC.nextInt();
		
		if (D >= 720){
			D = 720;
		}
		int h = 12;
		int m = 0;
		int count = 0;
		
		for (int i=0; i<D; i++){
			m++;
			if (m>=60){
				m = m - 60;
				h++;
			}
			if (h>=13){
				h = h - 12;
			}
			String S = "";
			if (m>9){
				S = S + h + m;
			}
			else{
				S = S + h + "0" + m;
			}
			if(isArth(S)){
				count++;
			}
		}
		System.out.println(count);
		
		
	}
	
	public static boolean isArth(String S){
		boolean flag = true;
		for (int i=0; i<S.length()-1; i++){
			if (S.charAt(i+1)-S.charAt(i) != S.charAt(1)-S.charAt(0)){
				flag = false;
				break;
			}
		}
		return flag;
		
	}

}
