package second;

import java.util.Scanner;

public class CCC00J2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int START = SC.nextInt();
		int END = SC.nextInt();
		int count = 0;
		for (int i=START; i<=END; i++){
			String S = i+"";
			if (isRotate(S)){
				count++;
			}
		}
		System.out.println(count);
		
	}

	
	public static boolean isRotate(String S){
		for (int i=0; i<S.length(); i++){
			char forward = S.charAt(i);
			char backward = S.charAt(S.length()-1-i);
			if (forward  == backward){
				if (forward!='0' && forward!='1' && forward!='8'){
					return false;
				}
				else if (forward!='6' && forward!='9'){
					return false;
				}
				else if (forward=='6' && backward!='9'){
					return false;
				}
				else if (forward=='9' && backward!='6'){
					return false;
				}
			}
			
		}
		return true;
	}
	
	
}
