package second;

import java.util.Scanner;

public class CCC09J2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int troutP = SC.nextInt();
		int pikeP = SC.nextInt();
		int pickerelP = SC.nextInt();
		int totalP = SC.nextInt();
		
		int maxTrout = totalP/troutP;
		int maxPike = totalP/pikeP;
		int maxPickerel = totalP/pickerelP;
		
		int count = 0;
		for (int t=0; t<=maxTrout; t++){
			for (int p=0; p<=maxPike; p++){
				for (int b=0; b<=maxPickerel; b++){
					if (t*troutP+p*pikeP+b*pickerelP <= totalP && t*troutP+p*pikeP+b*pickerelP != 0){
						count++;
						System.out.println(t+" Brown Trout, "+p+" Northern Pike, "+b+" Yellow Pickerel");
					}
				}
			}
		}
	}

}
