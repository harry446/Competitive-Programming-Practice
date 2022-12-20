package second;

import java.util.Scanner;

public class CCC11S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
	    int N = SC.nextInt();
	    int count = 0;
	    
	   String[] Y = new String[N];
	   for (int i=0; i<N; i++){
		   Y[i] = SC.next();
	   }
	   
	   String[] A = new String[N];
	   for (int i=0; i<N; i++){
		   A[i] = SC.next();
	   }
	   
	   for (int i=0; i<N; i++){
		   if (Y[i].equals(A[i])){
			   count++;
		   }
	   }
	   System.out.println(count);
	}

}
