package second;

import java.util.Scanner;

public class TLE17Contest6P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int I = SC.nextInt();
		String s = SC.nextLine();
		
		char[] M = new char [I];
		
		for (int i=0; i<s.length(); i++) {
			M[i] = s.charAt(i);
		}
		boolean flag = false;
		
		for (int F=0; F<M.length; F++) {
			for (int S=0; S<M.length; S++) {
				if (M[F] != M[S]) {
					M[F] = 0;
					M[S] = 0;
				}
				else {
					flag = false;
				}
			}
			if (M[F] == 0) {
					flag = true;
				}
		}
		
//		for (int i=0; i<M.length; i++) {
//			System.out.println(M[i] + "HI");
//		}
		System.out.println(flag);
		if (flag) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

}
