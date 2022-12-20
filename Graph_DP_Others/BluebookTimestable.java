package second;

import java.util.Scanner;

public class BluebookTimestable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner (System.in);
		
		int N = SC.nextInt();
		int total = 0;
		for(int i=1; i<N+1; i++){
			total = N*i;
			System.out.println(N + "X"+ i + "=" + total);
		}
	}

}
