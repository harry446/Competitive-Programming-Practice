package second;

import java.util.Arrays;

import java.util.Scanner;

public class TLE16Contest6MockCCCJ2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //                               Base,Exponent
	//System.out.println((long)Math.pow(2,10));
		
		Scanner SC = new Scanner(System.in);
		
		int F = SC.nextInt();
		int N = SC.nextInt();
		int[] price = new int[F];
		for (int i=0; i<F; i++){
			price[i] = SC.nextInt();
		}
		Arrays.sort(price);
		
		//price[0] is the least expensive one
		long sum = 0;
		for (int i=0; i<N; i++){
			sum = sum + (long)Math.pow(price[i], N-i);
		}
		System.out.println(sum);
	}

}
