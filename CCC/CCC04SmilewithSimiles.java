package second;
import java.util.Scanner;
public class CCC04SmilewithSimiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		int n= SC.nextInt();
		String[] A = new String[n];
		int m = SC.nextInt();
		String[] N = new String[m];
		
		//store n(adj) into array A
		for (int i=0; i<n; i++){
			A[i] = SC.next();
		}
		//store m(noun) into array N
		for (int i=0; i<m; i++){
			N[i] = SC.next();
		}
		
		//use nested for loop to do the combinations
		for (int i=0; i<n; i++){
			for (int i1=0; i1<m; i1++){
				System.out.println(A[i]+" as "+N[i1]);
			}
		}
		
		
	}

}
