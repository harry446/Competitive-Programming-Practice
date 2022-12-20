package second;
import java.util.Scanner;
public class RGPC18P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		int M = SC.nextInt();
		
		if (N%M == 0){
			System.out.println("yes "+N/M);
		}
		else if (N%M !=0 ){
			System.out.println("no "+ N%M);
		}
	}

}
