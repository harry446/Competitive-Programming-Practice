package second;

import java.util.Scanner;

public class Mock18J3S1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int K = SC.nextInt();
		int P = SC.nextInt();
		int X = SC.nextInt();
		
		int M = 1;
		while(true){
			if (function(K,P,X,M)<function(K,P,X,M+1)){
				System.out.printf("%.3f",function(K,P,X,M));
				break;
			}
			M++;
		}
	}

	public static double function(int K, int P, int X, int M){
		return M*X+K*P*1.0/M;
	}
}
