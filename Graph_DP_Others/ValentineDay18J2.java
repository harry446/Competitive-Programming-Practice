package second;

import java.util.Scanner;

public class ValentineDay18J2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		int N = SC.nextInt();

		int X = SC.nextInt();
		int Y = SC.nextInt();
		
		int total = 0;
		int count = 0;
		
			for (int i=X; i>=0; i=i-Y){
			total = total + i;
			count++;
			if (total*2>=N){
				System.out.println(count);
				break;
			}
			else if (i<=0 && total*2<N){
				System.out.println("RIP");
				break;
			}
		}
		
		
		
	}

}
