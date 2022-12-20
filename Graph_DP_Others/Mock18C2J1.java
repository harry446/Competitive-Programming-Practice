package second;
import java.util.Scanner;
public class Mock18C2J1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		String S = SC.nextLine();
		
		String c1 = ""+S.charAt(0);
		String c2 = ""+S.charAt(4);
		String c3 = ""+S.charAt(8);
		int a = Integer.parseInt(c1);
		int b = Integer.parseInt(c2);
		int c = Integer.parseInt(c3);
		
		if (a+b == c){
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
	}

}
