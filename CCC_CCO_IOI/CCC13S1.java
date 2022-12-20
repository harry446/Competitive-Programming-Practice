package second;

import java.util.Arrays;
import java.util.Scanner;

public class CCC13S1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int begin = SC.nextInt();
		while (true){
			begin++;
			if (isD(begin)){
				System.out.println(begin);
				break;
			}
		}
		
	}

	public static boolean isD(int N){
		String S = ""+N;
		char[] A = S.toCharArray();
		Arrays.sort(A);
		for (int i=0; i<A.length-1; i++){
			if (A[i] == A[i+1]){
				return false;
			}
		}
		return true;
	}
}
