package second;

import java.util.Scanner;

public class CCC01S1 {

	
	static int total = 0;
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);

		String S = SC.nextLine();

		System.out.println("Cards Dealt                    Points");
		
		String c = "";
		String d = "";
		String h = "";
		String s = "";
		for (int i=0; i<S.length(); i++){
			c = S.substring(S.indexOf('C')+1, S.indexOf('D'));
			d = S.substring(S.indexOf('D')+1, S.indexOf('H'));
			h = S.substring(S.indexOf('H')+1, S.indexOf('S'));
			s = S.substring(S.indexOf('S')+1);
		}	

		
		
		
		System.out.println("Clubs " + c.replace(""," ").trim() + "                   " + PointTracker(c));
		System.out.println("Diamonds " + d.replace(""," ").trim() + "                    " +PointTracker(d));
		System.out.println("Hearts " + h.replace(""," ").trim() + "                             " +PointTracker(h));
		System.out.println("Spades " + s.replace(""," ").trim() + "                        " +PointTracker(s));
		
		System.out.println("                             Total " + total);
		
//		int CPoint = 0;
//		int DPoint = 0;
//		int HPoint = 0;
//		int SPoint = 0;
//
//		//Club
//		for (int j=0; j<c.length(); j++){
//			if (c.charAt(j) == 'A') {
//				CPoint += 4;
//			}
//			else if (c.charAt(j) == 'K') {
//				CPoint += 3;
//			}
//			else if (c.charAt(j) == 'Q') {
//				CPoint += 2;
//			}
//			else if (c.charAt(j) == 'J') {
//				CPoint += 1;
//			}
//		}
//
//		if (c.length() == 0) {
//			CPoint += 3;
//		}
//		else if (c.length() == 1) {
//			CPoint += 2;
//		}
//		else if (c.length() == 2) {
//			CPoint += 1;
//		}
//
	}

	
	
	
	public static int PointTracker(String A) {

		int Point = 0;
		for (int j=0; j<A.length(); j++){
			if (A.charAt(j) == 'A') {
				Point += 4;
			}
			else if (A.charAt(j) == 'K') {
				Point += 3;
			}
			else if (A.charAt(j) == 'Q') {
				Point += 2;
			}
			else if (A.charAt(j) == 'J') {
				Point += 1;
			}
		}

		if (A.length() == 0) {
			Point += 3;
		}
		else if (A.length() == 1) {
			Point += 2;
		}
		else if (A.length() == 2) {
			Point += 1;
		}

		total += Point;
		
		return Point;

	}

}
