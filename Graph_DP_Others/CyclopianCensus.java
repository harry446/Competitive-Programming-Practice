package second;

import java.util.Arrays;
import java.util.Scanner;

public class CyclopianCensus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		int [] ai = new int [N];
		for (int i=0; i<N; i++){
			ai[i] = SC.nextInt();
		}
		Arrays.sort(ai);
		int Q = SC.nextInt();
		
		for (int i=0; i<Q; i++){
			int qi = SC.nextInt();
			System.out.println(ai[qi-1]);
		}
		
	}

}
