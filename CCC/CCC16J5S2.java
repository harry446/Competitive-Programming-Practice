package second;

import java.util.Arrays;
import java.util.Scanner;

public class CCC16J5S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int Q = SC.nextInt();
		int N = SC.nextInt();
		int[] City1 = new int[N];
		int[] City2 = new int[N];
		
		for (int i=0; i<N; i++){
			City1[i] = SC.nextInt();
		}
		for (int i=0; i<N; i++){
			City2[i] = SC.nextInt();
		}
		
		Arrays.sort(City1);
		Arrays.sort(City2);
		
		int total = 0;
		if (Q==1){
			for (int i=0; i<N; i++){
				if (City1[i]>=City2[i]){
					total += City2[i];
				}
				else {
					total += City1[i];
				}
			}
		}
		else {
			for (int i=0; i<N; i++){
				if (City1[i]>=City2[N-1-i]){
					total += City1[i];
				}
				else {
					total += City2[N-1-i];
				}
			}
		}
		System.out.println(total);
	}

}
