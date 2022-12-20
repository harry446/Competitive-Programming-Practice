package second;
import java.util.Scanner;
public class BluebookDays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);
		
		String days = " ";
		int T = SC.nextInt();
		int[] d = new int[12];
		d[0] = 31;
		d[1] = 28;
		d[2] = 31;
		d[3] = 30;
		d[4] = 31;
		d[5] = 30;
		d[6] = 31;
		d[7] = 31;
		d[8] = 30;
		d[9] = 31;
		d[10] = 30;
		d[11] = 31;
		SC.nextLine();
		for (int i=0; i<T; i++){
			String S = SC.nextLine();
			String []A = S.split("");
			int Y = Integer.parseInt(A[0]);
			int M = Integer.parseInt(A[1]);
			int D = Integer.parseInt(A[2]);
			
			for(int i1=0; i1<12; i1++){
				days = A[0] + A[1] + A[i-2] + D;
			}
		}
		
		
		
		
		
		
		
		
		
		
	}

}
