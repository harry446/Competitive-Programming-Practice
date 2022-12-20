package second;

import java.util.Arrays;
import java.util.Scanner;

public class CyclopianCash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		int N = SC.nextInt();
		float [] S = new float [N];   //float is for decimal
		for (int i=0; i<N; i++){
			S[i] = SC.nextFloat();
			Arrays.sort(S);
		}
		if (N % 2 == 0){
			System.out.println(S[(N/2 + N/2-1)/2]);
		}
		else{
			System.out.println(S[N/2]);
		}
		
	}

}
