package second;

import java.util.Arrays;
import java.util.Scanner;

public class CyclopianSuits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		int [] A = new int [1001];
		int [] B = new int [1001];
		
		A[N]++;
		B[N]++;
		Arrays.sort(B);
        int max = B[1000];
        
        int count = 0;
		for (int i=1000; i>=0; i--){
			if (B[i]==max){
				count++;
			}
			else{
				break;
			}
			
		}
		System.out.println(count);
		//use A to find out the biggest number
		for (int i=0; i<1001; i++){
			if (A[i]==max){
				System.out.println(i);
			}
		}
	}
}


