package second;

import java.util.Scanner;

public class MoreArray {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		int [] A = new int[5];
		for (int i=0; i<5; i++){
			A[i] = SC.nextInt();
		}
		
		while(true){
			boolean swap = false;
			for (int i=0; i<A.length-1; i++){
				if (A[i]>A[i+1]){
					swap(A,i,i+1);
					swap = true;
				}
			}
			if (swap == false){
				break;
			}
		}



		for (int i=0; i<A.length; i++){
			System.out.print(A[i]);
		}

	}
	public static void swap(int[] A, int i1, int i2){
		int temp = A[i1];
		A[i1] = A[i2];
		A[i2] = temp;

	}

}
