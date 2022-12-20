package second;
import java.util.Scanner;
public class CCC14J2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		int T = SC.nextInt();
		String[] A = new String[T];
		for (int i=0; i<T; i++){
			String S = SC.nextLine();
			A[i] = S.trim();//trim() removes beginning and ending spaces from String.
		}

		for (int i=0; i<A.length; i++){
			if (i%2==0){
				System.out.print(A[A.length-1-i]);
			}
			else{
				String S = A[A.length-1-i];
				for (int j=0; j<S.length(); j++){
					System.out.print(S.charAt(S.length()-1-j));
				}
			}
		}


	}
}
