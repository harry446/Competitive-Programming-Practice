package second;

import java.util.Scanner;

public class TLE16Contest6MockCCCJ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		int M = SC.nextInt();
		
		int[] action = new int[5000];
		int A = SC.nextInt();
		for (int i=0; i<A; i++){
			int X = SC.nextInt();
			int Y = SC.nextInt();
			action[X] = Y;              //store actions into array
		}
		
		int second = 0;
		while (true){
			second++;
			N--;   //Use one paper
			if (N<0){
				System.out.println("The printer melts at " + second + " second(s)");
				break;
			}
			
			N = N + action[second];
			if (N<0){
				System.out.println("The printer melts at " + second + " second(s)");
				break;
			}
			else if (N>M){
				System.out.println("The printer jams at " + second + " second(s)");
				break;
			}
		}
		
	}

}
