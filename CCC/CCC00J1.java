package second;

import java.util.Scanner;

public class CCC00J1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int begin = SC.nextInt();
		int days = SC.nextInt();
		System.out.println("Sun Mon Tue Wed Thr Fri Sat");
		
		for (int i=0; i<=days; i++){
			if (i<begin){
				System.out.print("    ");
			}
			else if(i<12){
				System.out.print("  "+(i-begin+1)+" ");
			}
			else{
				System.out.print(" "+(i-begin+1)+" ");
			}
			if (i%7==0){
				System.out.println();
			}
		}

	}

}
