package second;
import java.util.Scanner;
public class BluebookCaculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		


		Scanner SC = new Scanner(System.in);
		int T = SC.nextInt();
		SC.nextLine();
		for (int i=0; i<T; i++) {
			String B1 = SC.nextLine();
			String N1 = SC.nextLine();
			String B2 = SC.nextLine();
			String N2 = SC.nextLine();
			String op = SC.nextLine();
			String BF = SC.nextLine();
			long b1 = Long.valueOf(N1, Integer.parseInt(B1));
			long b2 = Long.valueOf(N2, Integer.parseInt(B2));

			if (op.equals("+")) {
				System.out.println(Long.toString(b1+b2,Integer.parseInt(BF)));
			} 
			else if (op.equals("-")) {
				System.out.println(Long.toString(b1-b2,Integer.parseInt(BF)));
			} 
			else if (op.equals("*")) {
				System.out.println(Long.toString(b1*b2,Integer.parseInt(BF)));
			} 
			else if (op.equals("/")) {
				System.out.println(Long.toString(b1/b2,Integer.parseInt(BF)));
			}
			if (i!=T-1) {
				SC.nextLine();
			}
		}










	}

}
