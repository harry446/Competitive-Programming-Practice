package second;
import java.util.Scanner;
public class CCC14J1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int A = SC.nextInt();
		int B = SC.nextInt();
		int R = SC.nextInt();
		
		if (A>R){
			System.out.println("Bob overdoses on day 1.");
		}
		else if (A/2+B > R){
			System.out.println("Bob overdoses on day 2.");
		}
		else{
			System.out.println("Bob never overdoses.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
