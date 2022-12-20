package second;

import java.util.Scanner;

public class ValentineDay18J1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
	
		int N = SC.nextInt();
		int max = 0;
		
		for (int i=0; i<N; i++){
			int A = SC.nextInt();
			
			if (A>max){
				max = A;
			}
		}
		
		if (max/1000>10){
			System.out.println("Something is wrong with these cuteness values");
		}
		else if (max/1000>1 && max/1000<=10){
			System.out.println("Cuteness by definition is similarity to Cactus");
		}
		else if (max/1000<=1){
			System.out.println("Cuteness by definition is similarity to Carol");
		}
	}

}
