package second;
import java.util.Scanner;
public class Cage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		int n = SC.nextInt();
		int A [] = {4,7,11,12,1,3};
		
		for (int i=0; i<n; i++){
			int N = SC.nextInt();
			A[N-1] = 0;
		}
		
		int sum = 0;
		for (int i=0; i<6; i++){
			sum = sum + A[i];
		}
		
		System.out.println(sum);
	}

}
