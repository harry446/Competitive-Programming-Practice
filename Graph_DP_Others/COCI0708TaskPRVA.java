package second;

import java.util.LinkedList;
import java.util.Scanner;

public class COCI0708TaskPRVA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		String S = SC.nextLine();
		String[]A = S.split("#");
		LinkedList<String> l = new LinkedList<String>();
		
		for (int i=0; i<A.length; i++){
			String s = A[i];
			if (s.length() >=2){
				l.add(s);
			}
		}
		System.out.println(l);
		
		
	}

}
