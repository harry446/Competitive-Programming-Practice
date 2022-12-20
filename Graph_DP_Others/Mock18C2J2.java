package second;
import java.util.Scanner;
public class Mock18C2J2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		int n = SC.nextInt();
		int m = SC.nextInt();


		char [][]A = new char [n+1][m+1];

		for (int row=0; row<n; row++){
			String S = SC.next();
			A[row] = S.toCharArray();
		}
		
		for (int i=0; i<100; i++){
			for (int row=0; row<n; row++){
				for (int col=0; col<m; col++){
					if (A[row][col] == 'o' && A[row+1][col] == '.'){
						char temp = A[row][col];
						A[row][col] = A[row+1][col];
						A[row+1][col] = temp;
					}
				}
			}
		}

		for (int row=0; row<n; row++){
			for (int col=0; col<m; col++){
				System.out.print(A[row][col]);
			}
			System.out.println();
		}
	}

}
