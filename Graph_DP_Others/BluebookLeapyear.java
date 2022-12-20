package second;
import java.util.Scanner;
public class BluebookLeapyear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);

		int N = SC.nextInt();
		
		for (int i=0; i<N; i++){
			
			int year = SC.nextInt();
			
			if (year%400 == 0){
				System.out.println(1);
			}
			else if(year%100 == 0){
				System.out.println(0);
			}
			else if (year%4 == 0){
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}

		}

		













	}

}
