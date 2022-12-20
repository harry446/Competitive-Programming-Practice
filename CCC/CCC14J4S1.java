package second;

import java.util.LinkedList;
import java.util.Scanner;

public class CCC14J4S1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner SC = new Scanner(System.in);

		LinkedList<Integer> l = new LinkedList<Integer>();

		int K = SC.nextInt();
		for (int i=1; i<=K; i++){
			l.add(i);
		}

		int m = SC.nextInt();
		for (int i=0; i<m; i++){
			//i+1 is the position for the number
			int r = SC.nextInt();
			int size = l.size();
			for (int j=size; j>=0; j--){
				if (i+1%r==0){
					l.remove(i+1);
				}
			}

		}
	}

}
